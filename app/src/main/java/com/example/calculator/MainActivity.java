package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void sum(View view) {
        try {
            int num1 = Integer.parseInt(((EditText) findViewById(R.id.disp1)).getText().toString());
            int num2 = Integer.parseInt(((EditText) findViewById(R.id.disp2)).getText().toString());
            int sum = num1 + num2;
            ((TextView) findViewById(R.id.result)).setText(String.valueOf(sum));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_LONG).show();
        }
    }

    public void sub(View view) {
        try {
            int num1 = Integer.parseInt(((EditText) findViewById(R.id.disp1)).getText().toString());
            int num2 = Integer.parseInt(((EditText) findViewById(R.id.disp2)).getText().toString());
            int sub = num1 - num2;
            ((TextView) findViewById(R.id.result)).setText(String.valueOf(sub));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_LONG).show();
        }
    }

    public void mul(View view) {
        try {
            int num1 = Integer.parseInt(((EditText) findViewById(R.id.disp1)).getText().toString());
            int num2 = Integer.parseInt(((EditText) findViewById(R.id.disp2)).getText().toString());
            int mul = num1 * num2;
            ((TextView) findViewById(R.id.result)).setText(String.valueOf(mul));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_LONG).show();
        }
    }

    public void div(View view) {
        try {
            int num1 = Integer.parseInt(((EditText) findViewById(R.id.disp1)).getText().toString());
            int num2 = Integer.parseInt(((EditText) findViewById(R.id.disp2)).getText().toString());
            if (num2 == 0) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_LONG).show();
            } else {
                float div = (float) num1 / num2;
                ((TextView) findViewById(R.id.result)).setText(String.valueOf(div));
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_LONG).show();
        }
    }
}
