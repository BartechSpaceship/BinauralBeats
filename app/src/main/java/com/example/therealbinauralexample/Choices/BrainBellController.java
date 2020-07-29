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

public class BrainBellController extends AppCompatActivity {

    public static final String BRAIN = "com.example.therealbinauralexample.BRAIN";
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
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_group, "Anxiety Relief", "2.5Hz 315-317"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_android, "Creativity", "7.5Hz 253-260.5"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_group, "Overcome Addiction", "8.22Hz 350-358.22"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_launcher_foreground, "Relaxed/Awake", "11Hz 400-411"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_attach, "Focus", "40Hz 130-170"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_android, "Intelligence", "15.4Hz 275-290.4"));



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

                final_Screen.putExtra(BrainBellController.BRAIN, position);

                startActivity(final_Screen);
            }
        });


    }




}
