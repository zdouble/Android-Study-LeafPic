package com.example.zdouble.leafpic.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.zdouble.leafpic.R;
import com.example.zdouble.leafpic.fragments.AlbumsFragment;


public class MainActivity extends AppCompatActivity {
    private AlbumsFragment albumsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        albumsFragment = new AlbumsFragment();
        setContentFragment();


    }

    private void setContentFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, albumsFragment, AlbumsFragment.TAG)
                .addToBackStack(null)
                .commit();
    }
}
