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
import com.example.moviecatalogueapp.MoviesModel.Movies;
import com.example.moviecatalogueapp.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {
    private ArrayList<Movies> movies;
    private String[] dataTitle,dataV, dataYear, dataRating, dataDescription, dataDirectore, dataWriter, dataGenre, dataPlaytime;
    private TypedArray dataPhoto;
    private MoviesAdapter rvAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prepare();
        addItem();
    }

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        showListMovies(view);
        return view;
    }

    private void showListMovies(final View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_home);
        rvAdapter = new MoviesAdapter(getContext(), movies);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(rvAdapter);
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataYear = getResources().getStringArray(R.array.year);
        dataRating = getResources().getStringArray(R.array.data_rating);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        dataV = getResources().getStringArray(R.array.data_video_link);
        dataDirectore = getResources().getStringArray(R.array.data_stars);
        dataWriter = getResources().getStringArray(R.array.data_writer);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataPlaytime = getResources().getStringArray(R.array.data_playtime);

    }

    private void addItem() {
        movies = new ArrayList<>();
        rvAdapter = new MoviesAdapter(movies);

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
