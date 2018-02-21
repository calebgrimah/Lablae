package neoncore.com.lablae.api.models;

/**
 * Created by Musa on 1/5/2018.
 */

public class ProfileImage {
    private  String small;
    private  String medium;
    private  String large;

    public ProfileImage(String small, String medium, String large) {
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    public String getSmall() {
        return small;
    }

    public String getMedium() {
        return medium;
    }

    public String getLarge() {
        return large;
    }
}
