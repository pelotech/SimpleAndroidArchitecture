package com.liffft.simpleandroidarchitecture.presentationmodel;

import com.liffft.simpleandroidarchitecture.model.Repo;

import org.robobinding.itempresentationmodel.ItemContext;
import org.robobinding.itempresentationmodel.ItemPresentationModel;

/**
 * Created by jhill on 11/19/14.
 */
public class RepoItemPresentationModel implements ItemPresentationModel<Repo> {

    protected Repo repo;

    public String getTitle() {
        return repo.description;
    }

    @Override
    public void updateData(Repo repo, ItemContext itemContext) {
        this.repo = repo;
    }
}
