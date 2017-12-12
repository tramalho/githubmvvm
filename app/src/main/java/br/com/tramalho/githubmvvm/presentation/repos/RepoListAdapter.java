package br.com.tramalho.githubmvvm.presentation.repos;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.tramalho.githubmvvm.R;
import br.com.tramalho.githubmvvm.data.model.RepoModel;
import br.com.tramalho.githubmvvm.databinding.ItemRepoBinding;

/**
 * Created by trama on 11/12/17.
 */

public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.RepoViewHolder> {

    private List<RepoModel> itens;

    public RepoListAdapter(List<RepoModel> itens) {
        this.itens = itens;
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        ItemRepoBinding itemRepoBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_repo, parent, false);

        return new RepoViewHolder(itemRepoBinding);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        RepoModel item = this.itens.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    class RepoViewHolder extends RecyclerView.ViewHolder {

        private final ItemRepoBinding binding;

        public RepoViewHolder(ItemRepoBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }

        public void bind(RepoModel repoModel) {

            RepoViewModel repoViewModel = new RepoViewModel();

            binding.setRepoViewModel(repoViewModel);
            binding.executePendingBindings();

            repoViewModel.updateData(repoModel);
        }
    }
}