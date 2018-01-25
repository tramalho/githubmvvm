package br.com.tramalho.githubmvvm.presentation.repos.detail;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collection;

import br.com.tramalho.githubmvvm.R;
import br.com.tramalho.githubmvvm.data.model.PullModel;
import br.com.tramalho.githubmvvm.databinding.ItemPullBinding;
import br.com.tramalho.githubmvvm.presentation.CustomAdapter;

/**
 * Created by trama on 11/12/17.
 */

public class PullListAdapter extends RecyclerView.Adapter<PullListAdapter.PullViewHolder> implements CustomAdapter {

    private ObservableArrayList<PullModel> itens;

    public PullListAdapter(ObservableArrayList<PullModel> itens) {
        this.itens = itens;
    }

    @Override
    public PullViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        ItemPullBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_pull, parent, false);

        return new PullViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(PullViewHolder holder, int position) {
        PullModel item = this.itens.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    @Override
    public void updateItens(ObservableArrayList<?> list) {
        this.itens.addAll((Collection<? extends PullModel>) list);
        this.notifyDataSetChanged();
    }

    class PullViewHolder extends RecyclerView.ViewHolder {

        private final ItemPullBinding binding;

        PullViewHolder(ItemPullBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }

        public void bind(PullModel model) {

            PullHandlerViewModel pullHandlerViewModel = new PullHandlerViewModel();

            binding.setViewlModel(pullHandlerViewModel);
            binding.executePendingBindings();

            pullHandlerViewModel.updateData(model);
        }
    }
}
