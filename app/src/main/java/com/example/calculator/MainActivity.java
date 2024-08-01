package com.example.calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
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
            showNullInputToast(R.layout.nullinput_toast);
        }
    }

    public void sub(View view) {
        try {
            int num1 = Integer.parseInt(((EditText) findViewById(R.id.disp1)).getText().toString());
            int num2 = Integer.parseInt(((EditText) findViewById(R.id.disp2)).getText().toString());
            int sub = num1 - num2;
            ((TextView) findViewById(R.id.result)).setText(String.valueOf(sub));
        } catch (NumberFormatException e) {
            showNullInputToast(R.layout.nullinput_toast);
        }
    }

    public void mul(View view) {
        try {
            int num1 = Integer.parseInt(((EditText) findViewById(R.id.disp1)).getText().toString());
            int num2 = Integer.parseInt(((EditText) findViewById(R.id.disp2)).getText().toString());
            int mul = num1 * num2;
            ((TextView) findViewById(R.id.result)).setText(String.valueOf(mul));
        } catch (NumberFormatException e) {
            showNullInputToast(R.layout.nullinput_toast);
        }
    }

    public void div(View view) {
        try {
            int num1 = Integer.parseInt(((EditText) findViewById(R.id.disp1)).getText().toString());
            int num2 = Integer.parseInt(((EditText) findViewById(R.id.disp2)).getText().toString());
            if (num2 == 0) {
                showNullInputToast(R.layout.zero_devide);
            } else {
                float div = (float) num1 / num2;
                ((TextView) findViewById(R.id.result)).setText(String.valueOf(div));
            }
        } catch (NumberFormatException e) {
            showDividebyZeroToast(R.layout.nullinput_toast);
        }
    }

    private void showNullInputToast(int layoutId) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(layoutId, findViewById(R.id.nullinput));
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    private void showDividebyZeroToast(int layoutId) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(layoutId, findViewById(R.id.zero_devide));
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
