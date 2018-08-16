package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word word = getItem(position);


        TextView defaultTranslation = (TextView) listItemView.findViewById(R.id.default_text);
        TextView miwokTranslation = (TextView) listItemView.findViewById(R.id.miwok_text);

        defaultTranslation.setText(word.getDefaultTranslation());
        miwokTranslation.setText(word.getMiwokTranslation());

        return listItemView;
    }

}
