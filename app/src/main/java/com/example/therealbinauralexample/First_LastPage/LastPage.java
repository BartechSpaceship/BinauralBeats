package com.example.therealbinauralexample.First_LastPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.therealbinauralexample.Choices.BodyBellController;
import com.example.therealbinauralexample.Choices.BrainBellController;
import com.example.therealbinauralexample.Choices.SleepBellController;
import com.example.therealbinauralexample.Choices.SpiritBellController;
import com.example.therealbinauralexample.Choices.StudyBellController;
import com.example.therealbinauralexample.LoopMediaPlayer;
import com.example.therealbinauralexample.R;

public class LastPage extends AppCompatActivity {

    public int bigBoyInt = 0;
    private ImageView mainImage;
    private Button x_button;
    private SeekBar volumeBar;
    private LoopMediaPlayer mLoopMediaPlayer;
    private Button pauseButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_screen);


        mainImage = findViewById(R.id.final_image);
        x_button = findViewById(R.id.play_button);
        pauseButton = findViewById(R.id.pause_button);


        playStudySound();
        playSpiritSound();
        playSleepSound();


        //Will end the activity and stop the sound
        x_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoopMediaPlayer.stop();
                finish();
            }
        });

        //If the sound is playing it will pause it but will reset where it left off
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLoopMediaPlayer.isPlaying() == true) {
                    mLoopMediaPlayer.pause();
                } else
                    mLoopMediaPlayer.start();
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

        private void playStudySound () {

            //Taking the intent from STUDYCONTROLLER
            Intent studyIntent = getIntent();
            int currentIntent = studyIntent.getIntExtra(StudyBellController.STUDY, 0);

            //This needs to be lower
            if (currentIntent == 0) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.study_memory);
            } else if (currentIntent == 1) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.study_focus);
            } else if (currentIntent == 2){
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.study_concentration);
            } else if (currentIntent == 3) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.study_study_aid);
            } else {
                Toast.makeText(this, "invalid STUDY player", Toast.LENGTH_SHORT).show();
            }

        }
        private void playSpiritSound(){
        Intent spiritIntent = getIntent();
        int currentSpiritIntent = spiritIntent.getIntExtra(SpiritBellController.SPIRIT, 0);
            if (currentSpiritIntent == 4) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.spirit_unity);
            } else if (currentSpiritIntent == 5) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.spirit_inner_awareness);
            } else if (currentSpiritIntent == 6){
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.spirit_conciousness);
            } else if (currentSpiritIntent == 7) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.spirit_astral_travel);
            } else if (currentSpiritIntent == 8 ) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.spirit_solffegio);
            } else if (currentSpiritIntent == 9 ) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.spirit_trance);
            } else if (currentSpiritIntent == 10 ) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.spirit_third_eye);
            } else {
                Toast.makeText(this, "invalid STUDY player", Toast.LENGTH_SHORT).show();
            }


        }
        private void playSleepSound(){
        Intent sleepIntent = getIntent();
        int currentSleepIntent = sleepIntent.getIntExtra(SleepBellController.SLEEP, 0);
            if (currentSleepIntent == 11) {
                Toast.makeText(this, "11", Toast.LENGTH_SHORT).show();
             //   mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.brain_intelligence);
            } else if (currentSleepIntent == 12) {
                Toast.makeText(this, "12", Toast.LENGTH_SHORT).show();
            //    mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.brain_focus);
            } else if (currentSleepIntent == 13){
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.sleep_wellbeing);
            } else if (currentSleepIntent == 14) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.sleep_relaxation);
            } else if (currentSleepIntent == 15 ) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.sleep_restful_sleep);
            } else if (currentSleepIntent == 16 ) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.sleep_relief);
            }else {
                Toast.makeText(this, "invalid STUDY player", Toast.LENGTH_SHORT).show();
            }

        }
        private void playBrainSound(){
        Intent brainIntent = getIntent();
            int currentBrainIntent = brainIntent.getIntExtra(BrainBellController.BRAIN, 0);
            if (currentBrainIntent == 0) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.brain_anxiety_relief);
            } else if (currentBrainIntent == 1) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.brain_creativity);
            } else if (currentBrainIntent == 2){
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.brain_overcome_addiction);
            } else if (currentBrainIntent == 3) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.brain_relaxed_awake);
            } else if (currentBrainIntent == 4 ) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.brain_focus);
            } else if (currentBrainIntent == 5 ) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.brain_intelligence);
            } else {
                Toast.makeText(this, "invalid STUDY player", Toast.LENGTH_SHORT).show();
            }

        }
        private void playBodySound(){
        Intent bodyIntent = getIntent();
            int currentBodyIntent = bodyIntent.getIntExtra(BodyBellController.BODY, 0);

            if (currentBodyIntent == 0) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.body_relaxation);
            } else if (currentBodyIntent == 1) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.body_universal_healing);
            } else if (currentBodyIntent == 2){
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.body_bliss);
            } else if (currentBodyIntent == 3) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.body_reduce_stress);
            } else if (currentBodyIntent == 4 ) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.body_emotional_healing);
            } else if (currentBodyIntent == 5 ) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.body_fatigue);
            } else {
                Toast.makeText(this, "invalid STUDY player", Toast.LENGTH_SHORT).show();
            }
        }

}
