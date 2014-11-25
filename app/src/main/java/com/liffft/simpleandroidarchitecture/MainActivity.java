package com.liffft.simpleandroidarchitecture;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.inject.Inject;
import com.liffft.simpleandroidarchitecture.presentationmodel.RepoListPresentationModel;


import org.robobinding.binder.Binders;


import roboguice.activity.RoboActivity;



public class MainActivity extends RoboActivity {

    @Inject
    RepoListPresentationModel repoListPresentationModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View bindedView = Binders.inflateAndBind(this, R.layout.activity_main, repoListPresentationModel);

        //Callback example
        //questionListPresentationModel.loadData();

        //Observable example - becomes easier to test :)
        repoListPresentationModel.subscribeTo();
        setContentView(bindedView);
    }

    @Override
    protected void onDestroy() {
        repoListPresentationModel.unSubscribeTo();
        super.onDestroy();
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
}
