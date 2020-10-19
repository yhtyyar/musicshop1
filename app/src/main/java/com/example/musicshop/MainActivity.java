package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int quantity =0;
    Spinner spinner;
    ArrayList spinnerArreyList;
    ArrayAdapter spinnerAdapter;

    HashMap goodsMap;
    String goodsName;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArreyList = new ArrayList();

        spinnerArreyList.add("Philadelphia");
        spinnerArreyList.add("California");
        spinnerArreyList.add("Tempura");
        spinnerArreyList.add("Busido");
        spinnerArreyList.add("Mikado");
        spinnerArreyList.add("Bangkok");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArreyList  );
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        goodsMap = new HashMap();
        goodsMap.put("Philadelphia", 300.0);
        goodsMap.put("California", 250.0);
        goodsMap.put("Tempura", 350.0);
        goodsMap.put("Busido", 325.0);
        goodsMap.put("Mikado", 400.0);
        goodsMap.put("Bangkok", 200.0);

    }

    public void increaseQuantity(View view) {
        quantity = quantity +1;
        TextView quantityTextView = findViewById(R.id.quntityTextView);
        quantityTextView.setText("" + quantity);
    }

    public void decreaseQuantity(View view) {
        quantity = quantity -1;
        if (quantity <0)  {
            quantity=0;
        }
        TextView quantityTextView = findViewById(R.id.quntityTextView);
        quantityTextView.setText("" + quantity);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName = spinner.getSelectedItem().toString();
        price =(double)goodsMap.get(goodsName);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}