package com.liffft.simpleandroidarchitecture.service;

import com.google.inject.Singleton;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jhill on 11/24/14.
 */
@Singleton
public class ProjectSchedulers {
    public Scheduler getUIScheduler() {
        return AndroidSchedulers.mainThread();
    }
    public Scheduler getNewThreadScheduler() {
        return Schedulers.newThread();
    }

}
