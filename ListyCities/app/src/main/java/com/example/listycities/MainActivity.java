package com.example.listycities;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.CharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    Button button1;
    Button button2;

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
        cityList = findViewById(R.id.city_list);
        String []cities = {"Edmonton","Vancouver","Moscow","Sidney","Berlin","Vienna","Tokyo","Beijing","Osaka","New Delhi"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this,R.layout.content,dataList);
        cityList.setAdapter(cityAdapter);
        Button addButton = findViewById(R.id.add_button);
        Button removeButton = findViewById(R.id.remove_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the input from user and add it to scrollable array
                TextView inputText;
                inputText = (EditText) findViewById(R.id.inputText);
                String newCity;
                newCity = String.valueOf(inputText.getText());
                if (newCity.isEmpty()) {
                    inputText.setText("type city to add");
                }else if (newCity.equals("type city to add")){ //prevents this text from being added
                    newCity = "";
                    inputText.setText("");
                }else if (newCity.equals("type city to remove")){ //prevents this text from being added
                    newCity = "";
                    inputText.setText("");
                }else {
                    cityAdapter.add(newCity);
                    inputText.setText("");
                }

            }
        });
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //type in a city and click remove to remove it
                TextView inputText;
                inputText = (EditText) findViewById(R.id.inputText);
                String oldCity;
                oldCity = String.valueOf(inputText.getText());

                if (oldCity.isEmpty()) {
                    inputText.setText("type city to remove");
                }else if (oldCity.equals("type city to remove")){ //prevents this text from being added
                    oldCity = "";
                    inputText.setText("");
                }else if (oldCity.equals("type city to remove")){ //prevents this text from being added
                    oldCity = "";
                    inputText.setText("");
                }else {
                    cityAdapter.remove(oldCity);
                    inputText.setText("");
                }





            }

        });


    }
}