package br.com.tramalho.githubmvvm.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trama on 25/01/18.
 */

public class PullUser {
    private String login;

    @SerializedName("avatar_url")
    private String avatarUrl;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getLogin() {
        return login;
    }
}
