package com.example.moviecatalogueapp.Fragments;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviecatalogueapp.Adapter.MoviesAdapter;
import com.example.moviecatalogueapp.Adapter.TvShowsAdapter;
import com.example.moviecatalogueapp.MoviesModel.Movies;
import com.example.moviecatalogueapp.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowsFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Movies> movies;
    private String[] dataV, dataTitle, dataYear, dataRating, dataDescription, dataDirectore, dataWriter, dataGenre, dataPlaytime;
    TypedArray dataPhoto;
    TvShowsAdapter rvAdapter;

    public TvShowsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepare();
        addItem();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_tv_shows, container, false);
        showListMovies(view);
        return view;
    }
    public void showListMovies(final View view) {
        recyclerView = view.findViewById(R.id.rv_home);
        rvAdapter = new TvShowsAdapter(getContext(), movies);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(rvAdapter);
    }

    public void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title_tv);
        dataYear = getResources().getStringArray(R.array.year_tv);
        dataRating = getResources().getStringArray(R.array.data_rating_tv);
        dataDescription = getResources().getStringArray(R.array.data_description_tv);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo_tv);
        dataV = getResources().getStringArray(R.array.data_video);
        dataDirectore = getResources().getStringArray(R.array.data_creator);
        dataWriter = getResources().getStringArray(R.array.data_stars);
        dataGenre = getResources().getStringArray(R.array.data_genre_tv);
        dataPlaytime = getResources().getStringArray(R.array.data_playtime_tv);

    }

    public void addItem() {
        movies = new ArrayList<>();
        rvAdapter = new TvShowsAdapter(movies);

        for (int i = 0; i < dataTitle.length; i++) {
            Movies movies = new Movies();
            movies.setPhoto(dataPhoto.getResourceId(i, -1));
            movies.setVideo(dataV[i]);
            movies.setTitle(dataTitle[i]);
            movies.setYear(dataYear[i]);
            movies.setRating(dataRating[i]);
            movies.setDirector(dataDirectore[i]);
            movies.setWriter(dataWriter[i]);
            movies.setGenre(dataGenre[i]);
            movies.setDescription(dataDescription[i]);
            movies.setPlaytime(dataPlaytime[i]);
            this.movies.add(movies);
        }
        rvAdapter.setMovies(movies);
    }

}
