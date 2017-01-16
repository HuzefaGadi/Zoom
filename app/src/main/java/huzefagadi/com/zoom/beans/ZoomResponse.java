package huzefagadi.com.zoom.beans;

/**
 * Created by Rashida on 15/01/17.
 */

public class ZoomResponse {

    private String status;
    private String description;
    private String authkey;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthkey() {
        return authkey;
    }

    public void setAuthkey(String authkey) {
        this.authkey = authkey;
    }
}
