package com.example.final_first_screen;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class first_screen_activity extends AppCompatActivity implements View.OnClickListener {

    Button btnCrop;
    Button btnColumns;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen_activity);

        btnCrop = findViewById(R.id.btn_crop);
        btnColumns = findViewById(R.id.btn_columns);

        btnCrop.setOnClickListener(this);
        btnColumns.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_screen_menu, menu);
        return true;
    }

    // обработка нажатий меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_crop:
                break;
            case R.id.btn_columns:
                Dialog_case();
                break;
            default:
                break;
        }
    }

    private void Dialog_case(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // Get the layout inflater
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.first_screen_dialog, null))
                // Add action buttons
                .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Change", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //here might be the handler
                    }
                });


        //Создаем AlertDialog:
        AlertDialog alertDialog = builder.create();

        //и отображаем его:
        alertDialog.show();
        alertDialog.getWindow().setLayout(800,650);
    }
}
