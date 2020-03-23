package com.test.latihan_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObjectActivity extends AppCompatActivity {

    public static final String EXTRA_PERSON = "extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        TextView tvObject = findViewById(R.id.tv_object_received);

        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);
        String tulisan = "Nama : " + person.getName() + "\nUmur : " + person.getAge() + "\nEmail : " + person.getEmail() + "\nKota : " + person.getCity();
        tvObject.setText(tulisan);
    }
}
