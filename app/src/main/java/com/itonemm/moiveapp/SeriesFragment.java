package com.itonemm.moiveapp;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
public class SeriesFragment extends Fragment {


    GridView gridView;
    RecyclerView recyclerView;
    public SeriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_series, container, false);
        gridView=view.findViewById(R.id.grid_all_series);
        recyclerView=view.findViewById(R.id.rc_new_series);
        ArrayList<SeriesModel> seriesModels=new ArrayList<SeriesModel>();
        seriesModels.add(new SeriesModel(1,"Tale of Nokdu","https://image.tmdb.org/t/p/w185/r8BhphHIruCL2jM4sd1Zs6sMJov.jpg"));
        seriesModels.add(new SeriesModel(2,"Melting me Softlay","https://upload.wikimedia.org/wikipedia/en/thumb/6/67/Melting_Me_Softly.jpg/250px-Melting_Me_Softly.jpg"));
        seriesModels.add(new SeriesModel(3,"VIP","https://image.tmdb.org/t/p/w185/bBIiRnCVOifc1eaW7sCbJHSWJ68.jpg"));

        GridApater ad=new GridApater(seriesModels);
        gridView.setAdapter(ad);

        SeriesRcAdpater adpater=new SeriesRcAdpater(seriesModels);
        recyclerView.setAdapter(adpater);

        LinearLayoutManager l=new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(l);

        return view;
    }

    private class GridApater extends BaseAdapter
    {
        ArrayList<SeriesModel> seriesModels;

        public GridApater(ArrayList<SeriesModel> seriesModels) {
            this.seriesModels = seriesModels;
        }

        @Override
        public int getCount() {
            return seriesModels.size();
        }

        @Override
        public Object getItem(int position) {
            return seriesModels.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            final  SeriesModel seriesModel=seriesModels.get(position);
            View view=inflater.inflate(R.layout.itemimage,null);
            ImageView seriesimag=view.findViewById(R.id.movieimagegridview);
            TextView seriesname=view.findViewById(R.id.movienamegridview);
            Glide.with(getContext())
                    .load(seriesModel.SeriesImage)
                    .into(seriesimag);
            seriesname.setText(seriesModel.SeriesName);
            return view;
        }
    }

    public class SeriesRcAdpater extends RecyclerView.Adapter<SeriesRcAdpater.SeriesHolder>{


        ArrayList<SeriesModel> seriesModels;

        public SeriesRcAdpater(ArrayList<SeriesModel> seriesModels) {
            this.seriesModels = seriesModels;
        }

        @NonNull
        @Override
        public SeriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.itemimage,parent,false);
            SeriesHolder holder=new SeriesHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull SeriesHolder holder, int position) {

            final  SeriesModel seriesModel=seriesModels.get(position);
            Glide.with(getContext())
                    .load(seriesModel.SeriesImage)
                    .into(holder.imageView);
            holder.textView.setText(seriesModel.SeriesName);

        }

        @Override
        public int getItemCount() {
            return seriesModels.size();
        }

        public  class SeriesHolder extends RecyclerView.ViewHolder
        {
            ImageView imageView;
            TextView textView;
            public SeriesHolder(@NonNull View itemView) {
                super(itemView);
                imageView=itemView.findViewById(R.id.movieimagegridview);
                textView=itemView.findViewById(R.id.movienamegridview);
            }
        }

    }
}
