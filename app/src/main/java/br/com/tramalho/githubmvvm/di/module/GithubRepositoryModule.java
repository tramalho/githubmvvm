package br.com.tramalho.githubmvvm.di.module;

import javax.inject.Singleton;

import br.com.tramalho.githubmvvm.data.repository.GithubReposRepository;
import br.com.tramalho.githubmvvm.infraestructure.RemoteProvider;
import dagger.Module;
import dagger.Provides;

/**
 * Created by trama on 13/12/17.
 */
@Module
public class GithubRepositoryModule {

    @Provides
    @Singleton
    public GithubReposRepository create(RemoteProvider remoteProvider) {
        return new GithubReposRepository(remoteProvider);
    }
}
