package com.example.grocemate2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class customer_activity extends AppCompatActivity {

    private int loginCount = 0;
    private TextView textViewWelcome;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button login = findViewById(R.id.login);
        TextView textView = findViewById(R.id.textView);
        EditText editTextName = findViewById(R.id.editTextName);
        textViewWelcome = findViewById(R.id.textViewWelcome);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.customer_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                loginCount++;
                textView.setText("YOU HAVE LOGGED IN " + loginCount + " TIMES ");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(customer_activity.this, Music.class));
                Toast.makeText(customer_activity.this, "Start button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(customer_activity.this, Music.class));
                Toast.makeText(customer_activity.this, "Stop button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        editTextName.setOnEditorActionListener((v, actionId, event) -> {
            String name = editTextName.getText().toString().trim();
            textViewWelcome.setText("Welcome to GroceMate, " + name);
            return true;
        });
    }
}
