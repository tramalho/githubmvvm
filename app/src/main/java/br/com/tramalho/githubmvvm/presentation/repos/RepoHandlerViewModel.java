package br.com.tramalho.githubmvvm.presentation.repos;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import br.com.tramalho.githubmvvm.data.model.RepoModel;

/**
 * Created by trama on 11/12/17.
 */

public class RepoHandlerViewModel extends BaseObservable {

    public final ObservableField<String> fullName = new ObservableField<>();
    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableField<String> forksCount = new ObservableField<>();

    private RepoModel repoModel;

    public void updateData(RepoModel repoModel) {

        this.repoModel = repoModel;

        fullName.set(this.repoModel.getFullName());
        description.set(this.repoModel.getDescription());
        forksCount.set(String.valueOf(this.repoModel.getForksCount()));

        notifyChange();
    }
}
