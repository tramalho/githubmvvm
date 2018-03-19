package br.com.tramalho.githubmvvm.presentation.repos;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import br.com.tramalho.githubmvvm.CustomApplication;
import br.com.tramalho.githubmvvm.R;
import br.com.tramalho.githubmvvm.data.model.RepoModel;
import br.com.tramalho.githubmvvm.databinding.ActivityRepoListBinding;

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
        binding();
        startData();
    }

    private void binding() {
        this.binding.setViewModel(repoListViewmodel);
        this.repoListViewmodel.setView(this);
        this.binding.executePendingBindings();
    }

    private void startData() {
        this.repoListViewmodel.start("java", "stars");
    }

    private void inject() {

        CustomApplication application = (CustomApplication) getApplication();
        application.builder().inject(this);
    }

    private void setupRecyclerview() {

        RecyclerView repoListRvId = this.binding.repoListRvId;

        repoListRvId.setLayoutManager(new LinearLayoutManager(this));

        repoListRvId.setAdapter(new RepoListAdapter(new ArrayList<RepoModel>()));

        repoListRvId.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                repoListViewmodel.next();
            }
        });
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
