package com.example.therealbinauralexample.First_LastPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

    //I Could put all the sounds under one position with a lot of numbers tbh and test that w

    public static final int bigBoyInt = 0;
    private ImageView mainImage;
    private ImageButton x_button;
    private SeekBar volumeBar;
    private LoopMediaPlayer mLoopMediaPlayer;
    private ImageButton pauseButton;
    private TextView tempText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_screen);


        mainImage = findViewById(R.id.final_image);
        x_button = findViewById(R.id.x_button);
        pauseButton = findViewById(R.id.pause_button);
        tempText = findViewById(R.id.temp_text);
        volumeBar = findViewById(R.id.sound_level);

        playStudySound();
        playSpiritSound();
        playSleepSound();
        playBrainSound();
        playBodySound();








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

                if (!mLoopMediaPlayer.isPlaying()) {
                    mLoopMediaPlayer.start();
                    pauseButton.setImageResource(R.drawable.pause_button_foreground);

                } else {
                    mLoopMediaPlayer.pause();
                    pauseButton.setImageResource(R.drawable.play_button_foreground);

                }


            }
        });

        //  Volume Bar


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
            Intent studyIntent = getIntent();
            int currentStudyIntent = studyIntent.getIntExtra(StudyBellController.STUDY, 0);

            //This needs to be lower
                if (currentStudyIntent == 1) {
                    mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.study_memory);
                    Toast.makeText(this, "Playing 1", Toast.LENGTH_SHORT).show();
                    tempText.setText("Memory");

                } else if (currentStudyIntent == 2) {
                    mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.study_focus);
                    Toast.makeText(this, "Playing 2", Toast.LENGTH_SHORT).show();
                    tempText.setText("Focus");
                } else if (currentStudyIntent == 3) {
                    mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.study_concentration);
                    tempText.setText("Concentration");
                    Toast.makeText(this, "Playing 3 ", Toast.LENGTH_SHORT).show();
                } else if (currentStudyIntent == 4) {
                    mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.study_study_aid);
                    Toast.makeText(this, "Playing 4", Toast.LENGTH_SHORT).show();
                    tempText.setText("Study Aid");
                } else {
                    //Toast.makeText(this, "invalid STUDY player", Toast.LENGTH_SHORT).show();
                }

        }
        private void playSpiritSound(){
        Intent spiritIntent = getIntent();
        int currentSpiritIntent = spiritIntent.getIntExtra(SpiritBellController.SPIRIT, 0);

            if (currentSpiritIntent == 5) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.spirit_unity);
                Toast.makeText(this, "Playing 5", Toast.LENGTH_SHORT).show();
                tempText.setText("Unity");
            } else if (currentSpiritIntent == 6) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.spirit_inner_awareness);
                Toast.makeText(this, "Playing 6", Toast.LENGTH_SHORT).show();
                tempText.setText("Inner Awareness");
            } else if (currentSpiritIntent == 7){
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.spirit_conciousness);
                Toast.makeText(this, "Playing 7", Toast.LENGTH_SHORT).show();
                tempText.setText("Conciousness");
            } else if (currentSpiritIntent == 8) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.spirit_astral_travel);
                Toast.makeText(this, "Playing 8", Toast.LENGTH_SHORT).show();
                tempText.setText("Astral Travel");
            } else if (currentSpiritIntent == 9 ) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.spirit_solffegio);
                tempText.setText("Solffegio");
            } else if (currentSpiritIntent == 10) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.spirit_trance);
                tempText.setText("Trance");
            } else if (currentSpiritIntent == 11 ) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.spirit_third_eye);
                tempText.setText("Third Eye");
            } else {
                Toast.makeText(this, "invalid SPIRIT player", Toast.LENGTH_SHORT).show();
            }


        }
        private void playSleepSound(){
        Intent sleepIntent = getIntent();
        int currentSleepIntent = sleepIntent.getIntExtra(SleepBellController.SLEEP, 0);
            if (currentSleepIntent == 12) {
                Toast.makeText(this, "Replace 12", Toast.LENGTH_SHORT).show();
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.brain_intelligence);
                tempText.setText("TO BE DONE beat doesnt exist yet");
            } else if (currentSleepIntent == 13) {
                Toast.makeText(this, "Replace 13", Toast.LENGTH_SHORT).show();
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.brain_focus);
                tempText.setText("TO BE DONE beat doesnt exist yet ");
            } else if (currentSleepIntent == 14){
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.sleep_wellbeing);
                tempText.setText("Wellbeing");
            } else if (currentSleepIntent == 15) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.sleep_relaxation);
                tempText.setText("Relaxation");
            } else if (currentSleepIntent == 16 ) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.sleep_restful_sleep);
                tempText.setText("Restful Sleep");
            } else if (currentSleepIntent == 17 ) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.sleep_relief);
                tempText.setText("Sleep Relief but it sounds terrible and needs to be remadew");
            }else {
             //   Toast.makeText(this, "invalid SLEEP player", Toast.LENGTH_SHORT).show();
            }

        }
        private void playBrainSound(){
        Intent brainIntent = getIntent();
            int currentBrainIntent = brainIntent.getIntExtra(BrainBellController.BRAIN, 0);
            if (currentBrainIntent == 18) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.brain_anxiety_relief);
                tempText.setText("Anxiety Relief");
            } else if (currentBrainIntent == 19) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.brain_creativity);
                tempText.setText("Creativity");
            } else if (currentBrainIntent == 20){
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.brain_overcome_addiction);
                tempText.setText("Overcome Addiction");
            } else if (currentBrainIntent == 21) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.brain_relaxed_awake);
                tempText.setText("Relaxed/Focused");
            } else if (currentBrainIntent == 22 ) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.brain_focus);
                tempText.setText("Focus");
            } else if (currentBrainIntent == 23 ) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.brain_intelligence);
                tempText.setText("Intelligence");
            } else {
                Toast.makeText(this, "invalid BRAIN player", Toast.LENGTH_SHORT).show();
            }

        }
        private void playBodySound(){
        Intent bodyIntent = getIntent();
            int currentBodyIntent = bodyIntent.getIntExtra(BodyBellController.BODY, 0);

            if (currentBodyIntent == 24) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.body_relaxation);
                tempText.setText("Relaxation");
            } else if (currentBodyIntent == 25) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.body_universal_healing);
                tempText.setText("Universal Healing");
            } else if (currentBodyIntent == 26){
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.body_bliss);
                tempText.setText("Bliss");
            } else if (currentBodyIntent == 27) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.body_reduce_stress);
                tempText.setText("Reduce Stress");
            } else if (currentBodyIntent == 28 ) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.body_emotional_healing);
                tempText.setText("Emotional Healing");
            } else if (currentBodyIntent == 29 ) {
                mLoopMediaPlayer = new LoopMediaPlayer(this, R.raw.body_fatigue);
                tempText.setText("Fatigue");
            } else {
                Toast.makeText(this, "invalid BODY player", Toast.LENGTH_SHORT).show();
            }
        }

}
