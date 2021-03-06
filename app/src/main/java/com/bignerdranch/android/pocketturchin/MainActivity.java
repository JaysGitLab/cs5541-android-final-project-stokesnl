package com.bignerdranch.android.pocketturchin;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class MainActivity extends SingleFragmentActivity
{

    public static final String EXTRA_ART_ID = "com.bignerdranch.finalproject.art_id";

    public static Intent newIntent(Context packageContext, UUID artId)
    {
        Intent intent = new Intent(packageContext, MainActivity.class);
        intent.putExtra(EXTRA_ART_ID, artId);
        return intent;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null)
        {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

    @Override
    protected Fragment createFragment()
    {
        return new ArtFragment();
    }
}
