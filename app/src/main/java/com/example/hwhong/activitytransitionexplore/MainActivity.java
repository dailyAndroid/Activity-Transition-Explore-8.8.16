package com.example.hwhong.activitytransitionexplore;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView google, facebook, uber, beme;
    private ViewGroup viewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewGroup = (ViewGroup) findViewById(R.id.containeLinearLayout);

        google = (ImageView) findViewById(R.id.google);
        facebook = (ImageView) findViewById(R.id.facebook);
        uber = (ImageView) findViewById(R.id.uber);
        beme = (ImageView) findViewById(R.id.beme);

        viewGroup.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        //explore transition object
        Explode explode = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            explode = new Explode();
            explode.setDuration(5000);

            TransitionManager.beginDelayedTransition(viewGroup, explode);
            //this defines a new scene as the four images are hid
            toggleVisbility(google, facebook, uber, beme);
        }
    }

    public void toggleVisbility(View... views) {
        for (View current : views) {
            if (current.getVisibility() == View.VISIBLE) {
                current.setVisibility(View.INVISIBLE);
            }
        }
    }
}
