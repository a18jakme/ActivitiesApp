package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String message1 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        String message2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);

        Log.d("jacke", message);
        Log.d("jacke", message1);
        Log.d("jacke", message2);

        TextView name = findViewById(R.id.textView2);
        name.setText(message);

        TextView name1 = findViewById(R.id.textView);
        name1.setText(message1);

        TextView name2 = findViewById(R.id.textView3);
        name2.setText(message2);

        ImageView bild1=findViewById(R.id. bild);
        ImageView bild2=findViewById(R.id. bild2);

        if(message.equals("Denali")) {
            bild1.setImageResource(R.drawable.denali);
            bild2.setImageResource(R.drawable.denali1);
        }
        else if(message.equals("Matterhorn")) {
            bild1.setImageResource(R.drawable.berg1);
            bild2.setImageResource(R.drawable.matterhorn);
        }
        else if(message.equals("Mont Blanc")) {
            bild1.setImageResource(R.drawable.montblanc);
            bild2.setImageResource(R.drawable.montblanc1);
        }

    }
}
