package com.example.a5635512110.newproject;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private String[] mDrawerTitle = {"File", "Load...", "Open", "Contact"};
    private DrawerLayout mDrawerLayout;
    private ListView mListView;


    public int[] resId = { R.drawable.one  , R.drawable.two, R.drawable.three };

    public String[] list = { "Aerith Gainsborough", "Barret Wallace", "Cait Sith" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        final DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        // เพิ่ม Event าำหรับกดปุ่มเมนู
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                mDrawerLayout,
                R.string.open_drawer,
                R.string.close_drawer);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        //-----------------------------------------------------------------------

        //--- Show hamburgur bar----------------------------------
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //----------------------------------------------------

        //--- Show List menu -------------------------------------
        mListView = (ListView) findViewById(R.id.drawer);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, mDrawerTitle);
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), list, resId);
        mListView.setAdapter(adapter);
        //position starting from 0
        // evet then you click item
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String  itemValue    = (String) mListView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Position :"+ position+"  ListItem : " +itemValue , Toast.LENGTH_SHORT)
                        .show();
                tv1.setText("Hello "+ itemValue);
                mDrawerLayout.closeDrawers();
            }

        });
        //-----------------------------------------
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.mnuNew:
                Toast.makeText(this, "New!", Toast.LENGTH_SHORT).show();
                tv1.setText("Hello Sirawich");
                return true;
            case R.id.mnuHelp:
                Toast.makeText(this, "Help!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

}
