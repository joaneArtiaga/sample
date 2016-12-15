package com.example.resty.lrucachesample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.LruCache;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LruCache<Integer,SampleObject> lru;
    EditText editTextTitle, editTextMessage;
    Button add;
    ListView listview;
    SampleAdapter sampleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lru = new LruCache<Integer,SampleObject>(100);
        listview = (ListView) findViewById(R.id.listview);

//        editTextTitle = (EditText) findViewById(R.id.titleEditText);
//        editTextMessage = (EditText) findViewById(R.id.messageEditText);
        add = (Button) findViewById(R.id.buttonSave);

        sampleAdapter = new SampleAdapter(getApplicationContext(),new ArrayList<SampleObject>(lru.snapshot().values()));
        listview.setAdapter(sampleAdapter);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, FillUp.class);
                startActivity(myIntent);

//                SampleObject obj = new SampleObject();
//                obj.setTitle(editTextTitle.getText().toString());
//                obj.setMessage(editTextMessage.getText().toString());
//                obj.setKey(lru.size());
//                lru.put(obj.getKey(), obj);
//
//                sampleAdapter.setValues(new ArrayList<SampleObject>(lru.snapshot().values()));
//                sampleAdapter.notifyDataSetChanged();
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SampleObject obj = sampleAdapter.getValues().get(position);

                lru.get(obj.getKey());

                sampleAdapter.setValues(new ArrayList<SampleObject>(lru.snapshot().values()));
                sampleAdapter.notifyDataSetChanged();
            }
        });
    }


}
