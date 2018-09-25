package com.twisterssportscenter.android.musicbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


/**
 * This class is called to play the selected song
 */
public class PlayMusicActivity extends AppCompatActivity {
    boolean isPlay = true;
    int currentElement =0;
    Button nextSongButton ;
    Button previousSongButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_music_activity);
        Intent intent = getIntent();
        String song_title = intent.getExtras().get("SONG_TITLE").toString();

        final TextView nameTextView = (TextView)findViewById(R.id.music_title);
        String index = intent.getExtras().get("INDEX").toString();
        currentElement = Integer.parseInt(index);

        // set this text on the name TextView
        nameTextView.setText("Now playing "+song_title);

        // add cast to ArrayList<Song>
        final ArrayList<Song> songArrayList= (ArrayList<Song>)  intent.getSerializableExtra("SONG");

        nextSongButton = (Button) findViewById(R.id.next);
        previousSongButton = (Button) findViewById(R.id.previous);

        //the user can select the next songs from the list
        nextSongButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                currentElement=currentElement+1;
                if(currentElement<songArrayList.size()){
                    nameTextView.setText("Now playing "+songArrayList.get(currentElement).getSongTitle());
                }
                else{
                    //the message is displayed when the last song in list is reached
                    //and starts playing the first song.
                    Toast.makeText(getBaseContext(),"PLAYING FROM FIRST",Toast.LENGTH_LONG).show();
                    currentElement=0;
                    nameTextView.setText("Now playing "+songArrayList.get(currentElement).getSongTitle());
                }
            }
        });
        //the user can select the previous songs from the list
        previousSongButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                currentElement=currentElement-1;
                if(currentElement>=0){
                    nameTextView.setText("Now playing "+songArrayList.get(currentElement).getSongTitle());
                }
                else{
                    //the message is displayed when the first song in list is reached
                    //and starts playing the first song.
                    Toast.makeText(getBaseContext(),"PLAYING FROM FIRST",Toast.LENGTH_LONG).show();
                    currentElement=0;
                    nameTextView.setText("Now playing "+songArrayList.get(currentElement).getSongTitle());
                }
            }
        });
    }

    /**
     * This method is called on click of pause button
     * from play_music_activity xml file.
     *
     * This method pauses the song being played and
     * again on click plays the song.
     *
     * @param view
     */
    public void pauseMusic(View view) {
        Button pauseButton = (Button) findViewById(R.id.pause);
       if(isPlay) {
           pauseButton.setBackgroundResource(R.drawable.music_icon1);
       }else {
           pauseButton.setBackgroundResource(R.drawable.pause_icon_1);
       }
       isPlay = !isPlay;
    }
}
