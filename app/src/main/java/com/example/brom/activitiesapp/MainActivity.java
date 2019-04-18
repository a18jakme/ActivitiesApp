package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText mMessageEditText;
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};
    private ArrayList<mountain> bergslista;
    public static final String EXTRA_MESSAGE = "com.example.brom.activitiesapp.extra.MESSAGE";
    public static final String EXTRA_MESSAGE1 = "com.example.brom.activitiesapp.extra.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "com.example.brom.activitiesapp.extra.MESSAGE2";

    // Create ArrayLists from the raw data above and use these lists when populating your ListView.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bergslista = new ArrayList<>();
        bergslista.add(new mountain("Matterhorn","Alps",4478));
        bergslista.add(new mountain("Mont Blanc","Alps",4808));
        bergslista.add(new mountain("Denali","Alaska",6190));
        mountain m=new mountain("Kinnekulle");
        m.setLocation("Västragötaland");
        Log.d("jacke", bergslista.get(0).getLocation());

        ArrayAdapter<mountain> adapter=new ArrayAdapter<mountain>(this,R.layout.list_item_textview,R.id.my_textview,bergslista);
        ListView myListView = (ListView)findViewById(R.id.my_listview);
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mountaininfo = bergslista.get(position).toString();
                String mountaininfo1= bergslista.get(position).getLocation();
                String mountaininfo2= bergslista.get(position).getHeight();
                sendstring(view, mountaininfo, mountaininfo1,mountaininfo2);
            }
        });





        // 1. Create a ListView as in previous assignment
        // 2. Create a new activity named "MountainDetailsActivity
        // 3. Create a new Layout file for the MountainDetailsActivity called
        //    "activity_mountaindetails". MountainDetailsActivity must have MainActivity as its
        //    ´parent activity.
        // 4. The layout file created in step 3 must have a LinearLayout
        // 5. The layout file created in step 3 must be able to display
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 6. When tapping on a list item: create an Intent that includes
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 7. Display the MountainDetailsActivity with the data from the Intent created in step
        //    6
        // 8. From the MountainDetailsActivity you should have an option to "go back" using an
        //    left arro button. This is done by letting the MainActivity be the parent activity to
        //    MountainDetailsActivity.
    }
    public void sendstring (View view, String mountaininfo, String mountaininfo1, String mountaininfo2){
        Intent iNtent = new Intent(getApplicationContext(), Main2Activity.class);
        iNtent.putExtra(EXTRA_MESSAGE, mountaininfo);
        iNtent.putExtra(EXTRA_MESSAGE1, mountaininfo1);
        iNtent.putExtra(EXTRA_MESSAGE2, mountaininfo2);
        startActivity(iNtent);
    }


}
