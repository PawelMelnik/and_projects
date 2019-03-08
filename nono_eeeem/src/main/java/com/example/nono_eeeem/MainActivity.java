package com.example.nono_eeeem;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLoad;
    Button btnConvert;
    EditText etWidth;
    EditText etHeight;
    ImageView imgvPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Search for View-elements
        btnLoad = findViewById(R.id.btnLoad);
        btnConvert = findViewById(R.id.btnConvert);
        etWidth = findViewById(R.id.widthText);
        etHeight = findViewById(R.id.heightText);
        imgvPicture = findViewById(R.id.ivImg);

        btnLoad.setOnClickListener(this);
        btnConvert.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLoad:
                //Load button
                btnConvert.setEnabled(true);
                showImage();
                setWidth();
                setHeight();
                break;
            case R.id.btnConvert:
                //Convert button
                //Ok teamplead, lets do this!
                break;
        }

    }

    private void showImage() {
        imgvPicture.setImageResource(R.drawable.makson_manager);
    }

    private void setWidth() {
        //tvWidth.setText("Первая строка \nВторая строка \nТретья строка");
        etWidth.setText(R.string.custom_wdth);
    }

    private void setHeight() {
        etHeight.setText(R.string.custom_hght);
    }
}
