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

public class Teachers extends AppCompatActivity {
    private List<Teac> teachersList;
    private ArrayAdapter<Teac> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);


//Предполагая, что список преподавателей является полем класса
        teachersList = new ArrayList<>();
        teachersList.add(new Teac("Полина", "Мельникова", "Андреевна", "Математика"));
        teachersList.add(new Teac("Мария", "Петрова", "Алексеевна", "Английский язык"));
        teachersList.add(new Teac("Алексей", "Вахитов", "Андреевич", "Системное программирование"));
        teachersList.add(new Teac("Иван", "Смирнов", "Петрович", "Химия"));
        teachersList.add(new Teac("Екатерина", "Кузнецова", "Игоревна", "Биология"));
        teachersList.add(new Teac("Виктория", "Соколова", "Александровна", "История"));
        teachersList.add(new Teac("Григорий", "Михайлов", "Павлович", "Литература"));
        teachersList.add(new Teac("Елизавета", "Новикова", "Ильинична", "Психология"));
        teachersList.add(new Teac("Дмитрий", "Андреев", "Евгеньевич", "География"));
        teachersList.add(new Teac("Захар", "Семенов", "Алесандрович", "Физкультура"));
        teachersList.add(new Teac("Ирина", "Егорова", "Николаевна", "Философия"));
        teachersList.add(new Teac("Леонид", "Козлов", "Иванович", "Информатика"));
        teachersList.add(new Teac("Марина", "Федорова", "Павловна", "Тетральное искусство"));
        teachersList.add(new Teac("Никита", "Сорокин", "Игоревич", "Музыка"));
        teachersList.add(new Teac("Олег", "Макаров", "Николаевич", "Политология"));
        teachersList.add(new Teac("Полина", "Белова", "Владимировна", "Бизнес-анализ"));
        teachersList.add(new Teac("Роман", "Григорьев", "Петрович", "Маркетинг"));
        teachersList.add(new Teac("София", "Логинова", "Максимовна", "Социология"));
        teachersList.add(new Teac("Александр", "Павлов", "Владимирович", "Лингвистика"));
        teachersList.add(new Teac("Виктория", "Соколова", "Александровна", "Логика"));

        ListView listView = findViewById(R.id.listView);
        // Регистрация контекстного меню для списка
        registerForContextMenu(listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, teachersList);
        listView.setAdapter(adapter);

        Button addButton = findViewById(R.id.btnAdd);

        // Устанавливаем прослушиватель кликов для обработки добавления нового преподавателя
        addButton.setOnClickListener(v -> showAddTeachersDialog());
    }

    private void showAddTeachersDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Добавление нового преподавателя");

        // Раздуваем макет диалога
        View view = getLayoutInflater().inflate(R.layout.dialog_add_teachers, null);
        builder.setView(view);

        final EditText etfirst_name = view.findViewById(R.id.etfirst_name);
        final EditText etlast_name = view.findViewById(R.id.etlast_name);
        final EditText etsurname = view.findViewById(R.id.etsurname);
        final EditText etdiscipline = view.findViewById(R.id.etdiscipline);

        builder.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String first_name = etfirst_name.getText().toString();
                String last_name = etlast_name.getText().toString();
                String surname = etsurname.getText().toString();
                String discipline = etdiscipline.getText().toString();

                // Добавляем нового преподавателя в список
                Teac newTeachers = new Teac(first_name, last_name, surname, discipline);
                teachersList.add(newTeachers);

                // Сообщаем адаптеру, что набор данных изменился
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
        Intent intent = new Intent(Teachers.this, deanery_main.class);
        startActivity(intent);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.listView) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.setHeaderTitle("Хотите удалить?");
            // Добавление опции для удаления преподавателя
            menu.add(Menu.NONE, 1, Menu.NONE, "Удалить преподавателя");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        switch (item.getItemId()) {
            case 1: // ID для опции удаления преподавателя
                // Удаление преподавателя из списка по позиции
                teachersList.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
