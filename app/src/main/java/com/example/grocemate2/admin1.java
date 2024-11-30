package com.example.grocemate2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class admin1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin1);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button employee_d = findViewById(R.id.employee_details);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button customer_d = findViewById(R.id.customer_details);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        employee_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openWebsiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://codeforces.com/profile/Go_Se_Yeon"));
                startActivity(openWebsiteIntent);
            }
        });

        customer_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:123456789"));
                startActivity(callIntent);

                Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                smsIntent.setData(Uri.parse("smsto:123456789"));
                smsIntent.putExtra("sms_body", "Hello from GroceMate!");
                startActivity(smsIntent);
            }
        });
    }
}
