package com.example.beauty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class deanery_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deanery_main);

    }

    public void one(View view) {
        Intent intent = new Intent(deanery_main.this, Students.class);
        startActivity(intent);

    }

    public void two(View view) {
        Intent intent = new Intent(deanery_main.this, Teachers.class);
        startActivity(intent);
    }
    public void five(View view) {
        Intent intent = new Intent(deanery_main.this, Courses.class);
        startActivity(intent);
    }

}
