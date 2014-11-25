package com.liffft.simpleandroidarchitecture.presentationmodel;

import com.google.inject.Inject;
import com.liffft.simpleandroidarchitecture.model.CommitDetails;
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
public class CommitListPresentationModel {

    protected List<CommitDetails> commitList;
    Subscriber contributorListSubscriber;

    ProjectService projectService;

    @Inject
    public CommitListPresentationModel(ProjectService projectService) {
        this.projectService = projectService;
    }

    @ItemPresentationModel(CommitItemPresentationModel.class)
    public List<CommitDetails> getCommitList() {
        return this.commitList;
    }

    public void setCommitList(List<CommitDetails> commitList) {
        this.commitList = commitList;
    }

    public void selectCommit(ItemClickEvent event) {

    }

    public void subscribeTo(String repoID, String owner) {
        //Sample version there's a cleaner version
        contributorListSubscriber = new Subscriber() {
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
                setCommitList((List<CommitDetails>) o);
            }
        };

        projectService.getService().getContributors(owner,repoID).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(contributorListSubscriber);
    }
    public void unSubscribeTo() {
        contributorListSubscriber.unsubscribe();
    }


}
