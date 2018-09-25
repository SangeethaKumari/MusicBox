package com.twisterssportscenter.android.musicbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonGenre01 = (Button) findViewById(R.id.genre_01);
        buttonGenre01.setOnClickListener(onClickListener);
        Button buttonGenre02 = (Button) findViewById(R.id.genre_02);
        buttonGenre02.setOnClickListener(onClickListener);
        Button buttonGenre03 = (Button) findViewById(R.id.genre_03);
        buttonGenre03.setOnClickListener(onClickListener);
        Button buttonGenre04 = (Button) findViewById(R.id.genre_04);
        buttonGenre04.setOnClickListener(onClickListener);
        Button buttonGenre05 = (Button) findViewById(R.id.genre_05);
        buttonGenre05.setOnClickListener(onClickListener);
        Button buttonGenre06 = (Button) findViewById(R.id.genre_06);
        buttonGenre06.setOnClickListener(onClickListener);
    }

    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String genreType = null;
            switch (v.getId()) {
                case R.id.genre_01:
                    genreType = "ROCK";
                    break;
                case R.id.genre_02:
                    genreType = "CLASSIC MUSIC";
                    break;
                case R.id.genre_03:
                    genreType = "BLUES";
                    break;
                case R.id.genre_04:
                    genreType = "HIP/HOP";
                    break;
                case R.id.genre_05:
                    genreType = "JAZZ";
                    break;
                case R.id.genre_06:
                    genreType = "VOCAL";
                    break;

            }
            Intent musicGenreIntent = new Intent(MainActivity.this, SongsActivity.class);
            musicGenreIntent.putExtra("MUSIC_GENRE", genreType);
            startActivity(musicGenreIntent);

        }
    };
}