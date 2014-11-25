package com.liffft.simpleandroidarchitecture.presentationmodel;

import android.util.Log;

import com.google.inject.Inject;
import com.liffft.simpleandroidarchitecture.model.Commit;
import com.liffft.simpleandroidarchitecture.model.Repo;
import com.liffft.simpleandroidarchitecture.routing.ProjectRouter;
import com.liffft.simpleandroidarchitecture.service.ProjectSchedulers;
import com.liffft.simpleandroidarchitecture.service.ProjectService;

import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.annotation.PresentationModel;
import org.robobinding.widget.adapterview.ItemClickEvent;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jhill on 11/19/14.
 */
@PresentationModel
public class RepoListPresentationModel {

    private List<Repo> repoList;
    private ProjectRouter projectRouter;
    private ProjectService projectService;
    private Subscriber repoListSubscriber;
    @Inject
    ProjectSchedulers projectSchedulers;



    @Inject
    public RepoListPresentationModel(ProjectService projectService, ProjectRouter projectRouter) {
        this.projectService = projectService;
        this.projectRouter = projectRouter;
    }

    public void setRepoList(List<Repo> repoList) {
        this.repoList = repoList;
    }
    @ItemPresentationModel(RepoItemPresentationModel.class)
    public List<Repo> getRepoList() {
        return repoList;
    }

    public void selectRepo(ItemClickEvent event) {
        Repo repo = repoList.get(event.getPosition());
        projectRouter.sharedRouter().open("repos/josmo/" + repo.name + "/commits");
    }

    public void subscribeTo() {
        //Sample version there's a cleaner version
        repoListSubscriber = new Subscriber() {
            @Override
            public void onCompleted() {
                //Doesn't need to do anything on Complete
            }

            @Override
            public void onError(Throwable e) {
                //TODO: Should have an error message
            }

            @Override
            public void onNext(Object o) {
                setRepoList((List<Repo>)o);
            }
        };

        //Make sure to return on the UI thread :)
        projectService.getService().getRepoList().subscribeOn(projectSchedulers.getNewThreadScheduler())
                .observeOn(projectSchedulers.getUIScheduler()).subscribe(repoListSubscriber);

    }
    public void unSubscribeTo() {
        repoListSubscriber.unsubscribe();
    }
}