package com.example.new_desine;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

public class first_screen extends AppCompatActivity  {

    final String LOG_TAG = "myLogs";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        // инициализация
        tabHost.setup();

        TabHost.TabSpec tabSpec;

        // создаем вкладку и указываем тег
        tabSpec = tabHost.newTabSpec("tag1");
        // название вкладки
        tabSpec.setIndicator("Crop");
        // указываем id компонента из FrameLayout, он и станет содержимым
        tabSpec.setContent(R.id.tvTab1);
        // добавляем в корневой элемент
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        // указываем название и картинку
        // в нашем случае вместо картинки идет xml-файл,
        // который определяет картинку по состоянию вкладки
        tabSpec.setIndicator("Columns", getResources().getDrawable(R.drawable.tab_icon_selector));
        tabSpec.setContent(R.id.tvTab2);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        // создаем View из layout-файла
        View v = getLayoutInflater().inflate(R.layout.tab_header, null);
        // и устанавливаем его, как заголовок
        tabSpec.setIndicator(v);
        tabSpec.setContent(R.id.tvTab3);
        tabHost.addTab(tabSpec);

        // вторая вкладка будет выбрана по умолчанию
        tabHost.setCurrentTabByTag("tag2");

        // обработчик переключения вкладок
        tabHost.setOnTabChangedListener(new OnTabChangeListener() {
            public void onTabChanged(String tabId) {
                Toast.makeText(getBaseContext(), "tabId = " + tabId, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_screen_menu, menu);
        return true;
    }
}
