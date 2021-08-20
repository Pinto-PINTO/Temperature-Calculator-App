package com.example.temperaturecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // UI Componets are refered
    EditText tempInput;
    RadioButton celciusBtn,fahrenhiteBtn;
    Button calculateBtn;
    TextView resultDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // R.id = Resource id (Access id from Resource file)
        tempInput = findViewById(R.id.tempInput);
        celciusBtn = findViewById(R.id.celciusBtn);
        fahrenhiteBtn = findViewById(R.id.fahrenhiteBtn);
        calculateBtn = findViewById(R.id.calculateBtn);
        resultDisplay = findViewById(R.id.resultDisplay);
    }

    @Override
    protected void onResume() {
        super.onResume();
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Once btn is clicked calculateAnswer() method should be executed
                calculateAnswer();
            }
        });
    }

    public void calculateAnswer() {

        // Instance for Calculations.java class
        Calculations cal = new Calculations();

        // Obtain user input and convert to string
        String input = tempInput.getText().toString();

        if (TextUtils.isEmpty(input)){ // Checks if the input field is empty

            // LENGTH_SHORT = Message Duration (Short Duration Message)
            Toast.makeText(this, "You have not entered the Temperature", Toast.LENGTH_SHORT).show();
            
        }
        else { // Check which radio button is clicked

            // Convert user input from string to float
            Float temp = Float.parseFloat(input);

            if (celciusBtn.isChecked()){
                // Call convertCelciusToFahrenheit() method
                temp = cal.convertCelciusToFahrenheit(temp);
            }
            else if (fahrenhiteBtn.isChecked()){
                temp = cal.convertFahrenheitToCelcius(temp);
            }
            else{
                Toast.makeText(this, "Select Celcius or Fahrenhite", Toast.LENGTH_SHORT).show();
                temp = 0.0f;
            }

            // To display in text filed convert the temp value from float to string
            resultDisplay.setText(new Float(temp).toString());
        }

    }


}






