package br.com.tramalho.githubmvvm.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by trama on 12/12/17.
 */

public class GIthubRepoResponse {

    @SerializedName("items")
    private List<RepoModel> itens;

    public List<RepoModel> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "GIthubRepoResponse{" +
                "itens=" + itens +
                '}';
    }
}
