package com.example.coleramey.tipcalculator;

import java.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button percent10Button;
    private Button percent15Button;
    private Button percent20Button;
    private Button percentCustomButton;
    private EditText customPercent;
    private EditText totalEditText;
    private TextView total;
    private TextView fullAmmountTextView;

    NumberFormat currency = NumberFormat.getCurrencyInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        percent10Button = (Button) findViewById(R.id.percent10Button);
        percent15Button = (Button) findViewById(R.id.percent15Button);
        percent20Button = (Button) findViewById(R.id.percent20Button);
        percentCustomButton = (Button) findViewById(R.id.percentCustomButton);
        totalEditText = (EditText) findViewById(R.id.totalEditText);
        customPercent = (EditText) findViewById(R.id.edCustomPercent);
        total = (TextView) findViewById(R.id.totalTextView);
        fullAmmountTextView = (TextView) findViewById(R.id.fullAmmountTextView);

        percent10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotal((float) 10.0);
            }
        });

        percent15Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotal((float) 15.0);
            }
        });

        percent20Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotal((float) 20.0);
            }
        });

        percentCustomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tip_ammount = Integer.parseInt(customPercent.getText().toString());
                calculateTotal((float) tip_ammount);
            }
        });
    }

    public void calculateTotal(float percent) {
        percent = percent / 100;
        String tipAmmount;
        float billAmmount = Float.parseFloat(totalEditText.getText().toString());
        tipAmmount = currency.format(billAmmount * percent);
        total.setText(tipAmmount);
        tipAmmount = tipAmmount.substring(1);
        float tip = Float.valueOf(tipAmmount);
        setTotal(tip, billAmmount);

    }

    public void setTotal(float tipAmmount, float billAmmount) {
        Float totalBill = tipAmmount + billAmmount;
        String formatedBill = (currency.format(totalBill));
        fullAmmountTextView.setText(formatedBill);
    }
}
