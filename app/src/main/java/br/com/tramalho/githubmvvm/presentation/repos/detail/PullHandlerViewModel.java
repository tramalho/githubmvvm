package br.com.tramalho.githubmvvm.presentation.repos.detail;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import br.com.tramalho.githubmvvm.data.model.PullModel;
import br.com.tramalho.githubmvvm.data.model.PullUser;

/**
 * Created by trama on 11/12/17.
 */

public class PullHandlerViewModel extends BaseObservable {

    public final ObservableField<String> pullName = new ObservableField<>();
    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableField<String> ownerLoginPull = new ObservableField<>();
    public final ObservableField<String> createdAt = new ObservableField<>();
    public final ObservableField<String> avatarOwnerPull = new ObservableField<>();


    public void updateData(PullModel model) {

        PullUser user = model.getUser();

        pullName.set(model.getTitle());
        description.set(model.getBody());
        createdAt.set(model.getCreatedAt());
        ownerLoginPull.set(user.getLogin());
        avatarOwnerPull.set(user.getAvatarUrl());

        notifyChange();
    }

}
