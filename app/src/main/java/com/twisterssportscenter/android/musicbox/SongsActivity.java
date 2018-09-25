package com.twisterssportscenter.android.musicbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_activity);
        Intent intent = getIntent();
        String musicGenreType = intent.getExtras().get("MUSIC_GENRE").toString();

        final ArrayList<Song> songs = new ArrayList<Song>();
        //creating the araylist song based on music genre
        if (musicGenreType.equals("ROCK")) {
            songs.add(new Song("Art Rock", "David Bowie", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("Blue Rock", "Whitesnake", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("Metal  Rock", "Blue Cheer", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("Tex-Mex", "Ruben Ramos", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("Rock & Roll", "Michael j.", R.drawable.music_icon_4, R.drawable.music_icon1));
        } else if (musicGenreType.equals("CLASSIC MUSIC")) {
            songs.add(new Song("Classic Rock", "David Bowie", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("Western Classical", "Whitesnake", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("Southern Classical", "Blue Cheer", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("Instrument Classic", "Ruben Ramos", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("Drum Classical", "Michael j.", R.drawable.music_icon_4, R.drawable.music_icon1));
        } else if (musicGenreType.equals("BLUES")) {
            songs.add(new Song("Hoochie Coochie Man", "Muddy Waters", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("The Thrill is Gone", "B.B. King", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("Me And The Devil Blues", "Robert Johnson", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("Stone Crazy", "Buddy Guy", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("I’d Rather Go Blind", "Etta James", R.drawable.music_icon_4, R.drawable.music_icon1));
        } else if (musicGenreType.equals("HIP/HOP")) {
            songs.add(new Song("Nice For What", "Drake", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("What Would Meek Do?", "Pusha T Feat. Kanye West ", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("ATM", "J Cole", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("Chun Li", "Nicki Minaj ", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("II Like It", "Cardi B Feat. Bad Bunny & J Balvin ", R.drawable.music_icon_4, R.drawable.music_icon1));
        } else if (musicGenreType.equals("JAZZ")) {
            songs.add(new Song("Take Five", "Dave Brubeck", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("So What", "Miles Davis", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("Take The A Train", "Duke Ellington", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("Round Midnight", "Thelonious Monk", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("My Favorite Things", "John Coltrane", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("A Love Supreme", "John Coltrane", R.drawable.music_icon_4, R.drawable.music_icon1));
        } else if (musicGenreType.equals("VOCAL")) {
            songs.add(new Song("How High the Moon", "June Christy", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("Over the Rainbow", "Judy Garland", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("People", "Barbra Streisand", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("Come On-A My House", "Rosemary Clooney", R.drawable.music_icon_4, R.drawable.music_icon1));
            songs.add(new Song("It Was a Very Good Year", "Frank Sinatra", R.drawable.music_icon_4, R.drawable.music_icon1));
        }

        SongAdapter songAdapter = new SongAdapter(this, songs);

        final ListView listView = (ListView) findViewById(R.id.songs);

        View headerView = getLayoutInflater().inflate(R.layout.song_list_header, null);
        listView.addHeaderView(headerView);

        listView.setAdapter(songAdapter);

        //called when a song is selected from list.
        //the index, song title, songs arraylist are stored in the intent object
        //and passes to the PlayMusicActivity class.
        listView.setOnItemClickListener(new OnItemClickListener() {
            //setting the selected song details and the song arraylist in intent
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song Song1 = (Song) listView.getItemAtPosition(position);
                Intent musicIntent = new Intent(SongsActivity.this, PlayMusicActivity.class);
                musicIntent.putExtra("INDEX", position);
                musicIntent.putExtra("SONG_TITLE", Song1.getSongTitle());
                musicIntent.putExtra("SONG", songs);
                startActivity(musicIntent);
            }
        });
    }
}