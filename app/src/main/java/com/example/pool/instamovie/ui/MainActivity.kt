package com.example.pool.instamovie.ui

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.pool.instamovie.R
import com.example.pool.instamovie.models.INavigationCallbacks
import com.example.pool.instamovie.models.MovieItem

class MainActivity : AppCompatActivity(), INavigationCallbacks
{
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, MovieListFragment.newInstance(), "TAG1")
                .commit()
    }

    override fun onMovieItemClicked(movieItem:MovieItem) {
        supportFragmentManager
                .beginTransaction()
                .addToBackStack("")
                .replace(R.id.container, MovieDetailFragment.newInstance(movieItem), "TAG2")
                .commit()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
    }
}
