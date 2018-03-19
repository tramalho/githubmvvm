package br.com.tramalho.githubmvvm.infraestructure;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.tramalho.githubmvvm.data.model.GIthubRepoResponse;
import br.com.tramalho.githubmvvm.data.model.PullModel;
import br.com.tramalho.githubmvvm.data.model.RepoOwner;
import io.reactivex.Observable;

/**
 * Created by trama on 19/03/18.
 */

public class MockServiceAPI implements ServiceApi {
    @Override
    public Observable<GIthubRepoResponse> getReposByFilter(String language, String sort, long page) {

        try {
            GIthubRepoResponse response = (GIthubRepoResponse) openFrom(GIthubRepoResponse.class, "assets/repos/two_results.json");
            return Observable.just(response);
        } catch (Exception e) {
            return Observable.error(new Exception("error"));
        }
    }

    private Object openFrom(Class<?> clazz, String pathAndFile) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(pathAndFile);
        return new Gson().fromJson(new InputStreamReader(resourceAsStream), clazz);
    }

    @Override
    public Observable<RepoOwner> getRepoOwner(String login) {
        return Observable.just(new RepoOwner());
    }

    @Override
    public Observable<List<PullModel>> getPullRequests(String creator, String repo) {
        List<PullModel> result = new ArrayList<>();
        return Observable.just(result);
    }
}
