package br.com.tramalho.githubmvvm.di.component;

import javax.inject.Singleton;

import br.com.tramalho.githubmvvm.di.module.RemoteProviderModule;
import br.com.tramalho.githubmvvm.di.module.RepoListViewModelModule;
import br.com.tramalho.githubmvvm.di.module.RepoUseCaseModule;
import br.com.tramalho.githubmvvm.presentation.repos.RepoListActivity;
import dagger.Component;

/**
 * Created by trama on 13/12/17.
 */
@Singleton
@Component(modules = {
        RepoListViewModelModule.class,
        RemoteProviderModule.class,
        RepoUseCaseModule.class})
public interface RepoListViewModelComponent {
    void inject(RepoListActivity repoListActivity);
}
