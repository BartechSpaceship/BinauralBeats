package com.example.therealbinauralexample.First_LastPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.therealbinauralexample.Choices.StudyBellController;
import com.example.therealbinauralexample.LoopMediaPlayer;
import com.example.therealbinauralexample.R;

public class LastPage extends AppCompatActivity {

    ImageView mainImage;
    Button x_button;
    SeekBar volumeBar;
    LoopMediaPlayer mLoopMediaPlayer;
    TextView tempTextView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_screen);


        mainImage = findViewById(R.id.final_image);
        x_button = findViewById(R.id.play_button);
        tempTextView = findViewById(R.id.temp_text);


        Intent intent = getIntent();

        int currentIntent = intent.getIntExtra(StudyBellController.EXTRA_TEXT, 2);

        mLoopMediaPlayer.create(this, currentIntent);





        x_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoopMediaPlayer.stop();
                finish();
            }
        });

        //  Volume Bar
        volumeBar = findViewById(R.id.sound_level);
        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volumeNum = progress / 100f;
                mLoopMediaPlayer.setVolume(volumeNum, volumeNum);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
