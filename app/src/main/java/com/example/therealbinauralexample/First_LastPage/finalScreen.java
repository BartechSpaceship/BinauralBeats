package com.example.therealbinauralexample.First_LastPage;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.therealbinauralexample.R;

import java.lang.annotation.Repeatable;

public class finalScreen extends AppCompatActivity {

    MediaPlayer player;
    TextView binaural_type;
    ImageView session_in_progress;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_screen);

       // binaural_type = findViewById(R.id.final_image);
        session_in_progress = findViewById(R.id.final_image);



        //player.setLooping(true);


    }

    public void play(View v){
        if (player == null) {
            player = MediaPlayer.create(this,R.raw.thirdeye);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }
    public void pause(View v) {
        if (player != null) {
            player.pause();
        }
    }
    public void stop(View v) {
        stopPlayer();
    }
    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "Media Player releaseed", Toast.LENGTH_SHORT).show();
        }
    }

    //This will stop the sound once the app is closed
    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}
