package br.com.tramalho.githubmvvm.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trama on 11/12/17.
 */
public class RepoModel implements Parcelable {

    public static final Creator<RepoModel> CREATOR = new Creator<RepoModel>() {
        @Override
        public RepoModel createFromParcel(Parcel source) {
            return new RepoModel(source);
        }

        @Override
        public RepoModel[] newArray(int size) {
            return new RepoModel[size];
        }
    };
    @SerializedName("name")
    private String name = "";
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

    public RepoModel() {
    }

    protected RepoModel(Parcel in) {
        this.name = in.readString();
        this.fullName = in.readString();
        this.description = in.readString();
        this.forksCount = in.readLong();
        this.stargazersCount = in.readLong();
        this.avatarUrl = in.readString();
        this.owner = in.readParcelable(RepoOwner.class.getClassLoader());
    }

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

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RepoModel{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", description='" + description + '\'' +
                ", forksCount=" + forksCount +
                ", stargazersCount=" + stargazersCount +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", owner=" + owner +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.fullName);
        dest.writeString(this.description);
        dest.writeLong(this.forksCount);
        dest.writeLong(this.stargazersCount);
        dest.writeString(this.avatarUrl);
        dest.writeParcelable(this.owner, flags);
    }
}
