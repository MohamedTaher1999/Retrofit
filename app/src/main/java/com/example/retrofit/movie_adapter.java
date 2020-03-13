package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class movie_adapter extends RecyclerView.Adapter<movie_adapter.movieViewHolder> {
    private Context mContext;
    private ArrayList<movieModel> mMovieList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
      void Click(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public movie_adapter(Context mContext, ArrayList<movieModel> mMovieList) {
        this.mContext = mContext;
        this.mMovieList = mMovieList;
    }


    @Override
    public movie_adapter.movieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View v= LayoutInflater.from(mContext).inflate(R.layout.movie_item,parent,false);
        return new movieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull movie_adapter.movieViewHolder holder, int position) {
        movieModel currentItem = mMovieList.get(position);

        String imageUrl = currentItem.getPoster_path();
        Picasso.with(mContext).load("https://image.tmdb.org/t/p/w500"+imageUrl).fit().centerInside().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }


    public class movieViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public movieViewHolder(@NonNull View movieView) {
            super(movieView);

            imageView=movieView.findViewById(R.id.img_pic);

            movieView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.Click( position );
                        }
                    }
                }
            });
        }

    }
}