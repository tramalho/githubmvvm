package br.com.tramalho.githubmvvm.interactor.repos;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import br.com.tramalho.githubmvvm.data.model.GIthubRepoResponse;
import br.com.tramalho.githubmvvm.data.model.RepoFilter;
import br.com.tramalho.githubmvvm.data.model.RepoModel;
import br.com.tramalho.githubmvvm.data.model.RepoOwner;
import br.com.tramalho.githubmvvm.data.repository.GithubReposRepository;
import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
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

    public void execute(RepoFilter repoFilter, SingleObserver<List<RepoModel>> repoSubscriber) {
        Observable<GIthubRepoResponse> repoObservable = githubReposRepository.listByFilter(repoFilter);
        repoObservable
                //get list of repoModels
                .flatMap(getListReposFunc1())
                //iterate in list
                .flatMapIterable(getRepoItemFunc())
                // get owner in each repoModel and retrieve data from backend
                .flatMap(getOwnerRepo(), getBiFunction())
                //join all repoModel itens
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(repoSubscriber);
    }

    @NonNull
    private BiFunction<RepoModel, RepoOwner, RepoModel> getBiFunction() {
        return new BiFunction<RepoModel, RepoOwner, RepoModel>() {
            @Override
            public RepoModel apply(RepoModel repoModel, RepoOwner repoOwner) throws Exception {
                repoModel.setOwner(repoOwner);
                return repoModel;
            }
        };
    }

    @NonNull
    private Function<RepoModel, Observable<RepoOwner>> getOwnerRepo() {
        return new Function<RepoModel, Observable<RepoOwner>>() {
            @Override
            public Observable<RepoOwner> apply(RepoModel repoModel) throws Exception {
                RepoOwner owner = repoModel.getOwner();
                return githubReposRepository.ownerByRepo(owner.getLogin());
            }
        };
    }

    @NonNull
    private Function<List<RepoModel>, Iterable<RepoModel>> getRepoItemFunc() {
        return new Function<List<RepoModel>, Iterable<RepoModel>>() {

            @Override
            public Iterable<RepoModel> apply(List<RepoModel> repoModels) throws Exception {
                return repoModels;
            }
        };
    }

    @NonNull
    private Function<GIthubRepoResponse, Observable<List<RepoModel>>> getListReposFunc1() {
        return new Function<GIthubRepoResponse, Observable<List<RepoModel>>>() {

            @Override
            public Observable<List<RepoModel>> apply(GIthubRepoResponse gIthubRepoResponse) throws Exception {
                return Observable.just(gIthubRepoResponse.getItens());
            }
        };
    }


}
