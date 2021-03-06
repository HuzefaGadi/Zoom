package huzefagadi.com.zoom.utilities;

import java.util.ArrayList;
import java.util.List;

import huzefagadi.com.zoom.beans.EbookBean;
import huzefagadi.com.zoom.beans.VideoBean;

/**
 * Created by huzefaasger on 29-12-2016.
 */
public class Constants {

    public static String YOUTUBE_CLIENT_KEY = "486384231056-dt1vbi4d3qjft6ht7tk4ouqkr9bp119n.apps.googleusercontent.com";
    public static String FRAGMENT_VIDEOS_LIST="videosListFragment";
    public static String FRAGMENT_VIDEO_DETAIL="videoDetailFragment";
    public static String FRAGMENT_LOGIN_NAME="loginFragment";
    public static String FRAGMENT_HOME_NAME="homeFragment";
    public static String FRAGMENT_SIGNUP_NAME="signupFragment";
    public static String SHARED_PREFERENCES_NAME="sharedpreferences";
    public static String SP_USERNAME="username";
    public static String[] COURSES = new String[]{"Cisco courses","Microsoft Courses","Linux Courses","Security Courses","VMware","Search"};
    public static String LOGGED_IN_USER_AUTH="authToken";
    private List<VideoBean> videoList;
    private List<EbookBean> ebookList;
    public static String EBOOK_URL="url";
    public Constants()
    {
        videoList = new ArrayList<VideoBean>();
        VideoBean videoBean = new VideoBean();
        videoBean.setVideoId("cv4DxuqLkZw");
        videoBean.setVideoTitle("First Video");
        videoList.add(videoBean);
        videoBean = new VideoBean();
        videoBean.setVideoId("n2D1o-aM-2s");
        videoBean.setVideoTitle("Second Video");
        videoList.add(videoBean);
        videoBean = new VideoBean();
        videoBean.setVideoId("AI-ccxMNEiI");
        videoBean.setVideoTitle("Third Video");
        videoList.add(videoBean);
        videoBean = new VideoBean();
        videoBean.setVideoId("fqmmr2DCSw");
        videoBean.setVideoTitle("Fourth Video");
        videoList.add(videoBean);
        videoBean = new VideoBean();
        videoBean.setVideoId("373m0NtTIew");
        videoBean.setVideoTitle("Fifth Video");
        videoList.add(videoBean);

        ebookList = new ArrayList<EbookBean>();
        EbookBean ebookBean = new EbookBean();
        ebookBean.setTitle("First Book");
        ebookBean.setDescription("First Book Description");
        ebookBean.setThumbnailUrl("http://zoomgroup.com/training/india/free/images/CCNA-Lab-Manual-T-Front.jpg");
        ebookBean.setUrl("http://zoomgroup.com/training/india/free/ccna-lab-manual/");
        ebookList.add(ebookBean);

        ebookBean = new EbookBean();
        ebookBean.setTitle("Second Book");
        ebookBean.setDescription("Second Book Description");
        ebookBean.setThumbnailUrl("http://zoomgroup.com/training/india/free/images/CCNA-Lab-Manual-T-Front.jpg");
        ebookBean.setUrl("http://zoomgroup.com/training/india/free/ccna-lab-manual/");
        ebookList.add(ebookBean);

        ebookBean = new EbookBean();
        ebookBean.setTitle("Third Book");
        ebookBean.setDescription("Third Book Description");
        ebookBean.setThumbnailUrl("http://zoomgroup.com/training/india/free/images/CCNA-Lab-Manual-T-Front.jpg");
        ebookBean.setUrl("http://zoomgroup.com/training/india/free/ccna-lab-manual/");
        ebookList.add(ebookBean);

        ebookBean = new EbookBean();
        ebookBean.setTitle("Fourth Book");
        ebookBean.setDescription("Fourth Book Description");
        ebookBean.setThumbnailUrl("http://zoomgroup.com/training/india/free/images/CCNA-Lab-Manual-T-Front.jpg");
        ebookBean.setUrl("http://zoomgroup.com/training/india/free/ccna-lab-manual/");
        ebookList.add(ebookBean);

        ebookBean = new EbookBean();
        ebookBean.setTitle("Five Book");
        ebookBean.setDescription("Five Book Description");
        ebookBean.setThumbnailUrl("http://zoomgroup.com/training/india/free/images/CCNA-Lab-Manual-T-Front.jpg");
        ebookBean.setUrl("http://zoomgroup.com/training/india/free/ccna-lab-manual/");
        ebookList.add(ebookBean);

        ebookBean = new EbookBean();
        ebookBean.setTitle("Six Book");
        ebookBean.setDescription("Six Book Description");
        ebookBean.setThumbnailUrl("http://zoomgroup.com/training/india/free/images/CCNA-Lab-Manual-T-Front.jpg");
        ebookBean.setUrl("http://zoomgroup.com/training/india/free/ccna-lab-manual/");
        ebookList.add(ebookBean);


    }

    public List<VideoBean> getVideoList() {
        return videoList;
    }

    public List<EbookBean> getEbookList() {
        return ebookList;
    }

    public void setVideoList(List<VideoBean> videoList) {
        this.videoList = videoList;
    }

    public static String BASE_URL = "http://www.statigsoft.com/tutorial/";
}
