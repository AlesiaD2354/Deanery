package com.kitis.deanery.controller;

import com.kitis.deanery.model.Student;
import com.kitis.deanery.model.Teacher;
import com.kitis.deanery.util.DBConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class StudentsController implements Initializable {
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private TableColumn<Student, String> colBirthYear;

    @FXML
    private TableColumn<Student, String> colFathername;

    @FXML
    private TableColumn<Student, String> colFirstname;

    @FXML
    private TableColumn<Student, String> colGroup;

    @FXML
    private TableColumn<Student, String> colId;

    @FXML
    private TableColumn<Student, String> colSurname;

    @FXML
    private TableView<Student> tblData;

    public static TableView<Student> editTable;

    public ObservableList<Student> dataTable = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        editTable = tblData;
        initTable();

        loadAllData();

        btnAdd.setOnAction(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/add-student.fxml"));
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.setTitle("Добавление записи");
                stage.show();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        });

        btnDelete.setOnAction(event -> {
            try {
                deleteRecord(tblData.getSelectionModel().getSelectedItem().getId());
                loadAllData();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private void loadAllData() {
        try {
            dataTable.clear();
            DBConnector dbConnector = new DBConnector();
            Connection connectDB = dbConnector.dbConnect();
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM students");
            while (rs.next()) dataTable.add(new Student(rs.getString("id"),
                    rs.getString("last_name"),
                    rs.getString("first_name"),
                    rs.getString("surname"),
                    rs.getString("birth_year"),
                    rs.getString("group_name")));
            tblData.setItems(dataTable);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initTable() {
        initCols();
    }

    private void initCols() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colSurname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colFirstname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colFathername.setCellValueFactory(new PropertyValueFactory<>("surname"));
        colBirthYear.setCellValueFactory(new PropertyValueFactory<>("birthYear"));
        colGroup.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
    }

    private void deleteRecord(String id) throws ClassNotFoundException, SQLException {
        try {
            DBConnector dbConnector = new DBConnector();
            Connection connectDB = dbConnector.dbConnect();
            Statement statement = connectDB.createStatement();
            statement.executeUpdate("DELETE FROM students WHERE id = "+id+"");
            if(statement != null) statement.close();
            connectDB.close();
        } catch (SQLException e) {
            System.out.println("Exception occur while deleting the data" + e);
            throw e;
        }
    }
}
