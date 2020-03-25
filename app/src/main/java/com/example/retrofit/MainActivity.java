package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import android.widget.Toast;

import com.example.retrofit.model.Moviedata;
import com.example.retrofit.model.ResultsMovies;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements movie_adapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    private movie_adapter mMovieAdapter;
    private ArrayList<ResultsMovies> movieList ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mRecyclerView = findViewById( R.id.re_view );
        mRecyclerView.setHasFixedSize( true );
        mRecyclerView.setLayoutManager( new LinearLayoutManager( this ) );

          getMovies();

    }
      /*  public void showList(){


            String[] movie = new String[movieList.size()];
            for (int i = 0; i < movieList.size(); i++) {
                movie[i] = movieList.get( i ).getPoster_path();
            }
            mMovieAdapter = new movie_adapter(MainActivity.this, movieList);
            mRecyclerView.setAdapter( mMovieAdapter);
            mMovieAdapter.setOnItemClickListener(MainActivity.this);
        }*/




    @Override
    public void Click(int position) {
       // Intent detailIntent = new Intent( this, movieDetail.class );
      //  movieModel clickedItem = movieList.get( position );
     //   movieModel item = new movieModel( clickedItem.getPoster_path(), clickedItem.getOriginal_title(), clickedItem.getOverview() );
      //  detailIntent.putExtra( "object", (Parcelable) item );

       // startActivity( detailIntent );
    }

    private void getMovies() {
        final ProgressDialog loading = ProgressDialog.show( this, "Fetching Data", "Please Wait...", false, false );

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( "https://api.themoviedb.org/" )
                .addConverterFactory( GsonConverterFactory.create() ).build();

        retrofit_Interface movie_api = retrofit.create( retrofit_Interface.class );

        //TODO:what is the parameter of this method?
        movie_api
        .getMovies()
        .enqueue(new Callback<ResultsMovies>() {
            @Override
            public void onResponse(Call<ResultsMovies> call, Response<ResultsMovies> response) {
                ResultsMovies data = response.body();
                ArrayList<Moviedata> movieslist=new ArrayList<>();
                for(Moviedata m:data.getResults()){

                    movieslist.add(m);
                    System.out.println(m.getOriginal_title());
                }

            }

            @Override
            public void onFailure(Call<ResultsMovies> call, Throwable t) {

            }
        });



    }

}