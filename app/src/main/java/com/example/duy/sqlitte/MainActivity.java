package com.example.duy.sqlitte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerteam;
    DBHelper db;
    List<Data> teamlist = new ArrayList<>();
    DBAdapter dbAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerteam = (RecyclerView)findViewById(R.id.recycle);
        db = new DBHelper(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerteam.setLayoutManager(layoutManager);
        dbAdapter = new DBAdapter(db.getallteam(),this);
        recyclerteam.setAdapter(dbAdapter);

        ((Button)findViewById(R.id.button)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int i = db.getCount()+1;//tăng size của số phần tử được truyền vào.
        Data data;
        while(true)
        {
            data = new Data(i,"SKT","ghj");//thêm vào Data
            if(db.addTEAM(data) !=-1)
            {
                dbAdapter.addItem(dbAdapter.getItemCount(),data);//add vào lisst..đồng bộ Data với list data của recycle
                break;
            }
        }
    }
}
