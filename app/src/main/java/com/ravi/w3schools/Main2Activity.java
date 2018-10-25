package com.ravi.w3schools;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import static android.content.Context.MODE_PRIVATE;

public class Main2Activity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    LinearLayout constraintLayout;
    AnimationDrawable animationDrawable;
    ConnectionDetect cd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cd = new ConnectionDetect(this);
        if (!cd.isConnected()) {
            new AlertDialog.Builder(this)
                    .setTitle("Error Connection")
                    .setMessage("Please On your Internet connection\nTo use this App...")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            moveTaskToBack(true);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);
                        }
                    }).create().show();
        } else {
            setContentView(R.layout.activity_main2);
            constraintLayout = (LinearLayout) findViewById(R.id.clay);
            animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
            animationDrawable.setEnterFadeDuration(1);
            animationDrawable.setExitFadeDuration(3000);
            animationDrawable.start();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent mainIntent = new Intent(Main2Activity.this, MainActivity.class);
                    Main2Activity.this.startActivity(mainIntent);
                    Main2Activity.this.finish();
                }
            }, SPLASH_DISPLAY_LENGTH);

            Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .getBoolean("isFirstRun", true);

            if (isFirstRun) {
                //show start activity
                setContentView(R.layout.activity_main2);
                constraintLayout = (LinearLayout) findViewById(R.id.clay);
                animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
                animationDrawable.setEnterFadeDuration(0);
                animationDrawable.setExitFadeDuration(3000);
                animationDrawable.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent mainIntent = new Intent(Main2Activity.this,DefaultIntro.class);
                        Main2Activity.this.startActivity(mainIntent);
                        Main2Activity.this.finish();
                    }
                }, SPLASH_DISPLAY_LENGTH);
            }
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun", false).commit();
        }
    }

}
