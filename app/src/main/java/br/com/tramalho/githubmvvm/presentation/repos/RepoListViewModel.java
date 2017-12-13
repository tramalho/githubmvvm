package br.com.tramalho.githubmvvm.presentation.repos;

import android.databinding.BaseObservable;
import android.util.Log;

import java.util.List;

import br.com.tramalho.githubmvvm.data.model.GIthubRepoResponse;
import br.com.tramalho.githubmvvm.data.model.RepoFilter;
import br.com.tramalho.githubmvvm.data.model.RepoModel;
import br.com.tramalho.githubmvvm.interactor.repos.RepoUseCase;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by trama on 12/12/17.
 */

public class RepoListViewModel extends BaseObservable {

    private RepoUseCase repoUseCase = new RepoUseCase();
    private RepoListViewModel.ContractView view;

    public RepoListViewModel(ContractView view) {
        this.view = view;
    }

    public void fetchListByFIlter(String language, String sort, long page) {
        repoUseCase.execute(new RepoFilter(language, sort, page), getRepoSubscriber());
    }

    private DisposableObserver<GIthubRepoResponse> getRepoSubscriber() {
        return new RepoSubscriber();
    }

    public interface ContractView {
        void listResult(List<RepoModel> list);
    }

    private class RepoSubscriber extends DisposableObserver<GIthubRepoResponse> {

        @Override
        public void onNext(GIthubRepoResponse githubRepoResponse) {
            view.listResult(githubRepoResponse.getItens());
            Log.d("Request", "onNext " + githubRepoResponse.toString());
        }

        @Override
        public void onError(Throwable e) {
            Log.e("Request", "onError", e);
        }

        @Override
        public void onComplete() {
            Log.d("Request", "onComplete");
        }
    }
}
