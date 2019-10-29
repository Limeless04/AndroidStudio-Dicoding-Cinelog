package com.example.moviecatalogueapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviecatalogueapp.Activity.DetailMovieActivity;
import com.example.moviecatalogueapp.MoviesModel.Movies;
import com.example.moviecatalogueapp.R;
import com.example.moviecatalogueapp.SpannableContent;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ListViewHolder> {
    private ArrayList<Movies> listMovies;
    private Context context;

    public void setMovies(ArrayList<Movies> movies) {
        listMovies = movies;
    }

    public MoviesAdapter(Context context, ArrayList<Movies> listMovies) {
        this.context = context;
        this.listMovies = listMovies;
    }

    public MoviesAdapter(ArrayList<Movies> listMovies) {
        this.listMovies = listMovies;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_screen, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Movies movies = listMovies.get(position);
        SpannableContent spannableContent = new SpannableContent();
        spannableContent.getFormatedTitle(movies.getTitle());

        holder.poster.setImageResource(movies.getPhoto());
        holder.tv_title.setText(movies.getTitle());
        holder.tv_title.append(" ");
        holder.tv_title.append(spannableContent.getFormatedYear(movies.getYear()));
        holder.tv_description.setText(movies.getDescription());
        holder.tv_rating.setText(movies.getRating());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detil = new Intent(holder.itemView.getContext(), DetailMovieActivity.class);
                detil.putExtra(DetailMovieActivity.EXTRA_MOVIES, listMovies.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(detil);
            }
        });
        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(),
                        listMovies.get(holder.getAdapterPosition()).getTitle() + " " + holder.itemView.getContext().getResources().getString(R.string.added_to_favorite), Toast.LENGTH_SHORT).show();
            }
        });
        holder.btnWatchList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(),
                        listMovies.get(holder.getAdapterPosition()).getTitle() + " " + holder.itemView.getContext().getResources().getString(R.string.added_to_watchlist), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title, tv_rating, tv_description;
        private ImageView poster;
        Button btnFavorite, btnWatchList;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_rating = itemView.findViewById(R.id.rating);
            poster = itemView.findViewById(R.id.imgPoster);
            btnFavorite = itemView.findViewById(R.id.btn_favorite);
            btnWatchList = itemView.findViewById(R.id.btn_WatchList);
        }
    }
}
