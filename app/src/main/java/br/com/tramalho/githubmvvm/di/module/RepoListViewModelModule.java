package br.com.tramalho.githubmvvm.di.module;

import br.com.tramalho.githubmvvm.interactor.repos.RepoUseCase;
import br.com.tramalho.githubmvvm.presentation.repos.RepoListViewModel;
import dagger.Module;
import dagger.Provides;

/**
 * Created by trama on 13/12/17.
 */
@Module
public class RepoListViewModelModule {

    @Provides
    public RepoListViewModel create(RepoUseCase useCase) {
        return new RepoListViewModel(useCase);
    }
}
