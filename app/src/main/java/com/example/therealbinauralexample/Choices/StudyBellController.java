package com.example.therealbinauralexample.Choices;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therealbinauralexample.Adapters.SecondPageAdapter;
import com.example.therealbinauralexample.First_LastPage.LastPage;
import com.example.therealbinauralexample.Items.SecondPageItem;
import com.example.therealbinauralexample.R;

import java.util.ArrayList;

public class StudyBellController extends AppCompatActivity {


    public static final String STUDY = "com.example.therealbinauralexample.STUDY";


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
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_group, "Memory", "4Hz 210-214"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_android, "Focus", "14Hz 313-327"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_group, "Concentration", "9.33Hz 230.239.33"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_group, "Study Aid", "317-329"));

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
            //Pass the int of the position here and it will play the desired sound
            public void onItemClick(int position) {

                //Gives the int of position
                final_Screen.putExtra(StudyBellController.STUDY, position);

                startActivity(final_Screen);

            }
        });


    }




}
