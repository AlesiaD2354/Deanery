package com.example.beauty;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Courses extends AppCompatActivity {
    private List<Cour> coursesList;
    private ArrayAdapter<Cour> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        coursesList = new ArrayList<>();
        coursesList.add(new Cour("Математика",
                new SessionDateRange(LocalDate.of(2023, 12, 23), LocalDate.of(2023, 12, 30)), LocalDate.of(2025, 5, 28),
                new PracticeDateRange(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 10)),
                new InternshipDateRange(LocalDate.of(2024, 4, 3), LocalDate.of(2024, 5, 3)),
                LocalDate.of(2023, 6, 30), "Исп20-1"));
        coursesList.add(new Cour("Английский язык",
        new SessionDateRange(LocalDate.of(2024, 6, 14), LocalDate.of(2024, 6, 21)), LocalDate.of(2024, 6, 1),
                new PracticeDateRange(LocalDate.of(2024, 1, 11), LocalDate.of(2024, 1, 30)),
                new InternshipDateRange(LocalDate.of(2024, 5, 4), LocalDate.of(2024, 5, 29)),
                LocalDate.of(2023, 6, 30), "С19-2"));
        coursesList.add(new Cour("Системное программирование",
                new SessionDateRange(LocalDate.of(2023, 12, 23), LocalDate.of(2023, 12, 30)), LocalDate.of(2023, 12, 25),
                new PracticeDateRange(LocalDate.of(2024, 2, 14), LocalDate.of(2024, 2, 24)),
                new InternshipDateRange(LocalDate.of(2024, 6, 11), LocalDate.of(2024, 6, 25)),
                LocalDate.of(2023, 6, 30), "Исп20-1"));
        coursesList.add(new Cour("Социология",
                new SessionDateRange(LocalDate.of(2024, 9, 9), LocalDate.of(2024, 9, 16)), LocalDate.of(2024, 6, 20),
                new PracticeDateRange(LocalDate.of(2023, 10, 30), LocalDate.of(2023, 11, 10)),
                new InternshipDateRange(LocalDate.of(2024, 5, 1), LocalDate.of(2024, 6, 20)),
                LocalDate.of(2023, 6, 30), "Исп20-1"));
        coursesList.add(new Cour("Лингвистика",
                new SessionDateRange(LocalDate.of(2024, 2, 2), LocalDate.of(2024, 2, 9)), LocalDate.of(2024, 7, 10),
                new PracticeDateRange(LocalDate.of(2023, 12, 18), LocalDate.of(2023, 12, 25)),
                new InternshipDateRange(LocalDate.of(2024, 5, 15), LocalDate.of(2024, 6, 5)),
                LocalDate.of(2023, 6, 30), "С23-1К"));
        coursesList.add(new Cour("Логика",
                new SessionDateRange(LocalDate.of(2023, 10, 26), LocalDate.of(2023, 11, 2)), LocalDate.of(2024, 6, 15),
                new PracticeDateRange(LocalDate.of(2024, 1, 5), LocalDate.of(2024, 1, 15)),
                new InternshipDateRange(LocalDate.of(2024, 4, 20), LocalDate.of(2024, 5, 10)),
                LocalDate.of(2023, 6, 30), "Исп20-1"));
        System.out.println(coursesList);
        ListView listView = findViewById(R.id.listView);
        // Регистрация контекстного меню для списка
        registerForContextMenu(listView);
        CourAdapter courAdapter = new CourAdapter(this, coursesList);
        listView.setAdapter(courAdapter);

        Button addButton = findViewById(R.id.btnAdd);

        addButton.setOnClickListener(v -> showAddCoursesDialog());
    }

    private void showAddCoursesDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Добавление нового курса");

        View view = getLayoutInflater().inflate(R.layout.dialog_add_courses, null);
        builder.setView(view);

        final EditText etsubjectName = view.findViewById(R.id.etsubjectName);
        final EditText etsession = view.findViewById(R.id.etsession);
        final EditText etexams = view.findViewById(R.id.etexams);
        final EditText etpractice = view.findViewById(R.id.etpractice);
        final EditText etinternship = view.findViewById(R.id.etinternship);
        final EditText etdiploma = view.findViewById(R.id.etdiploma);
        final EditText etgroupName = view.findViewById(R.id.etgroupName);

        builder.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                adapter.notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void back(View view) {
        Intent intent = new Intent(Courses.this, deanery_main.class);
        startActivity(intent);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.listView) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.setHeaderTitle("Хотите удалить?");
            // Добавление опции для удаления курса
            menu.add(Menu.NONE, 1, Menu.NONE, "Удалить курс");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        switch (item.getItemId()) {
            case 1: // ID для опции удаления курса
                // Удаление курса из списка по позиции
                coursesList.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
