package com.example.therealbinauralexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<CardItems> mCardList;

    private RecyclerView mRecyclerView;
    private CardAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        createExampleList();
        buildRecyclerView();


    }


    public void changeItem(int position, String text) {
        mCardList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }


    public void createExampleList() {
        mCardList = new ArrayList<>();
        mCardList.add(new CardItems(R.drawable.ic_android, "Spirit", "Unity | Inner awareness | Shamanic conciousness | Astral travel | Solfeggio | Trance | Third Eye"));
        mCardList.add(new CardItems(R.drawable.ic_attach, "Sleep", "Lucid dreaming | Restful sleep | Relief | Sleep | Wellbeing | Less sleep required"));
        mCardList.add(new CardItems(R.drawable.ic_group, "Body", "Universal healing | Euphoria | Reduced stress | Emotional healing | Relaxation | Migrane pain | Fatigue"));
        mCardList.add(new CardItems(R.drawable.ic_android, "Brain", "Intelligence | Focus | Relaxed yet awake | Creativity | Overcome addiction | Releave Anxiety "));
        mCardList.add(new CardItems(R.drawable.ic_attach, "Study", "Memory | Concentration | Focus | Study aid"));

    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new CardAdapter(mCardList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        final Intent intent = new Intent(this, SpiritBellController.class);
        final Intent intent1 = new Intent(this, SleepBellController.class);
        mAdapter.setOnItemClickListener(new CardAdapter.OnItemClickListener() {


            @Override
            public void onItemClick(int position) {
                mCardList.get(position);
                if (position == 0 ) {
                    startActivity(intent);
                } else if (position == 1) {
                    startActivity(intent1);
                } else {
                    changeItem(position, "clicked");
                }


            }
        });
    }


}


