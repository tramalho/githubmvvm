package br.com.tramalho.githubmvvm.presentation.repos;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import br.com.tramalho.githubmvvm.BR;
import br.com.tramalho.githubmvvm.data.model.RepoFilter;
import br.com.tramalho.githubmvvm.data.model.RepoModel;
import br.com.tramalho.githubmvvm.interactor.repos.RepoUseCase;
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

    private int progressVisible = View.VISIBLE;
    private int rvVisible = View.GONE;

    private RepoFilter repoFilter;

    @Inject
    public RepoListViewModel(RepoUseCase repoUseCase) {
        this.repoUseCase = repoUseCase;
    }

    public void setView(ContractView view) {
        this.view = view;
    }

    @Bindable
    public int getProgressVisible() {
        return progressVisible;
    }

    @Bindable
    public int getRvVisible() {
        return rvVisible;
    }

    public void start(String language, String sort) {
        repoFilter = new RepoFilter(language, sort, 0);
        next();
    }

    public void next() {
        this.repoFilter.setPageNumber(1 + this.repoFilter.getPageNumber());
        repoUseCase.execute(this.repoFilter, getRepoSubscriber());
    }

    private RepoSubscriber getRepoSubscriber() {
        return new RepoSubscriber();
    }

    private void showStatus(boolean isSuccess) {
        this.progressVisible = GONE;
        this.rvVisible = isSuccess ? VISIBLE : GONE;
        notifyPropertyChanged(BR.progressVisible);
    }

    public interface ContractView {
        void listResult(List<RepoModel> list);

        void onError(Throwable e);
    }

    private class RepoSubscriber implements SingleObserver<List<RepoModel>> {

        private String TAG = RepoSubscriber.class.getSimpleName();

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onSuccess(List<RepoModel> repoModels) {
            showStatus(true);
            view.listResult(repoModels);
            Log.d(TAG, "onSuccess " + repoModels.toString());
        }

        @Override
        public void onError(Throwable e) {
            showStatus(false);
            view.onError(e);
            Log.e(TAG, "onError", e);
        }
    }
}
