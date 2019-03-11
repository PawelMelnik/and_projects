package com.example.nono_eeeem;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    TextView tvClick;
    Bitmap bm;
    BitmapFactory.Options dimensions = new BitmapFactory.Options();

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
        tvClick = findViewById(R.id.msgClick);

        btnLoad.setOnClickListener(this);
        btnConvert.setOnClickListener(this);

        dimensions.inJustDecodeBounds = true;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLoad:
                //Load button
                btnConvert.setEnabled(true);
                etWidth.setFocusable(true);
                etWidth.setFocusableInTouchMode(true);
                showImage();
                hintClick();
                break;
            case R.id.btnConvert:
                //Convert button
                //Ok teamplead, lets do this!
                break;
        }

    }

    private void showImage() {
        bm = BitmapFactory.decodeResource(getResources(), R.drawable.panda1, dimensions);
        bm = BitmapFactory.decodeResource(getResources(), R.drawable.panda1);
        setWidth();
        setHeight();
        imgvPicture.setImageBitmap(bm);
    }

    private void setWidth() {
        int width = dimensions.outWidth;//bm.getWidth();//imgvPicture.getDrawable().getIntrinsicWidth();
        etWidth.setText(String.valueOf(width));
    }

    private void setHeight() {
        //getResources().getDrawable(R.drawable.panda).getIntrinsicHeight();
        int height =  dimensions.outHeight;//bm.getHeight();//imgvPicture.getDrawable().getIntrinsicHeight();
        etHeight.setText(String.valueOf(height));
    }

    private void hintClick() {
        tvClick.setText(R.string.message_click);
    }
}
