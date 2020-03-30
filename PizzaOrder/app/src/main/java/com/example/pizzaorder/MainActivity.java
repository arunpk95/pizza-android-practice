package com.example.pizzaorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result,quantity;
    Button button;
    RadioButton small,medium,large;
    CheckBox[] toppings = new CheckBox[8];
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.cost);
        button = findViewById(R.id.button);
        small = findViewById(R.id.small);
        medium = findViewById(R.id.medium);
        large = findViewById(R.id.large);
        toppings[0]=findViewById(R.id.checkBox1);
        toppings[1]=findViewById(R.id.checkBox2);
        toppings[2]=findViewById(R.id.checkBox3);
        toppings[3]=findViewById(R.id.checkBox4);
        toppings[4]=findViewById(R.id.checkBox5);
        toppings[5]=findViewById(R.id.checkBox6);
        toppings[6]=findViewById(R.id.checkBox7);
        toppings[7]=findViewById(R.id.checkBox8);
        seekBar=findViewById(R.id.seekBar);
        quantity = findViewById(R.id.quantity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float total = getNoofPizza() *( getPizzaPrice() + getToppingsPrice());
                result.setText("Total Cost : $"+total);
            }

        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                quantity.setText("Quantity: "+seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



    private int getToppingsPrice() {
        int count=0;
        for(CheckBox topping : toppings)
        {
            if(topping.isChecked())
            {
                count++;
            }
        }
        return count>2 ? ((count-2)*2):0;
    }

    private float getPizzaPrice() {
        if(small.isChecked())
        {
            return (float) 8.99;
        }
        else if(medium.isChecked())
        {
            return (float) 11.99;
        }
        else
        {
            return (float) 14.99;
        }
    }

    float getNoofPizza() {
        return seekBar.getProgress();
    }
}
