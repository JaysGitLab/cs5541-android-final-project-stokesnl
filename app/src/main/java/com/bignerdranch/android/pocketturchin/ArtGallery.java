package com.bignerdranch.android.pocketturchin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Nathan on 12/7/2016.
 */

public class ArtGallery
{
    private static ArtGallery ag;

    private List<Art> arts;


    public static ArtGallery get(Context context)
    {
        if(ag == null)
        {
            ag = new ArtGallery(context);
        }
        return ag;
    }

    private ArtGallery(Context context)
    {
        arts = new ArrayList<>();
        Art art = new Art();
        art.setArtist("Nathan Stokes\n");
        art.setDates("12/25 - 12/31\n");
        art.setDescription("This will be an art show based on the mobile device final program\n");
        art.setGallery("modern programming practices\n");
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.android_image);
        Drawable d = new BitmapDrawable(context.getResources(), bitmap);
        art.setImage(d);
        art.setTitle("Final prgramming assignment\n");
        arts.add(art);

        art = new Art();
        art.setArtist("Dr. Fenwick\n");
        art.setDates("12/29 - 1/15");
        art.setDescription("This will be an art covering modern day computer backgrounds");
        art.setFavorite();
        art.setGallery("Modern Backgrounds");
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
        d = new BitmapDrawable(context.getResources(), bitmap);
        art.setImage(d);
        art.setTitle("Example 2");
        arts.add(art);
        for(int i = 0; i < 1; i++)
        {
            art = new Art();
            art.setArtist("2");
            art.setTitle("1");
            art.setDates("4");
            art.setDescription("5");
            art.setGallery("3");
            bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.android_image);
            d = new BitmapDrawable(context.getResources(), bitmap);
            art.setImage(d);
            arts.add(art);
        }
    }

    public List<Art> getArts()
    {
        return arts;
    }

    public Art getArt(UUID id)
    {
        for (Art art : arts)
        {
            if (art.getId().equals(id))
            {
                return art;
            }
        }
        return null;
    }
}
