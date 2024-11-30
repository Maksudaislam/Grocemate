package com.example.grocemate2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EmployeeAdapter employeeAdapter;
    private List<String> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        employeeList = new ArrayList<>();
        employeeList.add("1. Radiathun Tasnia");
        employeeList.add("2. Maksuda Islam");
        employeeList.add("3. Tasnoba Islam");
        employeeList.add("4. Moumita Islam");
        employeeList.add("5. Asifa Islam");
        employeeList.add("6. Alfhi");
        employeeList.add("7. Minhaz");
        employeeList.add("8. Shossho");
        employeeList.add("9. ABU BAKAR");
        employeeList.add("10. IRIN");
        employeeList.add("11. TANVIN");
        employeeList.add("12. Azrin");
        employeeList.add("13. Nowrin");
        employeeList.add("14. JK");
        employeeList.add("15. FAIZA");
        employeeList.add("16. Rahi");
        employeeList.add("17. Samia");
        employeeList.add("18. Tafsir");
        employeeList.add("19. Jina");

        employeeAdapter = new EmployeeAdapter(this, employeeList);
        recyclerView.setAdapter(employeeAdapter);
    }
}
