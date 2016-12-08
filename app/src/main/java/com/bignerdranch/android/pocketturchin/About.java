package com.bignerdranch.android.pocketturchin;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Nathan on 12/8/2016.
 */

public class About extends AppCompatActivity
{
    private TextView about;
    private TextView closing;
    private Button test;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_page);
        about = (TextView) findViewById(R.id.about_display);
        String s = "The Turchin Center for the Visual Arts at Appalachian State University engages visitors from the university, community, nation and beyond in creating unique experiences through dynamic and accessible exhibition, education, outreach and collection programs. These programs inspire and support a lifelong engagement with the visual arts and create opportunities for participants to learn more about themselves and the world around them.";
        about.setText(s);
        closing = (TextView) findViewById(R.id.closing_display);
        String s1 = "Copyright 2016, Nathan Stokes";
        String s2 = "Student, Appalachian State University";
        String s3 = "CS 3240 Mobile Device Programming Project";
        closing.setText("\n\n\n\n" + s1 + "\n" + s2 + "\n" + s3 + "\n");

    }

   /* public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.about_page, container, false);

        about = (TextView) view.findViewById(R.id.about_display);
        String s = "The Turchin Center for the Visual Arts at Appalachian State University engages visitors from the university, community, nation and beyond in creating unique experiences through dynamic and accessible exhibition, education, outreach and collection programs. These programs inspire and support a lifelong engagement with the visual arts and create opportunities for participants to learn more about themselves and the world around them.";
        about.setText(s);

        return getView;
    }*/
}
