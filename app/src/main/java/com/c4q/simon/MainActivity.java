package com.c4q.simon;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button[] button;
    Button[] simon;
    private static int number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = new Button[4];
        simon = new Button[4];

        button[0] = findViewById(R.id.red);
        button[0].setOnClickListener(this);
        button[1] = findViewById(R.id.blue);
        button[1].setOnClickListener(this);
        button[2] = findViewById(R.id.green);
        button[2].setOnClickListener(this);
        button[3] = findViewById(R.id.yellow);
        button[3].setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.red:

                button[0].setBackgroundResource(R.color.lightred);
                button[0].setBackgroundResource(R.color.red);
                //Toast.makeText(getApplicationContext(), String.valueOf(number), Toast.LENGTH_SHORT).show();
                simon[number++] = findViewById(view.getId());
                //Toast.makeText(getApplicationContext(), String.valueOf(number), Toast.LENGTH_SHORT).show();



                break;
            case R.id.blue:

                button[1].setBackgroundResource(R.color.lightblue);
                button[1].setBackgroundResource(R.color.blue);
                //Toast.makeText(getApplicationContext(), String.valueOf(number), Toast.LENGTH_SHORT).show();
                simon[number++] = findViewById(view.getId());
                //Toast.makeText(getApplicationContext(), String.valueOf(number), Toast.LENGTH_SHORT).show();

                break;
            case R.id.green:

                button[2].setBackgroundResource(R.color.lightgreen);
                button[2].setBackgroundResource(R.color.green);
                //Toast.makeText(getApplicationContext(), String.valueOf(number), Toast.LENGTH_SHORT).show();
                simon[number++] = findViewById(view.getId());
                //Toast.makeText(getApplicationContext(), String.valueOf(number), Toast.LENGTH_SHORT).show();

                break;
            case R.id.yellow:

                button[3].setBackgroundResource(R.color.lightyellow);
                button[3].setBackgroundResource(R.color.yellow);
               // Toast.makeText(getApplicationContext(), String.valueOf(number), Toast.LENGTH_SHORT).show();
                simon[number++] = findViewById(view.getId());
                //Toast.makeText(getApplicationContext(), String.valueOf(number), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
    public void play(View view){
        button[0].setBackgroundResource(R.color.lightred);
        button[1].setBackgroundResource(R.color.lightblue);
        button[2].setBackgroundResource(R.color.lightgreen);
        button[3].setBackgroundResource(R.color.lightyellow);
        reset();



    }
    public void reset(){
        button[0].setBackgroundResource(R.color.red);
        button[1].setBackgroundResource(R.color.blue);
        button[2].setBackgroundResource(R.color.green);
        button[3].setBackgroundResource(R.color.yellow);

    }

    public void checks(Button[] button, Button[] simon) {
        for (int i = 0; i < button.length; i++) {
            if (simon[0] == button[0]) {
                Toast.makeText(getApplicationContext(), "good job", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(getApplicationContext(), "bad", Toast.LENGTH_SHORT).show();
        }
    }

    public void check(View view) {
        checks(button, simon);

    }
}


