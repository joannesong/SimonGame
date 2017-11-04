package com.c4q.simon;

import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button[] button;
    Button[] simon;
    AlphaAnimation buttonAnimation;
    List<Button[]> x;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createButtonAnimation();


        button = new Button[4];
        simon = new Button[4];
         x = new ArrayList<>();

        button[0] = findViewById(R.id.red);
        button[1] = findViewById(R.id.blue);
        button[2] = findViewById(R.id.green);
        button[3] = findViewById(R.id.yellow);


        button[0].setOnClickListener(this);
        button[1].setOnClickListener(this);
        button[2].setOnClickListener(this);
        button[3].setOnClickListener(this);

        shuffle(button);
        makeButtonFalse(button);
        x.add(button);


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.red:
                //for (int i = 0; i <x.size() ; i++) {
                         ///   Button[] k=x.get(i);

                    for (int j = 0;  j< button.length; j++) {
                        if (button[j].getId() == R.id.red) {
                            button[j].startAnimation(buttonAnimation);
                            simon[j] = findViewById(view.getId());
                        }
                    }
                break;
            case R.id.blue:
                for (int i = 0; i < button.length; i++) {
                    if (button[i].getId() == R.id.blue) {
                        button[i].startAnimation(buttonAnimation);
                        simon[i] = findViewById(view.getId());
                    }

                }
                break;
            case R.id.green:
                for (int i = 0; i < button.length; i++) {
                    if (button[i].getId() == R.id.green) {
                        button[i].startAnimation(buttonAnimation);
                        simon[i] = findViewById(view.getId());
                    }

                }
                break;
            case R.id.yellow:
                for (int i = 0; i < button.length; i++) {
                    if (button[i].getId() == R.id.yellow) {
                        button[i].startAnimation(buttonAnimation);
                        simon[i] = findViewById(view.getId());
                    }
                }
                break;
            default:
                break;
        }
    }

    public void play(View view) throws InterruptedException {
        makeButtonTrue(button);
        ///Button[] buttons2= new Button[];
        for (int j = 0; j <x.size() ; j++) {
                    final Button[] buttonss= x.get(j);

            for (int i = 0; i < buttonss.length; i++) {
                final Handler handler = new Handler();
                final int finalI = i;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        buttonss[finalI].startAnimation(buttonAnimation);
                        buttonss[finalI].setText(String.valueOf(finalI));


                    }
                }, 1000 * i * 2);


            }
            shuffle(buttonss);
            //x.add(button);
        }



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

    private void createButtonAnimation() {
        buttonAnimation = new AlphaAnimation(0.2f, 1f);
        buttonAnimation.setDuration(1000);
    }

    public void makeButtonFalse(Button[] button){
        for (int i = 0; i <button.length ; i++) {
            button[i].setEnabled(false);
        }
    }

    public void makeButtonTrue(Button[] button){
        for (int i = 0; i <button.length ; i++) {
            button[i].setEnabled(true);
        }
    }
    public void shuffle(Button[] b){
        Collections.shuffle(Arrays.asList(b));
        ///x.add(b);*****
    }


}


