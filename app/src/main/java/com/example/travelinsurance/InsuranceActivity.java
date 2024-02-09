package com.example.travelinsurance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputLayout;

public class InsuranceActivity extends AppCompatActivity {
    Button btnnext;
    TextInputLayout textInputLayout;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance);



        boolean isNightMode = (getResources().getConfiguration().uiMode
                & android.content.res.Configuration.UI_MODE_NIGHT_MASK)
                == android.content.res.Configuration.UI_MODE_NIGHT_YES;

        if (isNightMode) {
            setBoxStrokeColor(textInputLayout, R.color.night_mode_border_color);
        } else {
            // Set the default color for day mode
            setBoxStrokeColor(textInputLayout, R.color.default_border_color);
        }



        btnnext = findViewById(R.id.nextbtn);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsuranceActivity.this, AnimationActivity.class);
                startActivity(intent);

            }
        });

    }
    private void setBoxStrokeColor(TextInputLayout textInputLayout, @ColorRes int colorRes) {
        int color = ContextCompat.getColor(this, colorRes);
        textInputLayout.setBoxStrokeColor(color);
    }
}

