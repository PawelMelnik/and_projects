package com.example.nono_eeeem;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private TextView mTextView;
    Button btnLoad;
    Button btnConvert;
    EditText etWidth;
    EditText etHeight;
    ImageView imgvPicture;
    TextView tvClick;
    Bitmap bm;
    //BitmapFactory.Options dimensions = new BitmapFactory.Options();

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

        final SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        mTextView = (TextView)findViewById(R.id.textView);
        mTextView.setText("200");

        //dimensions.inJustDecodeBounds = true;

        /*SurfaceView surface = (SurfaceView) findViewById(R.id.surface);
        surface.setBackgroundColor(Color.TRANSPARENT);
        surface.setZOrderOnTop(true); //necessary
        surface.getHolder().setFormat(PixelFormat.TRANSPARENT);
        surface.getHolder().addCallback(new SurfaceHolder.Callback() {

            Paint p;

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                // Do some drawing when surface is ready
                Canvas canvas = holder.lockCanvas();
                p = new Paint();
                p.setStyle(Paint.Style.STROKE);
                p.setStrokeWidth(3);
                p.setColor(Color.BLUE);
                drawGrid(canvas);
                holder.unlockCanvasAndPost(canvas);
            }



            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            private void drawGrid(Canvas canvas) {
                for (int i = 25; i < 720; i += 25) {
                    canvas.drawLine(0 + i, 0, 0 + i, 576, p);
                }
                for (int i = 25; i < 576; i += 25) {
                    canvas.drawLine(0, 0 + i, 720, 0 + i, p);
                }

            }
        });*/

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

    int _width;
    int _height;
    int _start_h;
    int _count;

    private void showImage() {
        //bm = BitmapFactory.decodeResource(getResources(), R.drawable.panda1, dimensions);
        bm = BitmapFactory.decodeResource(getResources(), R.drawable.panda1);
        imgvPicture.setImageBitmap(bm);
        _width = (int)(imgvPicture.getDrawable().getIntrinsicWidth() * 1.2 / 2.62);
        _height = (int)(imgvPicture.getDrawable().getIntrinsicHeight() * 1.2 / 2.62);
        _start_h = (int)((866.0 - _height*1.0)/2.0);
        _count = 20;
        setWidth(_width);
        setHeight(_height);
        Panel p = findViewById(R.id.test);
        p.doDraw(_start_h, _width, _height, _count);
    }

    private void setWidth(int w) {
        int width = w;//dimensions.outWidth;//bm.getWidth();//imgvPicture.getDrawable().getIntrinsicWidth();
        etWidth.setText(String.valueOf(width));
    }

    private void setHeight(int h) {
        //getResources().getDrawable(R.drawable.panda).getIntrinsicHeight();
        int height = h;//  dimensions.outHeight;//bm.getHeight();//imgvPicture.getDrawable().getIntrinsicHeight();
        etHeight.setText(String.valueOf(height));
    }

    private void hintClick() {
        tvClick.setText(R.string.message_click);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mTextView.setText(String.valueOf(seekBar.getProgress()));
        Panel p = findViewById(R.id.test);
        p.doDraw(_start_h, _width, _height,seekBar.getProgress());
    }
}
