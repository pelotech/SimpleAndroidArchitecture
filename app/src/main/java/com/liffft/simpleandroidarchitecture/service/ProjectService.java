package com.liffft.simpleandroidarchitecture.service;

import com.google.inject.Singleton;

import retrofit.RestAdapter;

/**
 * Created by jhill on 11/19/14.
 */
@Singleton
public class ProjectService {

    RestAdapter restAdapter;

    public ProjectService() {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.github.com/")
                .build();
    }

    public Service getService() {
        return restAdapter.create(Service.class);
    }
}