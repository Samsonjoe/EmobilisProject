package com.wiz.emobilisproject.onBoarding;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.wiz.emobilisproject.MainActivity;
import com.wiz.emobilisproject.R;

import java.util.ArrayList;
import java.util.List;

public class ImageBackgroundExampleActivity extends AhoyOnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences =  getSharedPreferences("my_preferences",
                MODE_PRIVATE);

        if(preferences.getBoolean("onboarding_complete",false)) {
            // Start Main Activity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            // Close Onboarding
            finish();
            return;
        }

        AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard("Use Insurance Number", "Sign up for free by Using the Insurance Number you were registered by our agents with.", R.drawable.medical);
        AhoyOnboarderCard ahoyOnboarderCard2 = new AhoyOnboarderCard("Add Dependants", "Following our policies on dependants, upon verification by our agents, add and manage your dependants.", R.drawable.add);
        AhoyOnboarderCard ahoyOnboarderCard3 = new AhoyOnboarderCard("Get Medical Cover", "Get Instant medical service for you and your dependant by requesting for medical cover letter instantly.", R.drawable.get_service);

        ahoyOnboarderCard1.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard2.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard3.setBackgroundColor(R.color.black_transparent);

        List<AhoyOnboarderCard> pages = new ArrayList<>();

        pages.add(ahoyOnboarderCard1);
        pages.add(ahoyOnboarderCard2);
        pages.add(ahoyOnboarderCard3);

        for (AhoyOnboarderCard page : pages) {
            page.setTitleColor(R.color.white);
            page.setDescriptionColor(R.color.grey_200);
        }

        setFinishButtonTitle("Get Started");
        showNavigationControls(true);
        //setGradientBackground();
        setImageBackground(R.drawable.download);

       // Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        //setFont(face);

        setInactiveIndicatorColor(R.color.grey_600);
        setActiveIndicatorColor(R.color.white);

        setOnboardPages(pages);

    }

    @Override
    public void onFinishButtonPressed() {

        Toast.makeText(this, "Finish Pressed", Toast.LENGTH_SHORT).show();

        SharedPreferences preferences =
                getSharedPreferences("my_preferences", MODE_PRIVATE);
        // Set onboarding_complete to true
        preferences.edit().putBoolean("onboarding_complete",true).apply();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();



    }
}