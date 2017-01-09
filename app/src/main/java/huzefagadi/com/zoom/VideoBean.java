package huzefagadi.com.zoom;

/**
 * Created by Rashida on 05/01/17.
 */
public class VideoBean {
    private String videoId;
    private String videoTitle;

    public VideoBean() {
    }

    public VideoBean(String videoId, String videoTitle) {
        this.videoId = videoId;
        this.videoTitle = videoTitle;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }
}
