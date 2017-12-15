package br.com.tramalho.githubmvvm.data.repository;

import javax.inject.Inject;

import br.com.tramalho.githubmvvm.data.model.GIthubRepoResponse;
import br.com.tramalho.githubmvvm.data.model.RepoFilter;
import br.com.tramalho.githubmvvm.data.model.RepoOwner;
import br.com.tramalho.githubmvvm.infraestructure.RemoteProvider;
import br.com.tramalho.githubmvvm.infraestructure.ServiceApi;
import io.reactivex.Observable;

/**
 * Created by trama on 12/12/17.
 */

public class GithubReposRepository {

    public static String LANGUAGE_FILTER = "language:%s";

    private RemoteProvider remoteProvider;

    @Inject
    public GithubReposRepository(RemoteProvider remoteProvider) {
        this.remoteProvider = remoteProvider;
    }

    public Observable<GIthubRepoResponse> listByFilter(RepoFilter filter) {

        ServiceApi serviceApi = remoteProvider.create();

        String formattedLanguage = String.format(LANGUAGE_FILTER, filter.getLanguage());

        return serviceApi.getReposByFilter(
                formattedLanguage,
                filter.getSort(),
                filter.getPageNumber());
    }

    public Observable<RepoOwner> ownerByRepo(String login) {

        ServiceApi serviceApi = remoteProvider.create();

        return serviceApi.getRepoOwner(login);
    }
}
