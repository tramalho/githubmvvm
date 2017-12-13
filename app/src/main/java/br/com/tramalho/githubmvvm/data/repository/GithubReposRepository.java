package br.com.tramalho.githubmvvm.data.repository;

import br.com.tramalho.githubmvvm.data.model.GIthubRepoResponse;
import br.com.tramalho.githubmvvm.data.model.RepoFilter;
import br.com.tramalho.githubmvvm.infraestructure.RemoteProvider;
import br.com.tramalho.githubmvvm.infraestructure.ServiceApi;
import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by trama on 12/12/17.
 */

public class GithubReposRepository {

    public static String LANGUAGE_FILTER = "language:%s";

    RemoteProvider remoteProvider = new RemoteProvider();

    public Observable<GIthubRepoResponse> listByFilter(RepoFilter filter) {
        Retrofit retrofit = remoteProvider.get();
        ServiceApi serviceApi = retrofit.create(ServiceApi.class);

        String formattedLanguage = String.format(LANGUAGE_FILTER, filter.getLanguage());

        Observable<GIthubRepoResponse> observable =
                serviceApi.getReposByFIlter(formattedLanguage, filter.getSort(), filter.getPageNumber());

        return observable;
    }
}
