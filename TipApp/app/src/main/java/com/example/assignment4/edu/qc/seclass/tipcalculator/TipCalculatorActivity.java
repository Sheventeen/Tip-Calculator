package com.example.assignment4.edu.qc.seclass.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment4.R;

public class TipCalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    Button calcButton;
    EditText total,party;
    TextView fifteenTip, twentyTip,twentyFiveTip,fifteenTipTotal,twentyTipTotal,twentyFiveTipTotal;
    int totalCost,partySize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        calcButton = findViewById(R.id.buttonCompute);

        total = (EditText)findViewById(R.id.checkValueAmount);
        party = (EditText)findViewById(R.id.partySizeValue);

        fifteenTip = findViewById(R.id.fifteenPercentTipValue);
        twentyTip = findViewById(R.id.twentyPercentTipValue);
        twentyFiveTip = findViewById(R.id.twentyfivePercentTipValue);
        fifteenTipTotal = findViewById(R.id.fifteenPercentTotalValue);
        twentyTipTotal = findViewById(R.id.twentyPercentTotalValue);
        twentyFiveTipTotal = findViewById(R.id.twentyfivePercentTotalValue);

        calcButton.setOnClickListener(this);

    }
    public boolean checkIfValidEntry(EditText x){
        if(x.getText().toString().isEmpty()) return false;
        return Integer.parseInt(x.getText().toString()) > 0;
    }
    @Override
    public void onClick(View v) {
        if(!checkIfValidEntry(total))
            Toast.makeText(this, "Enter valid Number for amount", Toast.LENGTH_SHORT).show();
        else totalCost = Integer.parseInt(total.getText().toString());

        if(!checkIfValidEntry(party))
            Toast.makeText(this, "Enter valid Number plz for party", Toast.LENGTH_SHORT).show();
        else partySize = Integer.parseInt(party.getText().toString());



        double ans = ((float)totalCost /partySize) *1.15;
        String str = String.valueOf(ans);
        if(totalCost > 0 && partySize >0) {
            fifteenTip.setText(str);
            ans = ((double) totalCost / partySize) * 1.2;
            str = String.valueOf(ans);
            twentyTip.setText(str);
            ans = ((double) totalCost / partySize) * 1.25;
            str = String.valueOf(ans);
            twentyFiveTip.setText(str);
            ans = ((double) totalCost) * 1.15;
            str = String.valueOf(ans);
            fifteenTipTotal.setText(str);
            ans = ((double) totalCost) * 1.20;
            str = String.valueOf(ans);
            twentyTipTotal.setText(str);
            ans = ((double) totalCost) * 1.25;
            str = String.valueOf(ans);
            twentyFiveTipTotal.setText(str);
        }
        else{
            fifteenTip.setText("");
            twentyTip.setText("");
            twentyFiveTip.setText("");
            fifteenTipTotal.setText("");
            twentyTipTotal.setText("");
            twentyFiveTipTotal.setText("");
        }
    }

}