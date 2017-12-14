package br.com.tramalho.githubmvvm.di.module;

import javax.inject.Singleton;

import br.com.tramalho.githubmvvm.data.repository.GithubReposRepository;
import br.com.tramalho.githubmvvm.interactor.repos.RepoUseCase;
import dagger.Module;
import dagger.Provides;

/**
 * Created by trama on 13/12/17.
 */
@Module
public class RepoUseCaseModule {

    @Provides
    @Singleton
    public RepoUseCase create(GithubReposRepository githubReposRepository) {
        return new RepoUseCase(githubReposRepository);
    }
}
