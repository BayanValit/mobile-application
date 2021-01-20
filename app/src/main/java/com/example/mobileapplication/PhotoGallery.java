package com.example.mobileapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.mobileapplication.api.FetchItemTask;
import com.example.mobileapplication.api.FlickerFetch;
import com.example.mobileapplication.db.PhotosDB;
import com.example.mobileapplication.model.Example;
import com.example.mobileapplication.model.Photo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PhotoGallery extends AppCompatActivity implements PhotoAdapter.OnInsertListener {

    private PhotosDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);

        final RecyclerView rv = findViewById(R.id.rView);
        rv.setLayoutManager(new GridLayoutManager(this, 3));

        db = PhotosDB.getDatabase(getApplicationContext());

        Retrofit r = FetchItemTask.getRetrofit();
        r.create(FlickerFetch.class).getRecent().enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                response.body();
                Log.v("b", ((Example) response.body()).getPhotos().getTotal());
                PhotoAdapter pa = new PhotoAdapter(this, response.body().getPhotos().getPhoto());
                pa.setOnInsertListener(PhotoGallery.this);
                rv.setAdapter(pa);
            }
            @Override
            public void onFailure(Call<Example> call, Throwable t) {
            }
        });
    }

    @Override
    public void onInsert(Photo photo) {
        db.getPhotoDao().insertPhoto(photo);
    }
}