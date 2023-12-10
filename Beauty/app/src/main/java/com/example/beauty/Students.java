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
import java.util.ArrayList;
import java.util.List;

public class Students extends AppCompatActivity {
    private List<Stud> studentsList;
    private ArrayAdapter<Stud> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        studentsList = new ArrayList<>();
        studentsList.add(new Stud("Александр", "Соболь", "Витальевич", 2003, "С19-2"));
        studentsList.add(new Stud("Алеся", "Дубицкая", "Александровна", 2004, "Исп20-1"));
        studentsList.add(new Stud("Марина", "Губанова", "Алексеевна", 2004, "Исп20-1"));
        studentsList.add(new Stud("Елена", "Кузнецова", "Дмитриевна", 2002, "С19-2"));
        studentsList.add(new Stud("Максим", "Смирнов", "Александрович", 2000, "Исп20-1"));
        studentsList.add(new Stud("Ольга", "Морозова", "Алексеевна", 1999, "С19-2"));
        studentsList.add(new Stud("Дмитрий", "Павлов", "Андреевич", 2005, "Исп20-1"));
        studentsList.add(new Stud("Мария", "Васильева", "Сергеевна", 2002, "С19-1"));
        studentsList.add(new Stud("Сергей", "Федоров", "Владимирович", 2000, "Исп20-1"));
        studentsList.add(new Stud("Александра", "Егорова", "Александровна", 1999, "С19-2"));
        studentsList.add(new Stud("Алексей", "Николаев", "Сергеевич", 2005, "Исп20-1"));
        studentsList.add(new Stud("Татьяна", "Петрова", "Ивановна", 2002, "С19-2"));
        studentsList.add(new Stud("Евгений", "Семенов", "Дмитриевич", 2000, "Исп20-1"));
        studentsList.add(new Stud("Ангелина", "Григорьева", "Андреевна", 1999, "С19-2"));
        studentsList.add(new Stud("Виктор", "Алексеев", "Владимирович", 2001, "Исп20-1"));
        studentsList.add(new Stud("Юлия", "Андреева", "Сергеевна", 2004, "С19-2"));
        studentsList.add(new Stud("Артем", "Степанов", "Иванович", 2004, "Исп20-1"));
        studentsList.add(new Stud("София", "Фомина", "Петровна", 1999, "С19-2"));
        studentsList.add(new Stud("Ирина", "Максимова", "Дмитриевна", 2001, "Исп20-1"));
        studentsList.add(new Stud("Владимир", "Дмитриев", "Александрович", 2002, "С19-2"));


        ListView listView = findViewById(R.id.listView);
        // Регистрация контекстного меню для списка
        registerForContextMenu(listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentsList);
        listView.setAdapter(adapter);

        Button addButton = findViewById(R.id.btnAdd);
        addButton.setOnClickListener(v -> showAddStudentsDialog());
    }

    private void showAddStudentsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Добавление нового студента");

        View view = getLayoutInflater().inflate(R.layout.dialog_add_students, null);
        builder.setView(view);

        final EditText etfirst_name = view.findViewById(R.id.etfirst_name);
        final EditText etlast_name = view.findViewById(R.id.etlast_name);
        final EditText etsurname = view.findViewById(R.id.etsurname);
        final EditText etbirth_year = view.findViewById(R.id.etbirth_year);
        final EditText etgroup_name = view.findViewById(R.id.etgroup_name);

        builder.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String first_name = etfirst_name.getText().toString();
                String last_name = etlast_name.getText().toString();
                String surname = etsurname.getText().toString();
                int birth_year = Integer.parseInt(etbirth_year.getText().toString());
                String group_name = etgroup_name.getText().toString();

                Stud newStudent = new Stud(first_name, last_name, surname, birth_year, group_name);
                studentsList.add(newStudent);
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
        Intent intent = new Intent(Students.this, deanery_main.class);
        startActivity(intent);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.listView) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.setHeaderTitle("Хотите удалить?");
            // Добавление опции для удаления студента
            menu.add(Menu.NONE, 1, Menu.NONE, "Удалить студента");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        switch (item.getItemId()) {
            case 1: // ID для опции удаления студента
                // Удаление студента из списка по позиции
                studentsList.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}

