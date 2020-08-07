package com.example.therealbinauralexample.First_LastPage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.therealbinauralexample.Adapters.CardAdapter;
import com.example.therealbinauralexample.Choices.BodyBellController;
import com.example.therealbinauralexample.Choices.BrainBellController;
import com.example.therealbinauralexample.Choices.SleepBellController;
import com.example.therealbinauralexample.Choices.SpiritBellController;
import com.example.therealbinauralexample.Choices.StudyBellController;
import com.example.therealbinauralexample.DonateFragment;
import com.example.therealbinauralexample.FavouriteFragment;
import com.example.therealbinauralexample.HomeFragment;
import com.example.therealbinauralexample.Items.CardItems;
import com.example.therealbinauralexample.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

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
        //getSupportActionBar().setTitle("Binaural Beats! Boom Chika Boom");

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();


      //  createExampleList();
       // buildRecyclerView();


    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.nav_favourite:
                    selectedFragment = new FavouriteFragment();
                    break;
                case R.id.nav_donate:
                    selectedFragment = new DonateFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        }
    };



    public void createExampleList() {
        mCardList = new ArrayList<>();
        mCardList.add(new CardItems(R.drawable.studypic, "Study", "Great for focus, deep work, school and learning"));
        mCardList.add(new CardItems(R.drawable.spiritpic, "Spirit", "Beats that allow for greater spiritual development"));
        mCardList.add(new CardItems(R.drawable.sleeppic, "Sleep", "Used to induce "));
        mCardList.add(new CardItems(R.drawable.brainpic, "Brain", "Intelligence | Focus | Relaxed yet awake | Creativity | Overcome addiction | Releave Anxiety "));
        mCardList.add(new CardItems(R.drawable.bodypic, "Body", "Universal healing | Euphoria | Reduced stress | Emotional healing | Relaxation | Migrane pain | Fatigue"));



    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new CardAdapter(mCardList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        final Intent spirit_intent = new Intent(this, SpiritBellController.class);
        final Intent sleep_intent = new Intent(this, SleepBellController.class);
        final Intent brain_intent = new Intent(this, BrainBellController.class);
        final Intent body_intent = new Intent(this, BodyBellController.class);
        final Intent study_intent = new Intent(this, StudyBellController.class);

        mAdapter.setOnItemClickListener(new CardAdapter.OnItemClickListener() {


            @Override
            public void onItemClick(int position) {
                mCardList.get(position);
                if (position == 0 ) {
                    startActivity(study_intent);
                } else if (position == 1) {
                    startActivity(spirit_intent);
                } else if (position == 2) {
                    startActivity(sleep_intent);
                } else if (position == 3) {
                    startActivity(brain_intent);
                } else if (position == 4) {
                    startActivity(body_intent);
                } else {
                    System.out.println("Error Initializing INTENT");
                }


            }
        });
    }


    }




