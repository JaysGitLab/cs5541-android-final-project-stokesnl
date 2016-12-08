package com.bignerdranch.android.pocketturchin;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Nathan on 12/7/2016.
 */

public class Art
{
    private String title;
    private String artist;
    private String gallery;
    private boolean favorite;
    private String description;
    private String dates;
    private Drawable image;
    private UUID mId;
    private AssetManager mAssets;
    private MediaPlayer mp;
    private int id;
    private static int count = 0;


    public Art()
    {
        mId = UUID.randomUUID();
        id = count;
        count++;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Drawable getImage()
    {
        return image;
    }

    public void setImage(Drawable image)
    {
        this.image = image;
    }

    public String getDates() {
        return "Displayed from: " + dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFavorite()
    {
        if(favorite == false)
        {
            favorite = true;
        }
        else
        {
            favorite = false;
        }
    }

    public boolean getFavorite()
    {
        return favorite;
    }

    public int getSetId()
    {
        return id;
    }
}

