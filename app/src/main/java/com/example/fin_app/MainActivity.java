package com.example.fin_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    ListView listview;
    ArrayList list;
    Button addButton;
    EditText editText;
    Button deleteButton;
    EditText dueDate;
    Calendar calendar = Calendar.getInstance();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listview = (ListView) findViewById(R.id.listView);
        addButton = (Button) findViewById(R.id.add);
        editText = (EditText) findViewById(R.id.addTask);
        deleteButton = (Button) findViewById(R.id.delete);
        dueDate = (EditText) findViewById(R.id.calendar);
        list = new ArrayList<String>();

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, list);

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String item = editText.getText().toString();
                list.add(item);
                listview.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.size() >= 0) {
                    if (!editText.getText().toString().isEmpty()) {
                        list.remove(editText.getText().toString());
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dueDate.setText(month + "/" + dayOfMonth + "/" + year);
            }
        }, year, month, day);
        datePickerDialog.show();

    }}