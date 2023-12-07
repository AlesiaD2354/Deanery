package com.kitis.deanery.controller;

import com.kitis.deanery.model.Course;
import com.kitis.deanery.model.Student;
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

public class AddCourseController implements Initializable {
    @FXML
    private Button btnAdd;

    @FXML
    private TextField txtDiploma;

    @FXML
    private TextField txtDiscipline;

    @FXML
    private TextField txtExams;

    @FXML
    private TextField txtGroup;

    @FXML
    private TextField txtInternship;

    @FXML
    private TextField txtPractice;

    @FXML
    private TextField txtSession;

    public static ObservableList<Course> courseDataTable = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAdd.setOnAction(e -> {
            if(!txtDiscipline.getText().equals("")
                    && !txtSession.getText().equals("")
                    && !txtExams.getText().equals("")
                    && !txtPractice.getText().equals("")
                    && !txtInternship.getText().equals("")
                    && !txtDiploma.getText().equals("")
                    && !txtGroup.getText().equals("")) {
                try {
                    insertRecord(txtDiscipline.getText(), txtSession.getText(),
                            txtExams.getText(), txtPractice.getText(),
                            txtInternship.getText(), txtDiploma.getText(),
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

    public void insertRecord(String subjectName, String session,
                             String exams, String practice,
                             String internship, String diploma,
                             String groupName) throws SQLException, ClassNotFoundException {
        try {
            DBConnector dbConnector = new DBConnector();
            Connection connectDB = dbConnector.dbConnect();
            Statement statement = connectDB.createStatement();
            statement.executeUpdate("INSERT INTO courses(subjectName, session, exams, practice, internship, diploma, groupName) "
                    + "VALUES ('"+subjectName+"','"+session+"','"+exams+"','"+practice+"','"+internship+"','"+diploma+"','"+groupName+"')");
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
            courseDataTable.clear();
            DBConnector dbConnector = new DBConnector();
            Connection connectDB = dbConnector.dbConnect();
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM courses");
            while (rs.next()) courseDataTable.add(new Course(rs.getString("id"),
                    rs.getString("subjectName"),
                    rs.getString("session"),
                    rs.getString("exams"),
                    rs.getString("practice"),
                    rs.getString("internship"),
                    rs.getString("diploma"),
                    rs.getString("groupName")));
            CoursesController.editTable.setItems(courseDataTable);
            if(statement != null) statement.close();
            connectDB.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
