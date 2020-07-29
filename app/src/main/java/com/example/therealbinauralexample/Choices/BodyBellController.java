package com.example.therealbinauralexample.Choices;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therealbinauralexample.Adapters.SecondPageAdapter;
import com.example.therealbinauralexample.First_LastPage.LastPage;
import com.example.therealbinauralexample.Items.SecondPageItem;
import com.example.therealbinauralexample.R;

import java.util.ArrayList;

public class BodyBellController extends AppCompatActivity {
    public static final String BODY = "com.example.therealbinauralexample.BODY";

    private ArrayList<SecondPageItem> mSecondPageItemList;
    private RecyclerView mRecyclerView;
    private SecondPageAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page_binaura_beat);
        getSupportActionBar().setTitle("Action Bar 2 ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        createExampleList();
        buildRecyclerView();


    }

    public void createExampleList(){
        mSecondPageItemList = new ArrayList<>();
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_group, "Relaxation", "0.5Hz 60-60.5"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_android, "Universal Healing", "1.5Hz 68-69.5"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_group, "Bliss", "0.9 Hz 80-80.9"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_launcher_foreground, "Reduce Stress", "4.0Hz 418-422"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_attach, "Emotional Healing", "7Hz 284-291"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_android, "Fatigue", "20Hz 220-240"));

    }
    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.second_page_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new SecondPageAdapter(mSecondPageItemList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        final Intent final_Screen = new Intent(this, LastPage.class);
        mAdapter.setOnItemClickListener(new SecondPageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mSecondPageItemList.get(position);


                final_Screen.putExtra(BodyBellController.BODY, position);

                startActivity(final_Screen);
            }
        });


    }




}