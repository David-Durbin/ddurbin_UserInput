package com.example.ddurbin_userinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double mealCost;
    double tipPercent;
    String tip;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up both the spinner and the cost entry
        final Spinner group=(Spinner)findViewById(R.id.idSpinner);
        final EditText meal=(EditText)findViewById(R.id.idNumberEntry);

        // set up the button to calculate the final price
        Button calculate = (Button)findViewById(R.id.idCalcBtn);
            //set up a listener to react when the button is pressed.
            calculate.setOnClickListener(new View.OnClickListener(){
                final TextView result=((TextView)findViewById(R.id.idCalcResult));
                @Override
                public void onClick(View view) {
                    mealCost = Double.parseDouble(meal.getText().toString()); //don't forget this has to be the class version!
                    DecimalFormat currency = new DecimalFormat("$###,###.##");
                    // set tip using spinner
                    tip = group.getSelectedItem().toString();
                    // set tip percent using tip (not the way I'd have liked to do this but this keeps things simple)
                    if(tip.equals("5%")) {
                        tipPercent = 0.05;
                    }
                    else if(tip.equals("10%")) {
                        tipPercent = 0.1;
                    }
                    else if(tip.equals("20%")) {
                        tipPercent = 0.2;
                    }
                    else if(tip.equals("25%")) {
                        tipPercent = 0.25;
                    }
                    else {
                        tipPercent = 0.15;
                    }
                    // get results for display
                    result.setText("With a tip of " + tip + " that is " + currency.format((mealCost * tipPercent)) +
                            ". Resulting in a total cost of " + currency.format(((mealCost * tipPercent)+mealCost)));

                }
            });

    }
}
