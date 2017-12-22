package br.com.tramalho.githubmvvm.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trama on 11/12/17.
 */

public class RepoModel {

    @SerializedName("full_name")
    private String fullName = "";

    @SerializedName("description")
    private String description = "";

    @SerializedName("forks_count")
    private long forksCount = 0;

    @SerializedName("stargazers_count")
    private long stargazersCount = 0;

    @SerializedName("avatar_url")
    private String avatarUrl = "";

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

    public void setOwner(RepoOwner owner) {
        this.owner = owner;
    }

    public long getStargazersCount() {
        return stargazersCount;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Override
    public String toString() {
        return "RepoModel{" +
                "fullName='" + fullName + '\'' +
                ", description='" + description + '\'' +
                ", forksCount=" + forksCount +
                ", stargazersCount=" + stargazersCount +
                ", owner=" + owner +
                '}';
    }
}
