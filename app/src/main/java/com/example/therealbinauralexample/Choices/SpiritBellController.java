package com.example.therealbinauralexample.Choices;


import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therealbinauralexample.R;
import com.example.therealbinauralexample.Adapters.SecondPageAdapter;
import com.example.therealbinauralexample.Items.SecondPageItem;

import java.util.ArrayList;

//This is where I will create adapter with all the items, and then on click this will populate the new view
public class SpiritBellController extends AppCompatActivity {
    private ArrayList<SecondPageItem> mSecondPageItemList;

    private RecyclerView mRecyclerView;
    private SecondPageAdapter mAdapter;
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
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_group, "Unity", "3.5Hz 123.5-127"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_android, "Inner Awareness", "3.9Hz 111-114.9"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_group, "Shamanic Conciousness", "4.5hz 200-204.5"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_launcher_foreground, "Astral Travel", "6.3Hz 242-246.3 "));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_attach, "Solffegio", "7.83Hz 430-437.83"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_android, "Trance", "5.5Hz 131-136.5"));
        mSecondPageItemList.add(new SecondPageItem(R.drawable.ic_attach, "Third Eye", "13Hz 185-198"));


    }
    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.second_page_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new SecondPageAdapter(mSecondPageItemList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);



    }




}
