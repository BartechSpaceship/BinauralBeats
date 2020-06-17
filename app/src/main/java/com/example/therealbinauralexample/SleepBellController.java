package com.example.therealbinauralexample;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SleepBellController extends AppCompatActivity {
    private ArrayList<SecondPageItem> mSecondPageItemList;

    private RecyclerView mRecyclerView;
    private SecondPageBinauralBeatAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page_binaura_beat);
        Log.d("SecondPage", "onCreate: SECONDPAGECREATEDSUCCESSFULY");

        createExampleList();
        buildRecyclerView();


    }

    public void createExampleList(){
        mSecondPageItemList = new ArrayList<>();
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_group, "Sleep", "2.0Hz TBD"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_android, "Lucid Dreaming", "1.5Hz TBD"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_group, "Wellbeing", "1.5Hz 56-57"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_launcher_foreground, "Relaxation", "5Hz 220-225"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_attach, "Restful sleep", "3.4Hz - 126-130.4"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_android, "Relief", "10Hz 280-290"));



    }
    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.second_page_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new SecondPageBinauralBeatAdapter(mSecondPageItemList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }




}
