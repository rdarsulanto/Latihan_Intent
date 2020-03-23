package com.test.latihan_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveActivitywithData extends AppCompatActivity {

    public static final String EXTRA_NAME = "a";
    public static final String EXTRA_INT = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_activitywith_data);

        TextView tvDataReceived = findViewById(R.id.tv_data_received);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_INT, 0);

        String tulisan = "Nama " + name + "\nUmur " + age;
        tvDataReceived.setText(tulisan);
    }
}
