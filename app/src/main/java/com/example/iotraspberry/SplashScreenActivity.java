package com.example.iotraspberry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    ImageView splashTop, splashIot, splashBottom;
    TextView splashJudul;

    CharSequence charSequence;
    int index;
    long delay = 200;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splashTop = findViewById(R.id.splash_top);
        splashIot = findViewById(R.id.splash_iot);
        splashBottom = findViewById(R.id.splash_bottom);
        splashJudul = findViewById(R.id.splash_dashboard);

        //set full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Initialize splash_top animation
        Animation animation1 = AnimationUtils.loadAnimation(this,
                R.anim.top_bg);

        //Start top animation
        splashTop.setAnimation(animation1);


        //set animatText
        animatText("Dashboard");

        //Initialize splash_bottom animation
        Animation animation2 = AnimationUtils.loadAnimation(this,
                R.anim.bottom_bg);
        //start bottom animation
        splashBottom.setAnimation(animation2);

        //initialize handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //redirect to main2activity
                startActivity(new Intent(SplashScreenActivity.this,
                        Main2Activity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

                //finish activity
                finish();
            }
        }, 4000);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            splashJudul.setText(charSequence.subSequence(0,index++));

            //check condiition
            if (index <= charSequence.length()){
                handler.postDelayed(runnable,delay);
            }
        }
    };

    //create animated text method
    public void animatText(CharSequence cs){
        //set text
        charSequence = cs;
        //clear index
        index = 0;
        //clear text
        splashJudul.setText("");
        //remove call back
        handler.removeCallbacks(runnable);
        //run handler
        handler.postDelayed(runnable,delay);
    }
}
