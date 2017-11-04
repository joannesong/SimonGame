package nyc.c4q.simonjoanne;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button red;
    private Button yellow;
    private Button blue;
    private Button green;
    private Button play;
    private int counter;
    private List<Integer> simonSays = new ArrayList<>();
    private List<Integer> userClicks = new ArrayList<>();
    private AlphaAnimation buttonAnimation;
    private final Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAnimation = new AlphaAnimation(0.2f, 1f);
        buttonAnimation.setDuration(200);

        red = (Button) findViewById(R.id.red);
        yellow = (Button) findViewById(R.id.yellow);
        blue = (Button) findViewById(R.id.blue);
        green = (Button) findViewById(R.id.green);
        play = (Button) findViewById(R.id.play);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.red:
                red.startAnimation(buttonAnimation);
                userClicks.add(1);
            case R.id.yellow:
                yellow.startAnimation(buttonAnimation);
                userClicks.add(2);
                break;
            case R.id.blue:
                blue.startAnimation(buttonAnimation);
                userClicks.add(3);
                break;
            case R.id.green:
                green.startAnimation(buttonAnimation);
                userClicks.add(4);
                break;
        }
    }

    public void playGame(View view) {
        replay();
        addToUser(view);
    }

    public void replay() {
        int re = random.nextInt(4);
        simonSays.add(re);

        for (int i : simonSays) {
            switch (i) {
                case 0:
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            red.startAnimation(buttonAnimation);
                        }
                    }, 1000 * ++counter);
                    break;
                case 1:
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            yellow.startAnimation(buttonAnimation);
                        }
                    }, 1000 * ++counter);
                    break;
                case 2:
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            blue.startAnimation(buttonAnimation);
                        }
                    }, 1000 * ++counter);
                    break;

                case 3:
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            green.startAnimation(buttonAnimation);
                        }
                    }, 1000 * ++counter);
                    break;
            }
        }
    }

    public void addToUser(View view) {
        switch (view.getId()) {
            case R.id.red:
                red.startAnimation(buttonAnimation);
                userClicks.add(0);
                break;
            case R.id.yellow:
                yellow.startAnimation(buttonAnimation);
                userClicks.add(1);
                break;
            case R.id.blue:
                yellow.startAnimation(buttonAnimation);
                userClicks.add(2);
                break;
            case R.id.green:
                green.startAnimation(buttonAnimation);
                userClicks.add(3);
                break;
        }

        if (simonSays.size() == userClicks.size()) {
            if (simonSays.equals(userClicks)) {
                Toast.makeText(this, "Next Level!", Toast.LENGTH_SHORT).show();
                userClicks.clear();
                replay();
            } else {
                Toast.makeText(this, "You lose!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
