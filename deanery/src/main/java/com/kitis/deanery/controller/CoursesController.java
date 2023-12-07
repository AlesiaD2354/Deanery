package com.kitis.deanery.controller;

import com.kitis.deanery.model.Course;
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

public class CoursesController implements Initializable {
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private TableColumn<Course, String> colDiploma;

    @FXML
    private TableColumn<Course, String> colDiscipline;

    @FXML
    private TableColumn<Course, String> colExams;

    @FXML
    private TableColumn<Course, String> colGroup;

    @FXML
    private TableColumn<Course, String> colId;

    @FXML
    private TableColumn<Course, String> colIntership;

    @FXML
    private TableColumn<Course, String> colPractice;

    @FXML
    private TableColumn<Course, String> colSession;

    @FXML
    private TableView<Course> tblData;

    public static TableView<Course> editTable;

    public ObservableList<Course> dataTable = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        editTable = tblData;
        initTable();

        loadAllData();

        btnAdd.setOnAction(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/add-course.fxml"));
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
            ResultSet rs = statement.executeQuery("SELECT * FROM courses");
            while (rs.next()) dataTable.add(new Course(rs.getString("id"),
                    rs.getString("subjectName"),
                    rs.getString("session"),
                    rs.getString("exams"),
                    rs.getString("practice"),
                    rs.getString("internship"),
                    rs.getString("diploma"),
                    rs.getString("groupName")));
            tblData.setItems(dataTable);
            if(statement != null) statement.close();
            connectDB.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initTable() {
        initCols();
    }

    private void initCols() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDiscipline.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        colSession.setCellValueFactory(new PropertyValueFactory<>("session"));
        colExams.setCellValueFactory(new PropertyValueFactory<>("exams"));
        colPractice.setCellValueFactory(new PropertyValueFactory<>("practice"));
        colIntership.setCellValueFactory(new PropertyValueFactory<>("internship"));
        colDiploma.setCellValueFactory(new PropertyValueFactory<>("diploma"));
        colGroup.setCellValueFactory(new PropertyValueFactory<>("groupName"));
    }

    private void deleteRecord(String id) throws ClassNotFoundException, SQLException {
        try {
            DBConnector dbConnector = new DBConnector();
            Connection connectDB = dbConnector.dbConnect();
            Statement statement = connectDB.createStatement();
            statement.executeUpdate("DELETE FROM courses WHERE id = "+id+"");
            if(statement != null) statement.close();
            connectDB.close();
        } catch (SQLException e) {
            System.out.println("Exception occur while deleting the data" + e);
            throw e;
        }
    }
}
