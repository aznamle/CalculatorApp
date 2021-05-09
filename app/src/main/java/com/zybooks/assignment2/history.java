package com.zybooks.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.content.Intent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class history extends AppCompatActivity {
    private static final String FILE_NAME = "results.txt";
    TextView header, history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        history = findViewById(R.id.history);

        Intent intent = new Intent();

        try {
            FileInputStream input = openFileInput(FILE_NAME);
            int count;
            String historylist = "";

            while((count = input.read())!= -1) {
                historylist = historylist + Character.toString((char)count);
            }
            history.setText(historylist);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}