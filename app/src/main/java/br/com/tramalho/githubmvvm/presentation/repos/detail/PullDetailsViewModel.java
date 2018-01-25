package br.com.tramalho.githubmvvm.presentation.repos.detail;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.util.Log;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import br.com.tramalho.githubmvvm.BR;
import br.com.tramalho.githubmvvm.data.model.PullModel;
import br.com.tramalho.githubmvvm.data.model.RepoModel;
import br.com.tramalho.githubmvvm.interactor.repos.RepoUseCase;
import br.com.tramalho.githubmvvm.presentation.Status;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by trama on 23/12/17.
 */
public class PullDetailsViewModel extends BaseObservable {

    private int progressVisibility = View.VISIBLE;
    private int rvVisibility = View.GONE;
    private int emptyStateVisibility = View.GONE;

    private ObservableArrayList<PullModel> list = new ObservableArrayList<>();

    private RepoUseCase useCase;

    @Inject
    public PullDetailsViewModel(RepoUseCase useCase) {
        this.useCase = useCase;
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
        return emptyStateVisibility;
    }

    @Bindable
    public ObservableArrayList<PullModel> getList() {
        return list;
    }

    void start(RepoModel repoModel) {
        useCase.retrivePullRequests(repoModel, new RepoSubscriber());
    }

    private void showStatus(Status status) {

        this.progressVisibility = GONE;

        this.rvVisibility = Status.SUCCESS.equals(status) ? VISIBLE : GONE;
        this.emptyStateVisibility = Status.EMPTY.equals(status) ? VISIBLE : GONE;

        notifyPropertyChanged(BR.progressVisibility);
        notifyPropertyChanged(BR.rvVisibility);
        notifyPropertyChanged(BR.emptyStateVisibility);
    }

    private class RepoSubscriber implements Observer<List<PullModel>> {

        private String TAG = RepoSubscriber.class.getSimpleName();

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(List<PullModel> pullModels) {
            Log.d(TAG, "onNext");
            list.addAll(pullModels);
            showStatus(pullModels.isEmpty() ? Status.EMPTY : Status.SUCCESS);
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, "onError", e);
            showStatus(Status.ERROR);
        }

        @Override
        public void onComplete() {

        }
    }
}
