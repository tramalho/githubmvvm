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

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public long getForksCount() {
        return forksCount;
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
