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
import android.widget.Button;


import javax.xml.transform.Result;

import is.hi.project_aapp.Emotions.Emotions;
//import is.hi.project_aapp.Goals.Goals;
//import is.hi.project_aapp.Help.Help;
//import is.hi.project_aapp.Me.Me;
//import is.hi.project_aapp.Results.Results;
//import is.hi.project_aapp.Settings.Settings;
import is.hi.project_aapp.Goals.Goals;
import is.hi.project_aapp.Help.Help;
import is.hi.project_aapp.Me.Me;
import is.hi.project_aapp.Results.Results;
import is.hi.project_aapp.Settings.Settings;
import is.hi.project_aapp.Steps.Steps;
import is.hi.project_aapp.TaskManager.TaskActivity;

import is.hi.project_aapp.TaskManager.TaskKeeper;
import is.hi.project_aapp.Sponsor.SponsorActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void on12stepsClick (View view){
        Intent intent = new Intent(this, Steps.class);
        startActivity(intent);
    }

    public void onSponsorClick(View view){
        Intent intent = new Intent(this, SponsorActivity.class);
        startActivity(intent);
    }

    public void onResultsClick(View view){
        Intent intent = new Intent(this, Results.class);
        startActivity(intent);
    }

    public void onSettingsClick(View view){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void onTasksClick(View view){
        Intent intent = new Intent(this, TaskActivity.class);
        startActivity(intent);
    }

    public void onHelpClick(View view){
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }

   public void onGoalsClick(View view){
        Intent intent = new Intent(this, Goals.class);
        startActivity(intent);
    }

    public void onEmotionsClick(View view){
        Intent intent = new Intent(this, Emotions.class);
        startActivity(intent);
    }

    public void onMeClick(View view){
        Intent intent = new Intent(this, Me.class);
        startActivity(intent);
    }
}


