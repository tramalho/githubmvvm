package br.com.tramalho.githubmvvm.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trama on 11/12/17.
 */

public class RepoModel {

    @SerializedName("full_name")
    private String fullName = "Teste Repositorio";

    @SerializedName("description")
    private String description = "descrição fake";

    @SerializedName("forks_count")
    private long forksCount;

    @SerializedName("owner")
    private RepoOwner owner;

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public long getForksCount() {
        return forksCount;
    }

    public RepoOwner getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "RepoModel{" +
                "fullName='" + fullName + '\'' +
                ", description='" + description + '\'' +
                ", forksCount=" + forksCount +
                '}';
    }
}
