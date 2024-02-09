package com.example.travelinsurance;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputLayout;


public class CameraActivity extends AppCompatActivity{

    private static final int REQUEST_CODE = 22;
    Button btncamera;
    Button btnnext;
    ImageView image;
    TextInputLayout textInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);


        boolean isNightMode = (getResources().getConfiguration().uiMode
                & android.content.res.Configuration.UI_MODE_NIGHT_MASK)
                == android.content.res.Configuration.UI_MODE_NIGHT_YES;

        // Get the TextInputLayout
        textInputLayout = findViewById(R.id.vehicle);

        // Set the box stroke color based on night mode
        if (isNightMode) {
            setBoxStrokeColor(textInputLayout, R.color.night_mode_border_color);
        } else {
            // Set the default color for day mode
            setBoxStrokeColor(textInputLayout, R.color.default_border_color);
        }



        btncamera = findViewById(R.id.btn_camera);
        image = findViewById(R.id.image);

        btncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,REQUEST_CODE);
            }
        });

        btnnext = findViewById(R.id.buttonNext);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CameraActivity.this, MapActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){

            Bitmap photo = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(photo);

        }else {

            Toast.makeText(this,"Cancelled",Toast.LENGTH_SHORT).show();
            super.onActivityResult(requestCode,resultCode,data);

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setBoxStrokeColor(TextInputLayout textInputLayout, @ColorRes int colorRes) {
        int color = ContextCompat.getColor(this, colorRes);
        textInputLayout.setBoxStrokeColor(color);
    }
}
