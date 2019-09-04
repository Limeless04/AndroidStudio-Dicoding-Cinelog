package com.example.moviecatalogueapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moviecatalogueapp.MoviesModel.Movies;
import com.example.moviecatalogueapp.R;
import com.example.moviecatalogueapp.SpannableContent;

import java.util.ArrayList;

public class ListViewCatalogueAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movies> movies;

    public void setMovies(ArrayList<Movies> movies) {
        this.movies = movies;
    }

    public ListViewCatalogueAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_home_screen, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        final Movies movies = (Movies) getItem(i);
        viewHolder.bind(movies);
        Button btnFav = view.findViewById(R.id.btn_favorite);
        Button btnAdd = view.findViewById(R.id.btn_WatchList);
        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), movies.getTitle() + " Added to Favorite", Toast.LENGTH_SHORT).show();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), movies.getTitle() + "Added to Watch List", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private class ViewHolder {
        private TextView tv_title, tv_rating, tv_description;
        private ImageView poster;

        ViewHolder(View view) {
            tv_title = view.findViewById(R.id.tv_title);
            tv_description = view.findViewById(R.id.tv_description);
            tv_rating = view.findViewById(R.id.rating);
            poster = view.findViewById(R.id.imgPoster);
        }

        void bind(Movies movies) {

            SpannableContent spannableContent = new SpannableContent();
            spannableContent.getFormatedTitle(movies.getTitle());
            tv_title.setText(spannableContent.getFormatedTitle(movies.getTitle()));
            tv_title.append(" ");
            tv_title.append(spannableContent.getFormatedYear(movies.getYear()));
            tv_rating.setText(movies.getRating());
            tv_description.setText(movies.getDescription());
            poster.setImageResource(movies.getPhoto());

        }
    }

}
