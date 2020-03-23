package com.test.latihan_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvResult;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById (R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        Button btnMoveActivitywithData = findViewById(R.id.btn_move_activity_data);
        btnMoveActivitywithData.setOnClickListener(this);

        Button btnMoveActivityObject = findViewById(R.id.btn_move_activity_object);
        btnMoveActivityObject.setOnClickListener(this);

        Button btnDialNumber = findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);

        Button btnMoveForResult = findViewById(R.id.btn_move_for_result);
        btnMoveForResult.setOnClickListener(this);
        tvResult = findViewById(R.id.tv_result);
    }

    @Override
    public void onClick (View v) {
        switch (v.getId()) {
            //Move Activity Standard
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
            break;
            //Move Activity with Data
            case R.id.btn_move_activity_data:
                Intent movewithDataIntent = new Intent(MainActivity.this, MoveActivitywithData.class);
                movewithDataIntent.putExtra(MoveActivitywithData.EXTRA_NAME,"Otong Surotong");
                movewithDataIntent.putExtra(MoveActivitywithData.EXTRA_INT, 12);
                startActivity(movewithDataIntent);
            break;
            //Move Activity with Object
            case R.id.btn_move_activity_object:
                Person person = new Person();
                person.setName("Otong");
                person.setAge(12);
                person.setEmail("otong@punyaemail.com");
                person.setCity("Papua");

                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person);
                startActivity(moveWithObjectIntent);
            break;
            //Move Intent Activity Implicit
            case R.id.btn_dial_number:
                String numberTelepon = "085694368271";
                Intent dialNumber = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+numberTelepon));
                startActivity(dialNumber);
            break;
            //Move Activity with Result Process
            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
//
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT) {
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }





}
