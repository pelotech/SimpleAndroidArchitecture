package com.liffft.simpleandroidarchitecture.activity;

import android.os.Bundle;
import android.view.View;

import com.google.inject.Inject;
import com.liffft.simpleandroidarchitecture.R;
import com.liffft.simpleandroidarchitecture.presentationmodel.CommitListPresentationModel;

import org.robobinding.binder.Binders;

import roboguice.activity.RoboActivity;

/**
 * Created by jhill on 11/19/14.
 */
public class AnswersListActivity extends RoboActivity {

    @Inject
    CommitListPresentationModel commitListPresentationModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Snag the repo name from the URL :)
        Bundle intentExtras = getIntent().getExtras();
        String repoName = intentExtras.getString("repo_name");

        //Snag the owner name from the URL :)
        String owner = intentExtras.getString("owner");

        commitListPresentationModel.subscribeTo(repoName, owner);

        View bindedView = Binders.inflateAndBind(this, R.layout.commit_list, commitListPresentationModel);
        setContentView(bindedView);
    }

    protected void onDestroy() {
        commitListPresentationModel.unSubscribeTo();
        super.onDestroy();
    }
}