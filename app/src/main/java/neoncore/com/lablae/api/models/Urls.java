package neoncore.com.lablae.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Musa on 1/5/2018.
 */

public class Urls {
    @SerializedName("raw")
    private String rawPhotoUrl;
    @SerializedName("full")
    private String fullPhotoUrl;
    @SerializedName("regular")
    private String regularPhotoUrl;
    @SerializedName("small")
    private String smallPhotoUrl;
    @SerializedName("thumb")
    private String thumbNailURL;

    public Urls(String rawPhotoUrl, String fullPhotoUrl, String regularPhotoUrl, String smallPhotoUrl, String thumbNailURL) {
        this.rawPhotoUrl = rawPhotoUrl;
        this.fullPhotoUrl = fullPhotoUrl;
        this.regularPhotoUrl = regularPhotoUrl;
        this.smallPhotoUrl = smallPhotoUrl;
        this.thumbNailURL = thumbNailURL;
    }

    public String getRawPhotoUrl() {
        return rawPhotoUrl;
    }

    public void setRawPhotoUrl(String rawPhotoUrl) {
        this.rawPhotoUrl = rawPhotoUrl;
    }

    public String getFullPhotoUrl() {
        return fullPhotoUrl;
    }

    public void setFullPhotoUrl(String fullPhotoUrl) {
        this.fullPhotoUrl = fullPhotoUrl;
    }

    public String getRegularPhotoUrl() {
        return regularPhotoUrl;
    }

    public void setRegularPhotoUrl(String regularPhotoUrl) {
        this.regularPhotoUrl = regularPhotoUrl;
    }

    public String getSmallPhotoUrl() {
        return smallPhotoUrl;
    }

    public void setSmallPhotoUrl(String smallPhotoUrl) {
        this.smallPhotoUrl = smallPhotoUrl;
    }

    public String getThumbNailURL() {
        return thumbNailURL;
    }

    public void setThumbNailURL(String thumbNailURL) {
        this.thumbNailURL = thumbNailURL;
    }
}
