package com.test.latihan_intent;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Switch;


public class MoveForResultActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnChoose;
    private RadioGroup rgNumber;

    public static final String EXTRA = "EXTRA";
    public static final int RESULT = 110;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_for_result);

        btnChoose = findViewById(R.id.btn_choose);
        rgNumber = (RadioGroup) rgNumber.findViewById(R.id.rg_number);

        btnChoose.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_choose) {
            if (rgNumber.getCheckedRadioButtonId() != 0) {
                int value = 0;
                Switch(rgNumber.getCheckedRadioButtonId()) {
                    case R.id.rb_50:
                        value = 50;
                        break;
                    case R.id.rb_100:
                        value = 100;
                        break;
                    case R.id.rb_150:
                        value = 150;
                        break;
                    case R.id.rb_200:
                        value = 200;
                        break;
                }

                Intent ResultIntent = new Intent();
                ResultIntent.putExtra(EXTRA, value);
                setResult(RESULT,ResultIntent);
                finish();
        }
    }
}

