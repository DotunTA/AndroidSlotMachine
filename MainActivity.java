package com.dotunta.androidslotmachine;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_roll;

    ImageView image1, image2, image3;

    EditText score, attempts;

    Random r;
    int img1, img2, img3;

    int scoreValue, count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        b_roll = (Button) findViewById(R.id.b_roll);

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);

        score = (EditText) findViewById(R.id.score);
        score.setEnabled(false);

        attempts = (EditText) findViewById(R.id.attempts);
        attempts.setTextColor(Color.BLUE);
        attempts.setEnabled(false);

        b_roll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                image1.setImageResource(R.drawable.anim);
                final AnimationDrawable imageAnimOne = (AnimationDrawable) image1.getDrawable();
                imageAnimOne.start();

                image2.setImageResource(R.drawable.anim);
                final AnimationDrawable imageAnimTwo = (AnimationDrawable) image2.getDrawable();
                imageAnimTwo.start();

                image3.setImageResource(R.drawable.anim);
                final AnimationDrawable imageAnimThree = (AnimationDrawable) image3.getDrawable();
                imageAnimThree.start();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageAnimOne.stop();
                        imageAnimTwo.stop();
                        imageAnimThree.stop();

                        setImages();

                        getScore();

                        attempts.setText("Attempts: " + ++count);
                    }
                }, 500);

            }
        });
    }

    public void setImages(){
        img1 = r.nextInt(5) + 1;
        img2 = r.nextInt(5) + 1;
        img3 = r.nextInt(5) + 1;

        switch(img1){
            case 1:
                image1.setImageResource(R.drawable.chipmunk);
                break;
            case 2:
                image1.setImageResource(R.drawable.donkey);
                break;
            case 3:
                image1.setImageResource(R.drawable.felix_cat);
                break;
            case 4:
                image1.setImageResource(R.drawable.koala);
                break;
            case 5:
                image1.setImageResource(R.drawable.zebra);
                break;
        }

        switch(img2){
            case 1:
                image2.setImageResource(R.drawable.chipmunk);
                break;
            case 2:
                image2.setImageResource(R.drawable.donkey);
                break;
            case 3:
                image2.setImageResource(R.drawable.felix_cat);
                break;
            case 4:
                image2.setImageResource(R.drawable.koala);
                break;
            case 5:
                image2.setImageResource(R.drawable.zebra);
                break;
        }

        switch(img3){
            case 1:
                image3.setImageResource(R.drawable.chipmunk);
                break;
            case 2:
                image3.setImageResource(R.drawable.donkey);
                break;
            case 3:
                image3.setImageResource(R.drawable.felix_cat);
                break;
            case 4:
                image3.setImageResource(R.drawable.koala);
                break;
            case 5:
                image3.setImageResource(R.drawable.zebra);
                break;
        }
    }

    public void getScore(){
        if(img1 == img2 && img2 == img3){
            Toast.makeText(this, "JACKPOT!!!!!", Toast.LENGTH_SHORT).show();
            scoreValue += 1000;

            score.setText("" + scoreValue);
        } else if(img1 == img2 || img2 == img3 || img1 == img3){
            Toast.makeText(this, "MATCHED TWO!", Toast.LENGTH_SHORT).show();
            scoreValue += 100;
            score.setText("" + scoreValue);
        } else{
            Toast.makeText(this, "TRY AGAIN!", Toast.LENGTH_SHORT).show();
            scoreValue += -80;
            score.setText("" + scoreValue);
        }

        if(scoreValue >= 0){
            score.setTextColor(Color.GREEN);
        } else{
            score.setTextColor(Color.RED);
        }
    }
}
