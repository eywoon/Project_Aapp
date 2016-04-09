package is.hi.project_aapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import is.hi.project_aapp.Emotions.Emotions;
//import is.hi.project_aapp.GoalsActivity.GoalsActivity;
//import is.hi.project_aapp.Help.Help;
//import is.hi.project_aapp.MeActivity.MeActivity;
//import is.hi.project_aapp.Results.Results;
//import is.hi.project_aapp.Settings.Settings;
import is.hi.project_aapp.Goals.GoalsActivity;
import is.hi.project_aapp.Help.Help;
import is.hi.project_aapp.Me.MeActivity;
import is.hi.project_aapp.Results.Results;
import is.hi.project_aapp.Settings.Settings;
import is.hi.project_aapp.Steps.StepsActivity;
import is.hi.project_aapp.TaskManager.TaskActivity;

import is.hi.project_aapp.Sponsor.SponsorActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void on12stepsClick (View view){
        Intent intent = new Intent(this, StepsActivity.class);
        startActivity(intent);
    }



    public void onResultsClick(View view){
        Intent intent = new Intent(this, Results.class);
        startActivity(intent);
    }

    public void onSponsorClick(View view){
        Intent intent = new Intent(this, SponsorActivity.class);
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
        Intent intent = new Intent(this, GoalsActivity.class);
        startActivity(intent);
    }

    public void onEmotionsClick(View view){
        Intent intent = new Intent(this, Emotions.class);
        startActivity(intent);
    }

    public void onMeClick(View view){
        Intent intent = new Intent(this, MeActivity.class);
        startActivity(intent);

    }

}


