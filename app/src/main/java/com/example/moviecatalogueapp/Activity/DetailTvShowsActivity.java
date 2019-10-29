package com.example.moviecatalogueapp.Activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moviecatalogueapp.MoviesModel.Movies;
import com.example.moviecatalogueapp.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class DetailTvShowsActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv1, tv2, title, year, description, rating, creator, stars, genre, playtime;
    ImageView poster;
    Button btnFavorite, btnPlaylist;
    Movies movies;
    public static final String EXTRA_MOVIES="EXTRA_MOVIES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);
        backButton();

        movies = getIntent().getParcelableExtra("EXTRA_MOVIES");

        tv1 = findViewById(R.id.tv_1);
        tv1.setText(R.string.creator);
        tv2 = findViewById(R.id.tv_2);
        tv2.setText(R.string.stars);

        title = findViewById(R.id.title);
        year = findViewById(R.id.year);
        description = findViewById(R.id.tv_description);
        poster = findViewById(R.id.imgPoster);
        rating = findViewById(R.id.rating);
        creator = findViewById(R.id.tv_value_1);
        stars = findViewById(R.id.tv_value_2);
        playtime = findViewById(R.id.tv_playtime);
        genre = findViewById(R.id.tv_genre);
        btnFavorite = findViewById(R.id.btn_favorite);
        btnFavorite.setOnClickListener(this);
        btnPlaylist = findViewById(R.id.btn_WatchList);
        btnPlaylist.setOnClickListener(this);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.imgVideo);
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(movies.getVideo(), 0);
            }
        });


        display(movies);


    }

    public void display(Movies movies) {
        title.setText(movies.getTitle());
        rating.setText(movies.getRating());
        year.setText(movies.getYear());
        description.setText(movies.getDescription());
        poster.setImageResource(movies.getPhoto());
        creator.setText(movies.getDirector());
        stars.setText(movies.getWriter());
        playtime.setText(movies.getPlaytime());
        genre.setText(movies.getGenre());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_favorite:
                Toast.makeText(view.getContext(), movies.getTitle() + " " + view.getContext().getResources().getString(R.string.added_to_favorite), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_WatchList:
                Toast.makeText(view.getContext(), movies.getTitle() + " " + view.getContext().getResources().getString(R.string.added_to_watchlist), Toast.LENGTH_SHORT).show();
                break;
        }

    }

    public void backButton() {
        if (getSupportActionBar() != null) {
            movies = getIntent().getParcelableExtra(EXTRA_MOVIES);

            getSupportActionBar().setTitle(movies.getTitle());
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
