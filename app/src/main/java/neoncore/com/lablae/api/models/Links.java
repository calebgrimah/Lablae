package neoncore.com.lablae.api.models;

/**
 * Created by Musa on 1/6/2018.
 */

public class Links {
    private String self;
    private String html;
    private String download;
    private String download_location;


    public Links(String self, String html, String download, String download_location) {
        this.self = self;
        this.html = html;
        this.download = download;
        this.download_location = download_location;
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

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getDownload_location() {
        return download_location;
    }

    public void setDownload_location(String download_location) {
        this.download_location = download_location;
    }
}
