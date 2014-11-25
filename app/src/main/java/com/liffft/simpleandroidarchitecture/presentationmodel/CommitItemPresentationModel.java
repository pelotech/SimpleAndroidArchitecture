package com.liffft.simpleandroidarchitecture.presentationmodel;

import com.liffft.simpleandroidarchitecture.model.CommitDetails;

import org.robobinding.itempresentationmodel.ItemContext;
import org.robobinding.itempresentationmodel.ItemPresentationModel;

/**
 * Created by jhill on 11/19/14.
 */
public class CommitItemPresentationModel implements ItemPresentationModel<CommitDetails> {

    protected CommitDetails commitDetails;

    public String getBody() {
        return this.commitDetails.commit.message;
    }

    @Override
    public void updateData(CommitDetails commitDetails, ItemContext itemContext) {
        this.commitDetails = commitDetails;
    }
}
