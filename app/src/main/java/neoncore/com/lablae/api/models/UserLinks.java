package neoncore.com.lablae.api.models;

/**
 * Created by Musa on 1/5/2018.
 */

class UserLinks {
    private String self;
    private String html;
    private String photos;
    private String likes;
    private String portfolio;
    private String following;
    private String followers;


    public UserLinks(String self, String html, String photos, String likes, String portfolio, String following, String followers) {
        this.self = self;
        this.html = html;
        this.photos = photos;
        this.likes = likes;
        this.portfolio = portfolio;
        this.following = following;
        this.followers = followers;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }
}
