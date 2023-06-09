package com.example.a70_lolkek;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Comparator;

public class AddToPillboxActivity extends AppCompatActivity {
    private EditText dosage_type, pill_name, tablets_amount, best_before;
    private Button go_back, save_button;
    FloatingActionButton pills, drops, teaspoon, spoon, syringe, more;

    boolean clickedImage = false;
    Context context;
    String[] types = {"таблетка", "капля", "ложка", "шт", "шприц", "мл", "гр"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_pillbox);
        initWidgets();
        context = this;

        pills.setOnClickListener(view -> {
            pills.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.tablets_color)));
            drops.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            teaspoon.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            spoon.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            syringe.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            more.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            dosage_type.setText(types[0]);
            clickedImage = true;
        });

        drops.setOnClickListener(view -> {
            pills.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            drops.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.tablets_color)));
            teaspoon.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            spoon.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            syringe.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            more.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            dosage_type.setText(types[1]);
            clickedImage = true;
        });

        teaspoon.setOnClickListener(view -> {
            pills.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            drops.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            teaspoon.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.tablets_color)));
            spoon.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            syringe.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            more.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            dosage_type.setText(types[2]);
            clickedImage = true;
        });

        spoon.setOnClickListener(view -> {
            pills.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            drops.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            teaspoon.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            spoon.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.tablets_color)));
            syringe.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            more.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            dosage_type.setText(types[2]);
            clickedImage = true;
        });

        syringe.setOnClickListener(view -> {
            pills.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            drops.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            teaspoon.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            spoon.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            syringe.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.tablets_color)));
            more.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            dosage_type.setText(types[4]);
            clickedImage = true;
        });

        more.setOnClickListener(view -> {
            pills.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            drops.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            teaspoon.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            spoon.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            syringe.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.non_tablets_color)));
            more.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.tablets_color)));
            dosage_type.setText(types[5]);
            clickedImage = true;
        });

        dosage_type.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Вид дозировки");
            builder.setItems(types, (dialog, which) -> {
                switch (which) {
                    case 0:
                        dosage_type.setText(types[0]);
                        break;
                    case 1:
                        dosage_type.setText(types[1]);
                        break;
                    case 2:
                        dosage_type.setText(types[2]);
                        break;
                    case 3:
                        dosage_type.setText(types[3]);
                        break;
                    case 4:
                        dosage_type.setText(types[4]);
                        break;
                    case 5:
                        dosage_type.setText(types[5]);
                        break;
                    case 6:
                        dosage_type.setText(types[6]);
                        break;
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        });

        best_before.setOnClickListener(v -> {
            // calender class's instance and get current date , month and year from calender
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR); // current year
            int mMonth = c.get(Calendar.MONTH); // current month
            int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

            /// вот тут чекнуть проверку на дату

            @SuppressLint("SetTextI18n") DatePickerDialog datePickerDialog = new DatePickerDialog(AddToPillboxActivity.this,
                    (view, year1, month1, dayOfMonth1) -> {
                        // Обновить текст поля ввода даты срока годности
                        Calendar end_calendar = Calendar.getInstance();
                        Calendar begin_calendar = Calendar.getInstance();
                        begin_calendar.set(mYear, mMonth, mDay);
                        end_calendar.set(year1, month1, dayOfMonth1);
                        LocalDate begin_local = LocalDateTime.ofInstant(begin_calendar.toInstant(), begin_calendar.getTimeZone().toZoneId()).toLocalDate();
                        LocalDate end_local = LocalDateTime.ofInstant(end_calendar.toInstant(), end_calendar.getTimeZone().toZoneId()).toLocalDate();
                        long days_number = ChronoUnit.DAYS.between(begin_local, end_local);
                        if (days_number > 0) {
                            String last_day = "" + dayOfMonth1 / 10 + dayOfMonth1 % 10 + "." + (month1 + 1) / 10 + (month1 + 1) % 10 + "." + year1 / 10 + year1 % 10;
                            best_before.setText(last_day);
                        } else {
                            Toast.makeText(AddToPillboxActivity.this, "Пожалуйста, введите корректную дату срока годности", Toast.LENGTH_SHORT).show();
                        }
                    }, mYear, mMonth, mDay);
            // Отображаем DatePickerDialog
            datePickerDialog.show();
        });

        save_button.setOnClickListener(view -> {
            String name = pill_name.getText().toString();
            String dosage = dosage_type.getText().toString();
            String best = best_before.getText().toString();
            String amount = tablets_amount.getText().toString();

            if (name.matches("")) {
                Toast.makeText(view.getContext(), "Вы не ввели название лекарства", Toast.LENGTH_SHORT).show();
                return;
            } else if (!clickedImage) {
                Toast.makeText(view.getContext(), "Вы не выбрали вид лекарства", Toast.LENGTH_SHORT).show();
                return;
            } else if (dosage.matches("")) {
                Toast.makeText(view.getContext(), "Вы не выбрали вид дозировки", Toast.LENGTH_SHORT).show();
                return;
            } else if (best.matches("")) {
                Toast.makeText(view.getContext(), "Вы не ввели окончание срока годности", Toast.LENGTH_SHORT).show();
                return;
            } else if (amount.matches("")) {
                Toast.makeText(view.getContext(), "Вы не ввели кол-во таблеток", Toast.LENGTH_SHORT).show();
                return;
            }
            int finalAmount = Integer.parseInt(amount);
            Pill newPill = new Pill(name, dosage, best, finalAmount);
            Pill.pillBox.add(newPill);

            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Pills", MODE_PRIVATE);
            int size = sharedPreferences.getInt("Size", 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Name_" + size, name);
            editor.putString("Dosage_" + size, dosage);
            editor.putString("Best_" + size, best);
            editor.putInt("FinalAmount_" + size, finalAmount);
            editor.putInt("Size", size + 1);
            editor.apply();

            Pill.pillBox.sort(Comparator.comparing(Pill::getName));

            Intent intent = new Intent(AddToPillboxActivity.this, PillsActivity.class);
            startActivity(intent);
        });

        go_back.setOnClickListener(view -> {
            Intent intent = new Intent(AddToPillboxActivity.this, PillsActivity.class);
            startActivity(intent);
        });
    }

    private void initWidgets() {
        pill_name = findViewById(R.id.pill_name);
        dosage_type = findViewById(R.id.dosage_type);
        best_before = findViewById(R.id.best_before);
        tablets_amount = findViewById(R.id.tablets_amount);

        go_back = findViewById(R.id.go_back);
        save_button = findViewById(R.id.save_button);

        pills = findViewById(R.id.pills);
        drops = findViewById(R.id.drops);
        teaspoon = findViewById(R.id.teaspoon);
        spoon = findViewById(R.id.spoon);
        syringe = findViewById(R.id.syringe);
        more = findViewById(R.id.more);
    }
}