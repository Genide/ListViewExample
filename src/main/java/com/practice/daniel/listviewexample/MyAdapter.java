package com.practice.daniel.listviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Daniel on 3/6/2015.
 */
//This is going to be our new class extending ArrayAdapter<String> becuase is what we have been using.
public class MyAdapter extends ArrayAdapter<String> {
    public MyAdapter(Context context, String[] values) {
        //send in our new row_layout_2 to use rather than a generic one.
        super(context, R.layout.row_layout_2, values);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Create a LayoutInflater
        //LayoutInflater puts our layout into the correct view form
        LayoutInflater theInflater = LayoutInflater.from(getContext());
        //Create theView using theInflator
        View theView = theInflater.inflate(R.layout.row_layout_2, parent, false);
        //Get the name picked at the position
        String name = getItem(position);
        //find 1 textView
        TextView theTextView = (TextView)theView.findViewById(R.id.textView1);
        //Set theTextView.text = name
        theTextView.setText(name);
        //Set theImageView = imageView1
        ImageView theImageView = (ImageView) theView.findViewById(R.id.imageView1);
        //Change the image to dot or whatever to you want
        theImageView.setImageResource(R.drawable.dot);
        //return theView
        return theView;

    }
}
