package com.example.therealbinauralexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CardAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayList<CardItems> cardList = new ArrayList<>();

        cardList.add(new CardItems(R.drawable.ic_android, "Spirit", "Unity | Inner awareness | Shamanic conciousness | Astral travel | Solfeggio | Trance | Third Eye"));
        cardList.add(new CardItems(R.drawable.ic_attach, "Sleep", "Lucid dreaming | Restful sleep | Relief | Sleep | Wellbeing | Less sleep required"));
        cardList.add(new CardItems(R.drawable.ic_group, "Body", "Universal healing | Euphoria | Reduced stress | Emotional healing | Relaxation | Migrane pain | Fatigue"));
        cardList.add(new CardItems(R.drawable.ic_android, "Brain", "Intelligence | Focus | Relaxed yet awake | Creativity | Overcome addiction | Releave Anxiety "));
        cardList.add(new CardItems(R.drawable.ic_attach, "Study", "Memory | Concentration | Focus | Study aid"));





            mRecyclerView = findViewById(R.id.recyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new CardAdapter(cardList);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener(new CardAdapter.OnItemClickListener() {


                @Override
                public void onItemClick(int position) {
                    cardList.get(position).changeText1("Clicked");
                }
            });

        }

    }

