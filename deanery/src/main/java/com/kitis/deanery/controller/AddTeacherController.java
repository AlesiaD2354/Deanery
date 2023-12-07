package com.kitis.deanery.controller;

import com.kitis.deanery.model.Teacher;
import com.kitis.deanery.util.DBConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AddTeacherController implements Initializable {
    @FXML
    private Button btnAdd;

    @FXML
    private TextField txtDiscipline;

    @FXML
    private TextField txtFathername;

    @FXML
    private TextField txtFirstname;

    @FXML
    private TextField txtSurname;

    public static ObservableList<Teacher> data_table = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAdd.setOnAction(e -> {
            if(!txtFirstname.getText().equals("")
                    && !txtSurname.getText().equals("")
                    && !txtFathername.getText().equals("")
                    && !txtDiscipline.getText().equals("")) {
                try {
                    insertRecord(txtFirstname.getText(), txtSurname.getText(),
                            txtFathername.getText(), txtDiscipline.getText());
                    loadAllData();

                    Stage currentStage = (Stage) btnAdd.getScene().getWindow();
                    currentStage.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void insertRecord(String firstname, String surname, String fatherName, String discipline) throws SQLException, ClassNotFoundException {
        try {
            DBConnector dbConnector = new DBConnector();
            Connection connectDB = dbConnector.dbConnect();
            Statement statement = connectDB.createStatement();
            statement.executeUpdate("INSERT INTO teachers(first_name, last_name, surname, discipline) "
                    + "VALUES ('"+firstname+"','"+surname+"','"+fatherName+"','"+discipline+"')");
            if(statement != null) statement.close();
            connectDB.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Exception occur while inserting data" + e);
            e.printStackTrace();
            throw e;
        }
    }

    private void loadAllData() {
        try {
            data_table.clear();
            DBConnector dbConnector = new DBConnector();
            Connection connectDB = dbConnector.dbConnect();
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM teachers");
            if(statement != null) statement.close();
            connectDB.close();
            while (rs.next()) data_table.add(new Teacher(rs.getString("id"),
                    rs.getString("last_name"),
                    rs.getString("first_name"),
                    rs.getString("surname"),
                    rs.getString("discipline")));
            TeachersController.editTable.setItems(data_table);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
