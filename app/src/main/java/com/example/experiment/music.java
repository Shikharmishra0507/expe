package com.example.experiment;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class music extends AppCompatActivity {
SeekBar seekBar;
Button play,playthis;
MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Bundle bundle=getIntent().getExtras();
        ArrayList<List>songs=(ArrayList)bundle.getParcelableArrayList("List");

        int position=bundle.getInt("position");
         Uri uri =Uri.parse(songs.get(position).toString());
         mediaPlayer=MediaPlayer.create(this,uri);
        play=(Button)findViewById(R.id.play);
        playthis=(Button)findViewById(R.id.songs);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mediaPlayer.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,900);

play.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        mediaPlayer.start();

    }
});
    }
}
