package br.com.tramalho.githubmvvm.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trama on 13/12/17.
 */

public class RepoOwner implements Parcelable {

    public static final Parcelable.Creator<RepoOwner> CREATOR = new Parcelable.Creator<RepoOwner>() {
        @Override
        public RepoOwner createFromParcel(Parcel source) {
            return new RepoOwner(source);
        }

        @Override
        public RepoOwner[] newArray(int size) {
            return new RepoOwner[size];
        }
    };
    @SerializedName("login")
    private String login;
    @SerializedName("name")
    private String name;

    public RepoOwner() {
    }

    protected RepoOwner(Parcel in) {
        this.login = in.readString();
        this.name = in.readString();
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.login);
        dest.writeString(this.name);
    }
}
