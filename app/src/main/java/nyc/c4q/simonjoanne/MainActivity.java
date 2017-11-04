package nyc.c4q.simonjoanne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button red;
    Button yellow;
    Button blue;
    Button green;
    Button play;
    List<Integer> userClicks = new ArrayList<>();
    List<Integer> simonSays = new ArrayList<>();
    AlphaAnimation buttonAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAnimation = new AlphaAnimation(0.2f, 1f);
        buttonAnimation.setDuration(100);

        red = (Button) findViewById(R.id.red);
        yellow = (Button) findViewById(R.id.yellow);
        blue = (Button) findViewById(R.id.blue);
        green = (Button) findViewById(R.id.green);
        play = (Button) findViewById(R.id.play);

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                red.startAnimation(buttonAnimation);
                userClicks.add(1);
            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blue.startAnimation(buttonAnimation);
                userClicks.add(3);
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                green.startAnimation(buttonAnimation);
                userClicks.add(4);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play.startAnimation(buttonAnimation);
            }
        });
    }
    public void playGame(){
        int randomNum = (int) Math.random() * 4 + 1;
        simonSays.add(randomNum);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.yellow:
                yellow.startAnimation(buttonAnimation);
                userClicks.add(2);
                break;
            case R.id.blue:



        }
    }
}
