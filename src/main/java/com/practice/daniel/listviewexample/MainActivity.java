package com.practice.daniel.listviewexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] names = {"Daniel Nguyen","Faysal","Stephen","Parita","That one guy","Brian","Jeff",
                          "Huy","Chris","The Doctor","Matt Smith","David Tennant","Goku","Frieza"};
        //This is going to adapt our array into something our list view can use.
        //Things we are passing in.
        //1) Contextual information about our app. this
        //2) The type of layout we are using
        //3) The array to convert
        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        //Links the mainListView to main_list_view in xml
        final ListView mainListView = (ListView)findViewById(R.id.main_list_view);
        //Tell mainListView what data to use
        mainListView.setAdapter(theAdapter);

        //Now do something when an item is clicked.
        mainListView.setOnItemClickListener(new
            AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Then displayed name picked in a toast.
                    String namePicked = "You picked " + String.valueOf(parent.getItemAtPosition(position));
                    //Display the toast.
                    Toast.makeText(MainActivity.this, namePicked,Toast.LENGTH_LONG).show();
                }
            });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
