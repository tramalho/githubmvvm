package br.com.tramalho.githubmvvm.infraestructure;

import br.com.tramalho.githubmvvm.data.model.GIthubRepoResponse;
import br.com.tramalho.githubmvvm.data.model.RepoOwner;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by trama on 12/12/17.
 */

public interface ServiceApi {

    @GET("search/repositories")
    Observable<GIthubRepoResponse> getReposByFilter(@Query("q") String language,
                                                    @Query("sort") String sort,
                                                    @Query("page") long page);

    @GET("users/{login}")
    Observable<RepoOwner> getRepoOwner(@Path("login") String login);
}
