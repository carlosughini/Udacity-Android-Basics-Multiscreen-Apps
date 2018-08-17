package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    /** Resource ID for the background coor of this list of words */
    private int mColorResourceId;

    /*
    * Create a new WordAdapter object.
    *
    * @param context is the current context (i.e. Activity) that the adapter is being created in
    * @param words is the list of Words to be displayed.
     */
    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the Word object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID default_text.
        TextView defaultTranslation = (TextView) listItemView.findViewById(R.id.default_text);
        // Get the default translation from the currentWord object and set this text on the default TextView
        defaultTranslation.setText(currentWord.getDefaultTranslation());

        // Find the TextView in the list_item.xml layout with the ID miwok_text.
        TextView miwokTranslation = (TextView) listItemView.findViewById(R.id.miwok_text);
        // Get the miwok translation from the currentWord object and set this text on the default TextView
        miwokTranslation.setText(currentWord.getMiwokTranslation());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()) {
            // Get the image from the currentWord object and set this image on the ImageView
            image.setImageResource(currentWord.getImageResourceId());

            // Make sure the view is visibile
            image.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            image.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }

}
