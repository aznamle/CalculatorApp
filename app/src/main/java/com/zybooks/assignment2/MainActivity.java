package com.zybooks.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.*;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "results.txt";

    TextView input, output;
    String process, calculation, result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);


    }


    public void zeroBTN (View view) {
        process = input.getText().toString();
        input.setText(process + "0");

    }

    public void oneBTN (View view) {
        process = input.getText().toString();
        input.setText(process + "1");
    }

    public void twoBTN (View view) {
        process = input.getText().toString();
        input.setText(process + "2");
    }

    public void threeBTN (View view) {
        process = input.getText().toString();
        input.setText(process + "3");

    }

    public void fourBTN (View view) {
        process = input.getText().toString();
        input.setText(process + "4");

    }

    public void fiveBTN (View view) {
        process = input.getText().toString();
        input.setText(process + "5");

    }

    public void sixBTN (View view) {
        process = input.getText().toString();
        input.setText(process + "6");

    }

    public void sevenBTN (View view) {
        process = input.getText().toString();
        input.setText(process + "7");

    }

    public void eightBTN (View view) {
        process = input.getText().toString();
        input.setText(process + "8");

    }

    public void nineBTN (View view) {
        process = input.getText().toString();
        input.setText(process + "9");

    }

    public void clearBTN (View view) {
        input.setText("");
        output.setText("");
    }

    public void historyBTN (View view) {
        Intent intent = new Intent(MainActivity.this, history.class);
        intent.putExtra("FILE_NAME", FILE_NAME);
        startActivity(intent);
    }

    public void divideBTN (View view) {
        process = input.getText().toString();
        if(process.endsWith("÷")) {
            input.setText(process + "");
        } else if(process.endsWith("-")) {
            input.setText(process + "");
        } else if(process.endsWith("+")) {
            input.setText(process + "");
        } else if(process.endsWith("x")) {
            input.setText(process + "");
        } else if(process.endsWith("%")) {
            input.setText(process + "");
        } else {
            input.setText(process + "÷");
        }
    }

    public void backspaceBTN (View view) {
        int cursorPos = input.getSelectionStart();
        process = input.getText().toString();

        if (process.length() >1) {
            process = process.substring(0,process.length()-1);
            input.setText(process);
        } else if (process.length() <=1) {
            input.setText("");
        }
    }

    public void multiplyBTN (View view) {
        process = input.getText().toString();
        if(process.endsWith("x")) {
            input.setText(process + "");
        } else if(process.endsWith("-")) {
            input.setText(process + "");
        } else if(process.endsWith("+")) {
            input.setText(process + "");
        } else if(process.endsWith("÷")) {
            input.setText(process + "");
        } else if(process.endsWith("%")) {
            input.setText(process + "");
        } else {
            input.setText(process + "x");
        }

    }

    public void minusBTN (View view) {
        process = input.getText().toString();
        if(process.endsWith("-")) {
            input.setText(process + "");
        } else if(process.endsWith("x")) {
            input.setText(process + "");
        } else if(process.endsWith("+")) {
            input.setText(process + "");
        } else if(process.endsWith("÷")) {
            input.setText(process + "");
        } else if(process.endsWith("%")) {
            input.setText(process + "");
        } else {
            input.setText(process + "-");
        }

    }

    public void addBTN (View view) {
        process = input.getText().toString();
        if(process.endsWith("+")) {
            input.setText(process + "");
        } else if(process.endsWith("-")) {
            input.setText(process + "");
        } else if(process.endsWith("x")) {
            input.setText(process + "");
        } else if(process.endsWith("÷")) {
            input.setText(process + "");
        } else if(process.endsWith("%")) {
            input.setText(process + "");
        } else {
            input.setText(process + "+");
        }

    }

    public void plusMinusBTN (View view) {
        process = input.getText().toString();

        Expression exp = new Expression("(" + process + ")*(-1)");
        String r = String.valueOf(exp.calculate());
        input.setText("-(" + process + ")");
    }

    public void pointBTN (View view) {
        process = input.getText().toString();
        if(process.endsWith(".")) {
            input.setText(process + "");
        } else {
            input.setText(process + ".");
        }

    }

    public void percentBTN (View view) {
        process = input.getText().toString();
        if(!process.isEmpty() & !process.endsWith("x") & !process.endsWith("-") & !process.endsWith("+") & !process.endsWith("÷") & !process.endsWith("%")) {
            input.setText(process + "%");
        } else {
            input.setText(process+ "");
        }
    }

    public void squarerootBTN (View view) {
        process = input.getText().toString();
        if(!process.isEmpty() & !process.contains("sqrt(") & !process.contains("x") & !process.contains("-") & !process.contains("+") & !process.contains("÷") & !process.contains("%")) {
            double r = Math.sqrt(Double.parseDouble(process));
            input.setText("sqrt(" + process + ")");
            output.setText(String.valueOf(r));

            saveResults();
        }

    }

    public void xsquaredBTN (View view) {
        process = input.getText().toString();
        input.setText(process + "^(2)");

    }

    public void inverseBTN (View view) {
        process = input.getText().toString();
        input.setText(process+"^(-1)");
    }


    public void equalsBTN (View view) {

        String userExp = input.getText().toString();

        userExp = userExp.replaceAll("x", "*");
        userExp = userExp.replaceAll("÷","/");

        Expression exp = new Expression(userExp);

        result = String.valueOf(exp.calculate());

        output.setText(result);
        saveResults();

    }

    public void saveResults() {
        calculation = input.getText().toString();
        result = output.getText().toString();
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, MODE_APPEND);
            fos.write("\r\n".getBytes());
            fos.write(calculation.getBytes());
            fos.write(" = ".getBytes());
            fos.write(result.getBytes());
            Toast.makeText(this, "saved to " + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        //saved input
        String sInput = input.getText().toString();
        outState.putString("sInput", sInput);

        //saved output
        String sOutput = output.getText().toString();
        outState.putString("sOutput", sOutput);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //restore input and output
        input.setText(savedInstanceState.getString("sInput"));
        output.setText(savedInstanceState.getString("sOutput"));
    }

}