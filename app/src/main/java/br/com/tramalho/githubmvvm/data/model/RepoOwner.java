package br.com.tramalho.githubmvvm.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trama on 13/12/17.
 */

public class RepoOwner {

    @SerializedName("login")
    private String login;

    @SerializedName("name")
    private String name;

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }
}
