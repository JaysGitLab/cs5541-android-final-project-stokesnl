package com.bignerdranch.android.pocketturchin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.util.UUID;

/**
 * Created by Nathan on 12/7/2016.
 */

public class ArtFragment extends Fragment
{
    private Art art;
    private ImageView mainImage;
    private File mPhotoFile;
    private TextView title;
    private TextView artist;
    private TextView gallery;
    private TextView galleryDates;
    private TextView favorite;
    private TextView galleryDesc;
    private CheckBox favorited;
    private Button audioDesc;



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        UUID artId = (UUID) getActivity().getIntent().getSerializableExtra(MainActivity.EXTRA_ART_ID);
        art = ArtGallery.get(getActivity()).getArt(artId);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.art_fragment, container, false);

        mainImage = (ImageView) v.findViewById(R.id.art_photo);
        mainImage.setImageDrawable(art.getImage());

        title = (TextView) v.findViewById(R.id.title);
        title.setText(art.getTitle());

        artist = (TextView) v.findViewById(R.id.artist);
        artist.setText(art.getArtist());

        gallery = (TextView) v.findViewById(R.id.gallery);
        gallery.setText("This piece is a part of the " + art.getGallery() + "art gallery");

        galleryDates = (TextView) v.findViewById(R.id.gallery_dates);
        galleryDates.setText(art.getDates());

        favorite = (TextView) v.findViewById(R.id.favorite);

        favorited = (CheckBox) v.findViewById(R.id.favorited);
        favorited.setChecked(art.getFavorite());
        favorited.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isFavorited)
            {
                art.setFavorite();
            }
        });

        audioDesc = (Button) v.findViewById(R.id.audio_desc);
        audioDesc.setText("Audio Description");
        final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.sounds);
        audioDesc.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                mp.start();
            }
        });

        galleryDesc = (TextView) v.findViewById(R.id.gallery_description);
        galleryDesc.setText(art.getDescription());
        return v;
    }
}
