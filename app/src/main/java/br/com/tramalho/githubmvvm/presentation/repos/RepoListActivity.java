package br.com.tramalho.githubmvvm.presentation.repos;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import javax.inject.Inject;

import br.com.tramalho.githubmvvm.R;
import br.com.tramalho.githubmvvm.data.model.RepoModel;
import br.com.tramalho.githubmvvm.databinding.ActivityRepoListBinding;
import br.com.tramalho.githubmvvm.di.component.DaggerRepoListViewModelComponent;
import br.com.tramalho.githubmvvm.di.component.RepoListViewModelComponent;
import br.com.tramalho.githubmvvm.di.module.RepoListViewModelModule;

public class RepoListActivity extends AppCompatActivity implements RepoListViewModel.ContractView {

    @Inject
    protected RepoListViewModel repoListViewmodel;
    private ActivityRepoListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_repo_list);
        inject();
        setupRecyclerview();
        bindingData();
        startData();
    }

    private void bindingData() {
        this.binding.setViewModel(repoListViewmodel);
        this.repoListViewmodel.setView(this);
        this.binding.executePendingBindings();
    }

    private void startData() {
        this.repoListViewmodel.start("java", "stars");
    }

    private void inject() {
        RepoListViewModelComponent component =
                DaggerRepoListViewModelComponent
                        .builder()
                        .repoListViewModelModule(new RepoListViewModelModule())
                        .build();

        component.inject(this);
    }

    private void setupRecyclerview() {
        this.binding.repoListRvId.setLayoutManager(new LinearLayoutManager(this));
        this.binding.repoListRvId.setAdapter(new RepoListAdapter(new ObservableArrayList<RepoModel>()));
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
