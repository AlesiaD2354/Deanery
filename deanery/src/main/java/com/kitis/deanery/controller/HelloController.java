package com.kitis.deanery.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button btnOpenTeachers;

    @FXML
    private Button btnOpenStudents;

    @FXML
    private Button btnOpenCourses;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnOpenTeachers.setOnAction(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/teachers.fxml"));
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.setTitle("Учителя");
                stage.show();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        });

        btnOpenStudents.setOnAction(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/students.fxml"));
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.setTitle("Студенты");
                stage.show();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        });

        btnOpenCourses.setOnAction(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/courses.fxml"));
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.setTitle("Курсы");
                stage.show();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        });
    }
}