package com.example.thi_dawa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listViewEmployee;
    List<Employee> employees;
    SQLiteDatabaseHandle sqLiteDatabaseHandle;
    EmployeeListAdapter employeeListAdapter;
    EditText edName,  edDesignation, edSalary;
    Button btnAdd, btnUpdate, btnDelete;
    private static Employee employeeSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewEmployee = findViewById(R.id.lvEmployee);
        sqLiteDatabaseHandle = new SQLiteDatabaseHandle(this);
        employees = sqLiteDatabaseHandle.getAllEmployees();
        employeeListAdapter = new EmployeeListAdapter(this, employees, sqLiteDatabaseHandle);
        edName = findViewById(R.id.ed_Name);
        edDesignation = findViewById(R.id.ed_Designation);
        edSalary = findViewById(R.id.ed_salary);
        btnAdd = findViewById(R.id.btn_Add);
        btnUpdate = findViewById(R.id.btn_Update);
        btnDelete = findViewById(R.id.btn_Delete);
        listViewEmployee.setAdapter(employeeListAdapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employee = new Employee();
                employee.setName(edName.getText().toString());
                employee.setDesignation(edDesignation.getText().toString());
                employee.setSalary(Double.parseDouble(String.valueOf(edSalary.getText().toString())));
                sqLiteDatabaseHandle.addEmployee(employee);
                employeeListAdapter.refreshData(sqLiteDatabaseHandle.getAllEmployees());
            }
        });


        listViewEmployee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Employee employee = employees.get(i);
                edName.setText(employee.getName());
                edDesignation.setText(employee.getDesignation());
                edSalary.setText(String.valueOf(employee.getSalary()));
                employeeSelected = employee;
            }
        });

    }
}