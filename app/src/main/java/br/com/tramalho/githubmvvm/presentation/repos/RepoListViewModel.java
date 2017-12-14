package br.com.tramalho.githubmvvm.presentation.repos;

import android.databinding.BaseObservable;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import br.com.tramalho.githubmvvm.data.model.GIthubRepoResponse;
import br.com.tramalho.githubmvvm.data.model.RepoFilter;
import br.com.tramalho.githubmvvm.data.model.RepoModel;
import br.com.tramalho.githubmvvm.interactor.repos.RepoUseCase;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by trama on 12/12/17.
 */

public class RepoListViewModel extends BaseObservable {

    private RepoUseCase repoUseCase;
    private RepoListViewModel.ContractView view;

    @Inject
    public RepoListViewModel(RepoUseCase repoUseCase) {
        this.repoUseCase = repoUseCase;
    }

    public void setView(ContractView view) {
        this.view = view;
    }

    public void fetchListByFilter(String language, String sort, long page) {
        repoUseCase.execute(new RepoFilter(language, sort, page), getRepoSubscriber());
    }

    private DisposableObserver<GIthubRepoResponse> getRepoSubscriber() {
        return new RepoSubscriber();
    }

    public interface ContractView {
        void listResult(List<RepoModel> list);

        void onError(Throwable e);
    }

    private class RepoSubscriber extends DisposableObserver<GIthubRepoResponse> {

        private String TAG = RepoSubscriber.class.getSimpleName();

        @Override
        public void onNext(GIthubRepoResponse githubRepoResponse) {
            view.listResult(githubRepoResponse.getItens());
            Log.d(TAG, "onNext " + githubRepoResponse.toString());
        }

        @Override
        public void onError(Throwable e) {
            view.onError(e);
            Log.e(TAG, "onError", e);
        }

        @Override
        public void onComplete() {
            Log.d(TAG, "onComplete");
        }
    }
}
