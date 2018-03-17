package br.com.tramalho.githubmvvm.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trama on 23/12/17.
 */

public class PullModel {

    private String title;
    private String body;
    private PullUser user;

    @SerializedName("html_url")
    private String htmlUrl;

    @SerializedName("created_at")
    private String createdAt;

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public PullUser getUser() {
        return user;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }
}
