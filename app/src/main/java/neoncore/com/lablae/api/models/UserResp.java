package neoncore.com.lablae.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Musa on 1/5/2018.
 */

public class UserResp {
    @SerializedName("id")
    private String userID;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("username")
    private String userName;
    @SerializedName("name")
    private String name;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("twitter_username")
    private String twitterUserName;
    @SerializedName("portfolio_url")
    private String portfolioUrl;
    @SerializedName("bio")
    private String bio;
    @SerializedName("location")
    private String location;
    @SerializedName("links")
    private UserLinks userLinks;
    @SerializedName("profile_image")
    private ProfileImage profileImage;
    @SerializedName("total_likes")
    private Integer totalLikes;
    @SerializedName("total_photos")
    private Integer totalPhotos;
    @SerializedName("total_collections")
    private Integer totalCollections;

    public UserResp(String userID, String updatedAt, String userName, String name, String firstName, String lastName, String twitterUserName, String portfolioUrl, String bio, String location, UserLinks userLinks, ProfileImage profileImage, Integer totalLikes, Integer totalPhotos, Integer totalCollections) {
        this.userID = userID;
        this.updatedAt = updatedAt;
        this.userName = userName;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.twitterUserName = twitterUserName;
        this.portfolioUrl = portfolioUrl;
        this.bio = bio;
        this.location = location;
        this.userLinks = userLinks;
        this.profileImage = profileImage;
        this.totalLikes = totalLikes;
        this.totalPhotos = totalPhotos;
        this.totalCollections = totalCollections;
    }

    public String getUserID() {
        return userID;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTwitterUserName() {
        return twitterUserName;
    }

    public String getPortfolioUrl() {
        return portfolioUrl;
    }

    public String getBio() {
        return bio;
    }

    public String getLocation() {
        return location;
    }

    public UserLinks getUserLinks() {
        return userLinks;
    }

    public ProfileImage getProfileImage() {
        return profileImage;
    }

    public Integer getTotalLikes() {
        return totalLikes;
    }

    public Integer getTotalPhotos() {
        return totalPhotos;
    }

    public Integer getTotalCollections() {
        return totalCollections;
    }
}
