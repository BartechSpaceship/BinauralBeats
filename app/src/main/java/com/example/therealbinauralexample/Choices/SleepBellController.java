package com.example.therealbinauralexample.Choices;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therealbinauralexample.First_LastPage.LastPage;
import com.example.therealbinauralexample.R;
import com.example.therealbinauralexample.Adapters.SecondPageAdapter;
import com.example.therealbinauralexample.Items.SecondPageItem;

import java.util.ArrayList;

public class SleepBellController extends AppCompatActivity {
    public static final String SLEEP = "com.example.therealbinauralexample.SLEEP";
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
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_group, "Sleep", "2.0Hz TBD"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_android, "Lucid Dreaming", "1.5Hz TBD"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_group, "Wellbeing", "1.5Hz 68-69.5"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_launcher_foreground, "Relaxation", "5Hz 220-225"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_attach, "Restful sleep", "3.4Hz - 126-130.4"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_android, "Relief", "10Hz 280-290"));



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

                        final_Screen.putExtra(SleepBellController.SLEEP, position + 11);

                        startActivity(final_Screen);
            }
        });


    }




}
