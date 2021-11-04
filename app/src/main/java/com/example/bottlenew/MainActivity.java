package com.example.bottlenew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView bottle,p1,p2,p3,p4,p5,p6,p7,p8;
    private int last;
    private boolean spinning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void init(){
        bottle = findViewById(R.id.bottle);
        p1 = findViewById(R.id.pl1);
        p2 = findViewById(R.id.pl2);
        p3 = findViewById(R.id.pl3);
        p4 = findViewById(R.id.pl4);
        p5 = findViewById(R.id.pl5);
        p6 = findViewById(R.id.pl6);
        p7 = findViewById(R.id.pl7);
        p8 = findViewById(R.id.pl8);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){

            case R.id.two_settings:
                p1.setVisibility(View.VISIBLE);
                p2.setVisibility(View.GONE);
                p3.setVisibility(View.VISIBLE);
                p4.setVisibility(View.GONE);
                p5.setVisibility(View.GONE);
                p6.setVisibility(View.GONE);
                p7.setVisibility(View.GONE);
                p8.setVisibility(View.GONE);

                break;
            case R.id.three_settings:
                p1.setVisibility(View.VISIBLE);
                p2.setVisibility(View.GONE);
                p3.setVisibility(View.VISIBLE);
                p4.setVisibility(View.GONE);
                p5.setVisibility(View.GONE);
                p6.setVisibility(View.VISIBLE);
                p7.setVisibility(View.GONE);
                p8.setVisibility(View.GONE);
                break;
            case R.id.four_settings:
                p1.setVisibility(View.VISIBLE);
                p2.setVisibility(View.GONE);
                p3.setVisibility(View.VISIBLE);
                p4.setVisibility(View.GONE);
                p5.setVisibility(View.VISIBLE);
                p6.setVisibility(View.GONE);
                p7.setVisibility(View.VISIBLE);
                p8.setVisibility(View.GONE);
                break;
            case R.id.eight_settings:
                p1.setVisibility(View.VISIBLE);
                p2.setVisibility(View.VISIBLE);
                p3.setVisibility(View.VISIBLE);
                p4.setVisibility(View.VISIBLE);
                p5.setVisibility(View.VISIBLE);
                p6.setVisibility(View.VISIBLE);
                p7.setVisibility(View.VISIBLE);
                p8.setVisibility(View.VISIBLE);
                break;

            case R.id.first_bottle:
                Resources res1 = getResources();
                Drawable drawable1 = ResourcesCompat.getDrawable(res1, R.drawable.bottle1, null);
                bottle.setImageDrawable(drawable1);
                break;
            case R.id.second_bottle:
                Resources res2 = getResources();
                Drawable drawable2 = ResourcesCompat.getDrawable(res2, R.drawable.bottle2, null);
                bottle.setImageDrawable(drawable2);
                break;
            case R.id.third_bottle:
                Resources res3 = getResources();
                Drawable drawable3 = ResourcesCompat.getDrawable(res3, R.drawable.bottle3, null);
                bottle.setImageDrawable(drawable3);
                break;

        }
        return true;
    }
    //Анимация поворота бутылки
    public void Roll(View view) {
        if (!spinning) {
            Random random = new Random();
            int new_rand = random.nextInt(2160);
            float pointWidth = bottle.getWidth() / 2;
            float pointHeight = bottle.getHeight() / 2;
            Animation rotation = new RotateAnimation(last, new_rand, pointWidth, pointHeight);
            rotation.setDuration(2700);
            rotation.setFillAfter(true);
            rotation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            last = new_rand;
            bottle.startAnimation(rotation);
        }
    }
}