package br.com.tramalho.githubmvvm.interactor.repos;

import javax.inject.Inject;

import br.com.tramalho.githubmvvm.data.model.GIthubRepoResponse;
import br.com.tramalho.githubmvvm.data.model.RepoFilter;
import br.com.tramalho.githubmvvm.data.repository.GithubReposRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by trama on 12/12/17.
 */

public class RepoUseCase {

    private GithubReposRepository githubReposRepository;

    @Inject
    public RepoUseCase(GithubReposRepository githubReposRepository) {
        this.githubReposRepository = githubReposRepository;
    }

    public void execute(RepoFilter repoFilter, DisposableObserver<GIthubRepoResponse> repoSubscriber) {
        githubReposRepository.listByFilter(repoFilter)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(repoSubscriber);
    }
}
