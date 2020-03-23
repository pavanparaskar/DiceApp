package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static Button btnRollTheDice;

    public static ImageView imgDice1, imgDice2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int myBox = 12;
        float myFloatBox = 22.2f;
        double myDoubleBox = 2.3333333;

        btnRollTheDice = findViewById(R.id.btnRollTheDice);
        imgDice1 = findViewById(R.id.imgDice1);
        imgDice2 = findViewById(R.id.imgDice2);

        final MediaPlayer mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.dice_sound);

        final int[] diceImages = {R.drawable.one, R.drawable.two, R.drawable.three,
                R.drawable.three, R.drawable.four, R.drawable.five
                , R.drawable.six};
        btnRollTheDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rndObject = new Random();
                int rnsValue = rndObject.nextInt(6);
                Toast.makeText(getApplicationContext(), "Random no is::::" + rnsValue, Toast.LENGTH_LONG).show();
                imgDice1.setImageResource(diceImages[rnsValue]);

                rnsValue = rndObject.nextInt(6);
                imgDice2.setImageResource(diceImages[rnsValue]);

                YoYo.with(Techniques.Bounce)
                        .duration(200)
                        .repeat(5)
                        .playOn(imgDice1);

                YoYo.with(Techniques.Shake)
                        .duration(200)
                        .repeat(5)
                        .playOn(imgDice2);

                mediaPlayer.start();


            }
        });
    }
}
