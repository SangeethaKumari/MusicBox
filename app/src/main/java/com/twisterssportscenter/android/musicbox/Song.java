package com.twisterssportscenter.android.musicbox;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * This class stores the details of song
 * like title,artist,image.
 * Created by sangeetha_gsk on 6/1/18.
 */

public class Song implements Serializable{

    private String songTitle;
    private String artistName;
    private int songImage;
    private int playImage;


    public Song(String songTitle, String artistName, int songImage, int playImage) {
        this.songTitle = songTitle;
        this.artistName = artistName;
        this.songImage = songImage;
        this.playImage = playImage;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getSongImage() {
        return songImage;
    }

    public int getPlayImage() {
        return playImage;
    }
}
