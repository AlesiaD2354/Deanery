package com.kitis.deanery.controller;

import com.kitis.deanery.model.Student;
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

import static com.kitis.deanery.controller.AddTeacherController.data_table;

public class AddStudentController implements Initializable {
    @FXML
    private Button btnAdd;

    @FXML
    private TextField txtBirthYear;

    @FXML
    private TextField txtFathername;

    @FXML
    private TextField txtFirstname;

    @FXML
    private TextField txtGroup;

    @FXML
    private TextField txtSurname;

    public static ObservableList<Student> studentDataTable = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAdd.setOnAction(e -> {
            if(!txtFirstname.getText().equals("") && !txtSurname.getText().equals("")
                    && !txtFathername.getText().equals("") && !txtBirthYear.getText().equals("")
                    && !txtGroup.getText().equals("")) {
                try {
                    insertRecord(txtFirstname.getText(), txtSurname.getText(),
                            txtFathername.getText(), txtBirthYear.getText(),
                            txtGroup.getText());
                    loadAllData();

                    Stage currentStage = (Stage) btnAdd.getScene().getWindow();
                    currentStage.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void insertRecord(String firstname, String surname, String fatherName, String birthYear, String group) throws SQLException, ClassNotFoundException {
        try {
            DBConnector dbConnector = new DBConnector();
            Connection connectDB = dbConnector.dbConnect();
            Statement statement = connectDB.createStatement();
            statement.executeUpdate("INSERT INTO students(first_name, last_name, surname, birth_year, group_name) "
                    + "VALUES ('"+firstname+"','"+surname+"','"+fatherName+"','"+birthYear+"','"+group+"')");
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
            studentDataTable.clear();
            DBConnector dbConnector = new DBConnector();
            Connection connectDB = dbConnector.dbConnect();
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM students");
            if(statement != null) statement.close();
            connectDB.close();
            while (rs.next()) studentDataTable.add(new Student(rs.getString("id"),
                    rs.getString("last_name"),
                    rs.getString("first_name"),
                    rs.getString("surname"),
                    rs.getString("birth_year"),
                    rs.getString("group_name")));
            StudentsController.editTable.setItems(studentDataTable);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
