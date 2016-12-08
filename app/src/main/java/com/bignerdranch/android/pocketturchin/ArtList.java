package com.bignerdranch.android.pocketturchin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by Nathan on 12/7/2016.
 */

public class ArtList extends SingleFragmentActivity
{

    @Override
    protected Fragment createFragment()
    {
        return new ArtListFragment();
    }
}
