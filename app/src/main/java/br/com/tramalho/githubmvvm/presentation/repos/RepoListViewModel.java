package br.com.tramalho.githubmvvm.presentation.repos;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.util.Log;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import br.com.tramalho.githubmvvm.BR;
import br.com.tramalho.githubmvvm.data.model.RepoFilter;
import br.com.tramalho.githubmvvm.data.model.RepoModel;
import br.com.tramalho.githubmvvm.interactor.repos.RepoUseCase;
import br.com.tramalho.githubmvvm.presentation.Status;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by trama on 12/12/17.
 */

public class RepoListViewModel extends BaseObservable {

    private RepoUseCase repoUseCase;
    private RepoListViewModel.ContractView view;

    private int progressVisibility = View.VISIBLE;
    private int rvVisibility = View.GONE;
    private int emptyStateVisibility = View.GONE;

    private RepoFilter repoFilter;
    private ObservableArrayList<RepoModel> list = new ObservableArrayList<>();
    private int loadMoreVisibility = View.GONE;

    @Inject
    public RepoListViewModel(RepoUseCase repoUseCase) {
        this.repoUseCase = repoUseCase;
    }

    public void setView(ContractView view) {
        this.view = view;
    }

    @Bindable
    public int getProgressVisibility() {
        return progressVisibility;
    }

    @Bindable
    public int getRvVisibility() {
        return rvVisibility;
    }

    @Bindable
    public int getEmptyStateVisibility() {
        return this.emptyStateVisibility;
    }

    @Bindable
    public int getLoadMoreVisibility() {
        return this.loadMoreVisibility;
    }

    @Bindable
    public ObservableArrayList<RepoModel> getList() {
        return list;
    }

    public void start(String language, String sort) {
        repoFilter = new RepoFilter(language, sort, 0);
        repoUseCase.retriveRepos(this.repoFilter, getRepoSubscriber());
    }

    public void next() {
        this.loadMoreVisibility = VISIBLE;
        notifyPropertyChanged(BR.loadMoreVisibility);
        this.repoFilter.setPageNumber(1 + this.repoFilter.getPageNumber());
        repoUseCase.retriveRepos(this.repoFilter, getRepoSubscriber());
    }

    private RepoSubscriber getRepoSubscriber() {
        return new RepoSubscriber();
    }

    private void showStatus(Status status) {

        this.progressVisibility = GONE;
        this.loadMoreVisibility = GONE;

        this.rvVisibility = Status.SUCCESS.equals(status) ? VISIBLE : GONE;
        this.emptyStateVisibility = Status.SUCCESS.equals(status) ? GONE : VISIBLE;

        notifyPropertyChanged(BR.progressVisibility);
        notifyPropertyChanged(BR.rvVisibility);
        notifyPropertyChanged(BR.emptyStateVisibility);
        notifyPropertyChanged(BR.loadMoreVisibility);
    }

    public interface ContractView {

        void onError(Throwable e);
    }

    private class RepoSubscriber implements SingleObserver<List<RepoModel>> {

        private String TAG = RepoSubscriber.class.getSimpleName();

        @Override
        public void onSubscribe(Disposable d) {
        }

        @Override
        public void onSuccess(List<RepoModel> repoModels) {
            list.addAll(repoModels);
            showStatus(Status.SUCCESS);
            Log.d(TAG, "onSuccess " + repoModels.toString());
        }

        @Override
        public void onError(Throwable e) {
            view.onError(e);
            showStatus(Status.ERROR);
            Log.e(TAG, "onError", e);
        }
    }
}
