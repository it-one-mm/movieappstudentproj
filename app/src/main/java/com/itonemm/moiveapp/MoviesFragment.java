package com.itonemm.moiveapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {


    public MoviesFragment() {
        // Required empty public constructor
    }
    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View convertview= inflater.inflate(R.layout.fragment_movies, container, false);

       gridView=convertview.findViewById(R.id.grid_all_movies);
        MovieModel movieModel1=new MovieModel("https://upload.wikimedia.org/wikipedia/en/thumb/b/b5/Supernatural_Season_9.jpg/220px-Supernatural_Season_9.jpg","Super Natural","Rating 9.5");
        MovieModel movieModel2=new MovieModel("https://image.tmdb.org/t/p/w185/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg","Arrow ", "Rating 9.8");
        ArrayList<MovieModel> movieModels=new ArrayList<MovieModel>();
        movieModels.add(movieModel1);
        movieModels.add(movieModel2);
        GridAdapter adapter=new GridAdapter(movieModels);
        gridView.setAdapter(adapter);

       return  convertview;
    }


    private  class  GridAdapter extends BaseAdapter
    {
        ArrayList<MovieModel> movieModels;

        public GridAdapter(ArrayList<MovieModel> movieModels) {
            this.movieModels = movieModels;
        }

        @Override
        public int getCount() {
            return movieModels.size();
        }

        @Override
        public Object getItem(int position) {
            return movieModels.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            final  MovieModel movieModel=movieModels.get(position);
            View view=inflater.inflate(R.layout.itemimage,null);
            ImageView movieimage=view.findViewById(R.id.movieimagegridview);
            TextView moviename=view.findViewById(R.id.movienamegridview);
            Glide.with(getContext())
                    .load(movieModel.imagelink)
                    .override(100,200)
                    .into(movieimage);
            moviename.setText(movieModel.moviename);
            return view;
        }
    }

}
