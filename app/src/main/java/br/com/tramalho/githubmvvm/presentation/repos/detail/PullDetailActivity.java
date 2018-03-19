package br.com.tramalho.githubmvvm.presentation.repos.detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import br.com.tramalho.githubmvvm.CustomApplicationImpl;
import br.com.tramalho.githubmvvm.R;
import br.com.tramalho.githubmvvm.data.model.PullModel;
import br.com.tramalho.githubmvvm.data.model.RepoModel;
import br.com.tramalho.githubmvvm.databinding.ActivityPullDetailBinding;

public class PullDetailActivity extends AppCompatActivity {

    private static final String PULL_EXTRA = "PULL_EXTRA";

    @Inject
    protected PullDetailsViewModel viewModel;

    private ActivityPullDetailBinding binding;
    private RepoModel repoModel;

    public static void getLanchingActivity(Context context, RepoModel repoModel) {
        Intent intent = new Intent(context, PullDetailActivity.class);
        Bundle extra = new Bundle();
        extra.putParcelable(PullDetailActivity.PULL_EXTRA, repoModel);
        intent.putExtras(extra);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_pull_detail);
        extractData(savedInstanceState);
        inject();
        setupViews();
        binding();
        start();
    }

    private void start() {
        this.viewModel.start(this.repoModel);
    }

    private void extractData(Bundle savedInstanceState) {
        Intent intent = getIntent();

        if (intent != null && intent.getExtras() != null) {
            Bundle extras = intent.getExtras();
            this.repoModel = extras.getParcelable(PULL_EXTRA);
        }

        if (savedInstanceState != null && savedInstanceState.getParcelable(PULL_EXTRA) != null) {
            this.repoModel = savedInstanceState.getParcelable(PULL_EXTRA);
        }
    }

    private void binding() {
        this.binding.setViewModel(viewModel);
        this.binding.executePendingBindings();
    }

    private void inject() {
        CustomApplicationImpl application = (CustomApplicationImpl) getApplication();
        application.builder().inject(this);
    }

    private void setupViews() {

        RecyclerView pullListRvId = this.binding.pullListRvId;

        pullListRvId.setLayoutManager(new LinearLayoutManager(this));

        pullListRvId.setAdapter(new PullListAdapter(new ObservableArrayList<PullModel>()));

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setTitle(this.repoModel.getName());
        }
    }
}
