package br.com.tramalho.githubmvvm.presentation.repos;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import br.com.tramalho.githubmvvm.R;
import br.com.tramalho.githubmvvm.data.model.RepoModel;

/**
 * Created by trama on 15/12/17.
 */

public class BinderUtils {

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        Context context = imageView.getContext();
        if (!TextUtils.isEmpty(url)) {
            Glide.with(context)
                    .load(url)
                    .into(imageView);
        } else {
            imageView.setImageResource(R.drawable.ic_account_circle_black_24px);
        }
    }

    @BindingAdapter("bind:itens")
    public static void bindItens(RecyclerView recyclerView, ObservableArrayList<RepoModel> list) {
        RepoListAdapter adapter = (RepoListAdapter) recyclerView.getAdapter();
        adapter.updateItens(list);
    }
}
