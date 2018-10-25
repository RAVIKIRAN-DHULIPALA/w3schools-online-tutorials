package com.ravi.w3schools;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;

public class DefaultIntro extends AppIntro {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SliderPage sliderPage1 = new SliderPage();
        sliderPage1.setImageDrawable(R.drawable.android_internet);
        sliderPage1.setBgColor(Color.TRANSPARENT);
        sliderPage1.setDescription("Have a successful internet connection");
        addSlide(AppIntroFragment.newInstance(sliderPage1));

        SliderPage sliderPage2 = new SliderPage();
        sliderPage2.setDescription("No need to open browser for w3school");
        sliderPage2.setImageDrawable(R.drawable.browsers);
        sliderPage2.setBgColor(Color.TRANSPARENT);
        addSlide(AppIntroFragment.newInstance(sliderPage2));

        SliderPage sliderPage3 = new SliderPage();
        sliderPage3.setDescription("Enjoy w3schools tutorials\nlike HTML , css ,javascript..and much more..");
        sliderPage3.setImageDrawable(R.drawable.wsn);
        sliderPage3.setBgColor(Color.TRANSPARENT);
        addSlide(AppIntroFragment.newInstance(sliderPage3));
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        startActivity(new Intent(DefaultIntro.this,MainActivity.class));
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
        //startActivity(new Intent(DefaultIntro.this,MainActivity.class));
    }
}
