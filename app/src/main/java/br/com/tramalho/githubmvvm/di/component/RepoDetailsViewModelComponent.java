package br.com.tramalho.githubmvvm.di.component;

import javax.inject.Singleton;

import br.com.tramalho.githubmvvm.di.module.RemoteProviderModule;
import br.com.tramalho.githubmvvm.di.module.RepoDetailsViewModelModule;
import br.com.tramalho.githubmvvm.di.module.RepoUseCaseModule;
import br.com.tramalho.githubmvvm.presentation.repos.detail.PullDetailActivity;
import dagger.Component;

/**
 * Created by trama on 13/12/17.
 */
@Singleton
@Component(modules = {
        RepoDetailsViewModelModule.class,
        RemoteProviderModule.class,
        RepoUseCaseModule.class})
public interface RepoDetailsViewModelComponent {
    void inject(PullDetailActivity activity);
}
