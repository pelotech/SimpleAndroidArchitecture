package com.liffft.simpleandroidarchitecture.service;

import com.liffft.simpleandroidarchitecture.model.Commit;
import com.liffft.simpleandroidarchitecture.model.CommitDetails;
import com.liffft.simpleandroidarchitecture.model.Repo;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by jhill on 11/19/14.
 */
public interface Service {
    @GET("/users/josmo/repos?")
    Observable<List<Repo>> getRepoList();

    @GET("/repos/{owner}/{repo}/commits")
    Observable<List<CommitDetails>> getContributors(@Path("owner") String owner, @Path("repo") String repo);
}
