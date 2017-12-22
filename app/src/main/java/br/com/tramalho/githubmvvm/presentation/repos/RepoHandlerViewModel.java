package br.com.tramalho.githubmvvm.presentation.repos;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import br.com.tramalho.githubmvvm.data.model.RepoModel;
import br.com.tramalho.githubmvvm.data.model.RepoOwner;

/**
 * Created by trama on 11/12/17.
 */

public class RepoHandlerViewModel extends BaseObservable {

    public final ObservableField<String> repoFullName = new ObservableField<>();
    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableField<String> forksCount = new ObservableField<>();
    public final ObservableField<String> stargazersCount = new ObservableField<>();
    public final ObservableField<String> ownerLogin = new ObservableField<>();
    public final ObservableField<String> ownerName = new ObservableField<>();
    public final ObservableField<String> avatarRepo = new ObservableField<>();


    private RepoModel repoModel;

    public void updateData(RepoModel repoModel) {

        this.repoModel = repoModel;

        RepoOwner owner = this.repoModel.getOwner();

        repoFullName.set(this.repoModel.getFullName());
        description.set(this.repoModel.getDescription());
        forksCount.set(String.valueOf(this.repoModel.getForksCount()));
        stargazersCount.set(String.valueOf(this.repoModel.getStargazersCount()));
        ownerLogin.set(owner.getLogin());
        ownerName.set(owner.getName());
        avatarRepo.set(this.repoModel.getAvatarUrl());

        notifyChange();
    }
}
