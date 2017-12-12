package br.com.tramalho.githubmvvm.presentation.repos;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.Collections;

import br.com.tramalho.githubmvvm.R;
import br.com.tramalho.githubmvvm.data.model.RepoModel;
import br.com.tramalho.githubmvvm.databinding.ActivityRepoListBinding;

public class RepoListActivity extends AppCompatActivity {

    private ActivityRepoListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_repo_list);

        this.binding.repoListRvId.setLayoutManager(new LinearLayoutManager(this));

        RepoModel repoModel = new RepoModel();

        this.binding.repoListRvId.setAdapter(new RepoListAdapter(Collections.singletonList(repoModel)));
    }
}