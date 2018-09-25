package com.twisterssportscenter.android.musicbox;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sangeetha_gsk on 6/1/18.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_songs, parent, false);
        }
        // Get the {@link Song} object located at this position in the list
        //change the background
        Song song = getItem(position);
        if (position % 2 == 0) {
            listItemView.setBackgroundColor(R.drawable.background_4);
        }else{
            listItemView.setBackgroundColor(R.drawable.background_2);
        }

        // Find the TextView in the list_songs.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.song_title);
        // set this song title text
        nameTextView.setText(song.getSongTitle());

        // Find the TextView in the list_songs.xml layout with the ID version_name
        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artist_name);
        // set this artist name text
        artistNameTextView.setText(song.getArtistName());

        // Find the ImageView in the list_songs.xml layout with the ID version_number
        ImageView songImage = (ImageView) listItemView.findViewById(R.id.song_image);
        // set this  song image
        songImage.setImageResource(song.getSongImage());

        // Find the TextView in the list_songs.xml layout with the ID version_number
        ImageView arrowIcon = (ImageView) listItemView.findViewById(R.id.play_image);
        // set this  play icon image
        arrowIcon.setImageResource(song.getPlayImage());

        // Return the whole list item layout (containing 2 TextViews and 2 ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }
}