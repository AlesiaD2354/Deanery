package com.example.beauty;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String URL = "jdbc:mysql://localhost:3306/Deanery";
    private static final String USER = "Alesia";
    private static final String PASSWORD = "123456789";

    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextPassword);

        Button loginButton = findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                new LoginTask().execute(username, password);
            }
        });
    }

    private class LoginTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {
            String username = params[0];
            String password = params[1];

            // Проверяем, соответствуют ли введенные имя пользователя и пароль константам
            return USER.equals(username) && PASSWORD.equals(password);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                // Аутентификация прошла успешно, запускаем основную активность приложения
                Toast.makeText(MainActivity.this, "Авторизация успешна", Toast.LENGTH_SHORT).show();

                // Start the new activity
                Intent intent = new Intent(MainActivity.this, deanery_main.class);
                startActivity(intent);

                // Завершение текущего действия (необязательно)
                finish();
            } else {
                Toast.makeText(MainActivity.this, "\n" + "Ошибка входа", Toast.LENGTH_SHORT).show();
            }
        }
    }
    }

