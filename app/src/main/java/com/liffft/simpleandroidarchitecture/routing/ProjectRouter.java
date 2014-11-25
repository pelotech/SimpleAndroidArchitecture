package com.liffft.simpleandroidarchitecture.routing;

import android.app.Application;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.liffft.simpleandroidarchitecture.activity.AnswersListActivity;
import com.liffft.simpleandroidarchitecture.MainActivity;

/**
 * Created by jhill on 11/19/14.
 */
@Singleton
public class ProjectRouter extends Router {


    @Inject
    public ProjectRouter(Application application) {
        // Set the global context
        Router.sharedRouter().setContext(application);
        // Symbol-esque params are passed as intent extras to the activities
        Router.sharedRouter().map("repos/:owner/:repo_name/commits", AnswersListActivity.class);
        Router.sharedRouter().map("repos", MainActivity.class);

    }
}