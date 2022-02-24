package com.example.qrhunter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
//Refrences: https://www.youtube.com/watch?v=NhiUTjm2BrE
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView QRCode;
    ArrayAdapter<OtherQRCodes> codeAdapter;
    ArrayList<OtherQRCodes> dummyQRlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QRCode = findViewById(R.id.qr_list);

        String[] locations = {"Edmonton, AB", "Vancouver, BC"};
        Date[] dates = {new Date(), new Date()};
        int[] scanners = {10, 15};
        int[] scores = {1000, 500};

        dummyQRlist = new ArrayList<>();

        for (int i = 0; i < locations.length; i++) {
            dummyQRlist.add((new OtherQRCodes(locations[i], dates[i], scanners[i],scores[i])));
        }

        codeAdapter = new CustomQRList(this, dummyQRlist);
        QRCode.setAdapter(codeAdapter);

        //now once the user clicks on the listed item
        QRCode.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //use this to get info of the clicked item
        // adapterView.getItemAtPosition(i);
    }
}