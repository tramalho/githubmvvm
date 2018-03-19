package br.com.tramalho.githubmvvm.di;

import br.com.tramalho.githubmvvm.di.component.DaggerRepoDetailsViewModelComponent;
import br.com.tramalho.githubmvvm.di.component.DaggerRepoListViewModelComponent;
import br.com.tramalho.githubmvvm.di.component.RepoDetailsViewModelComponent;
import br.com.tramalho.githubmvvm.di.component.RepoListViewModelComponent;
import br.com.tramalho.githubmvvm.di.module.RemoteProviderModule;
import br.com.tramalho.githubmvvm.presentation.repos.RepoListActivity;
import br.com.tramalho.githubmvvm.presentation.repos.detail.PullDetailActivity;

/**
 * Created by trama on 18/03/18.
 */

public class ComponentBuilder {

    public void inject(RepoListActivity repoListActivity) {
        RepoListViewModelComponent component =
                DaggerRepoListViewModelComponent
                        .builder()
                        .remoteProviderModule(getRemoteProviderModule())
                        .build();

        component.inject(repoListActivity);
    }

    public void inject(PullDetailActivity pullDetailActivity) {
        RepoDetailsViewModelComponent component =
                DaggerRepoDetailsViewModelComponent
                        .builder()
                        .remoteProviderModule(getRemoteProviderModule())
                        .build();

        component.inject(pullDetailActivity);
    }

    protected RemoteProviderModule getRemoteProviderModule() {
        return new RemoteProviderModule();
    }
}
