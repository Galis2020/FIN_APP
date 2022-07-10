package com.example.fin_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    ListView listview;
    ArrayList list;
    Button addButton;
    EditText editText;
    Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listview = (ListView) findViewById(R.id.listView);
        addButton = (Button) findViewById(R.id.add);
        editText = (EditText) findViewById(R.id.addTask);
        deleteButton = (Button) findViewById(R.id.delete);
        list = new ArrayList<String>();

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
                if (list.size() > 0) {
                    if (!editText.getText().toString().isEmpty()) {
                        list.remove(editText.getText().toString());
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }}