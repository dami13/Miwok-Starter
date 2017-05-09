package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.miwok.R.id.miwok_text_view;

/**
 * Created by Dami on 23.04.2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> androidWord, int colorId) {
        super(context, 0, androidWord);
        mColorResourceId = colorId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentAndroidWord = getItem(position);

        //setting view color
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        TextView miwokTextView = (TextView) listItemView.findViewById(miwok_text_view);
        miwokTextView.setText(currentAndroidWord.getMiwokTranslation());

        TextView nativeTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        nativeTextView.setText(currentAndroidWord.getDefaultTranslation());

        //image
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        if (currentAndroidWord.hasImage()) {
            image.setImageResource(currentAndroidWord.getImageResourceId());
            image.setVisibility(View.VISIBLE);
        } else
            image.setVisibility(View.GONE);

        ImageView soundImage = (ImageView) listItemView.findViewById(R.id.sound_image_view);
        if (currentAndroidWord.hasSound()) {
            soundImage.setImageResource((currentAndroidWord.getSoundImageResource()));
            soundImage.setVisibility(View.VISIBLE);
        } else
            image.setVisibility(View.GONE);

        //listeners
        final MediaPlayer mediaPlayer = MediaPlayer.create(textContainer.getContext(), currentAndroidWord.getSoundResourceId());

        textContainer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        return listItemView;
    }
}
