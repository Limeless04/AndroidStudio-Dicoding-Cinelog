package com.example.moviecatalogueapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.moviecatalogueapp.Adapter.ListViewCatalogueAdapter;
import com.example.moviecatalogueapp.MoviesModel.Movies;
import com.example.moviecatalogueapp.R;

import java.util.ArrayList;

import static com.example.moviecatalogueapp.Activity.DetailMovieActivity.EXTRA_MOVIES;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayList<Movies> movies;
    private String[] dataTitle, dataYear, dataRating, dataDescription, dataDirectore, dataWriter, dataGenre, dataPlaytime;
    TypedArray dataPhoto, dataV;
    ListViewCatalogueAdapter listViewCatalogueAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewCatalogueAdapter = new ListViewCatalogueAdapter(this);
        ListView listView = findViewById(R.id.lv_home);
        listView.setAdapter(listViewCatalogueAdapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(this);
    }

        public void prepare () {
            dataTitle = getResources().getStringArray(R.array.data_title);
            dataYear = getResources().getStringArray(R.array.year);
            dataRating = getResources().getStringArray(R.array.data_rating);
            dataDescription = getResources().getStringArray(R.array.data_description);
            dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
            dataV = getResources().obtainTypedArray(R.array.data_v);
            dataDirectore = getResources().getStringArray(R.array.data_director);
            dataWriter = getResources().getStringArray(R.array.data_writer);
            dataGenre = getResources().getStringArray(R.array.data_genre);
            dataPlaytime = getResources().getStringArray(R.array.data_playtime);

        }

        private void addItem () {
            movies = new ArrayList<>();

            for (int i = 0; i < dataTitle.length; i++) {
                Movies movies = new Movies();
                movies.setPhoto(dataPhoto.getResourceId(i, -1));
                movies.setVideo(dataV.getResourceId(i, -1));
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
            listViewCatalogueAdapter.setMovies(movies);
        }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getBaseContext(), DetailMovieActivity.class);
        intent.putExtra(EXTRA_MOVIES, movies.get(i));
        startActivity(intent);
    }
}
