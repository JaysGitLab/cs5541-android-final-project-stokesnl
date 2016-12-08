package com.bignerdranch.android.pocketturchin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Created by Nathan on 12/7/2016.
 */

public class ArtListFragment extends Fragment
{
    private RecyclerView mArtRecyclerView;
    private ArtAdapter adapter;
    private int searched = -100;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater)
    {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.tool_bar, menu);

        MenuItem searchItem = menu.findItem(R.id.menu_item_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            public boolean onQueryTextSubmit(String s)
            {
                String item = s;
                int search = Integer.parseInt(s);
                searched = search;
                adapter.loadSearched();
                return true;
            }

            public boolean onQueryTextChange(String s)
            {
                return false;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.favorites:
                adapter.loadFavorites();
                return true;

            case R.id.non_favorites:
                adapter.loadArt();
                return true;
            case R.id.about:
                adapter.loadAbout();
                return true;

            default:
                return true;
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_art_list, container, false);

        mArtRecyclerView = (RecyclerView) view.findViewById(R.id.art_recycler_view);
        mArtRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI()
    {
        ArtGallery ag = ArtGallery.get(getActivity());
        List<Art> arts = ag.getArts();

        adapter = new ArtAdapter(arts);
        mArtRecyclerView.setAdapter(adapter);
    }
    private class ArtHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private Art art;
        private TextView artist;
        private TextView title;
        private TextView gallery;
        private ImageView displayImage;

        public ArtHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);

            artist = (TextView) itemView.findViewById(R.id.artist_list);
            title = (TextView) itemView.findViewById(R.id.title_list);
            gallery = (TextView) itemView.findViewById(R.id.gallery_list);
            displayImage = (ImageView) itemView.findViewById(R.id.art_photo_list);
        }

        public void bindArt(Art art)
        {
            this.art = art;
            artist.setText(art.getArtist());
            title.setText(art.getTitle());
            gallery.setText(art.getGallery());
            displayImage.setImageDrawable(art.getImage());
        }

        public void onClick(View v)
        {
            Intent intent = MainActivity.newIntent(getActivity(), art.getId());
            startActivity(intent);
        }
    }

    private class ArtAdapter extends RecyclerView.Adapter<ArtHolder>
    {
        private List<Art> arts;
        private List<Art> favorites = new ArrayList<Art>();

        public ArtAdapter(List<Art> arts)
        {
            this.arts = arts;
        }

        public ArtHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            View view = layoutInflater.inflate(R.layout.list_art_item, parent, false);
            return new ArtHolder(view);
        }

        public void onBindViewHolder(ArtHolder holder, int position)
        {
            Art art = arts.get(position);
            holder.bindArt(art);
        }

        public int getItemCount()
        {
            return arts.size();
        }

        public void loadSearched()
        {
            for(int i = 0; i < arts.size(); i++)
            {
                if(arts.get(i).getSetId() == searched)
                {
                    UUID id = arts.get(i).getId();
                    Intent intent = MainActivity.newIntent(getActivity(), id);
                    startActivity(intent);
                }
            }
        }

        public void loadFavorites()
        {
            favorites = new ArrayList<>();
            for (int i = 0; i < arts.size(); i++)
            {
                if(arts.get(i).getFavorite())
                {
                    favorites.add(arts.get(i));
                }
            }
            mArtRecyclerView.setAdapter(new ArtAdapter(favorites));
        }

        public void loadArt()
        {
            updateUI();
        }

        public void loadAbout()
        {
            Intent intent = new Intent(getActivity(), About.class);
            startActivity(intent);
        }
    }
}
