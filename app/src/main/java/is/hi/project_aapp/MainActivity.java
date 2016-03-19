package is.hi.project_aapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


import is.hi.project_aapp.TaskManager.TaskActivity;

import is.hi.project_aapp.TaskManager.TaskKeeper;
import is.hi.project_aapp.Sponsor.SponsorActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onButton(View view) {
        Intent intent = new Intent(this, TaskActivity.class);
        startActivity(intent);
    }

        /*

        OMGOMGMGOGMGOMGOGMGOMG
        moooothafokkkkkker

         */




    }

    public void onButton(View view){
        Intent intent = new Intent(this, SponsorActivity.class);
        startActivity(intent);
    }

