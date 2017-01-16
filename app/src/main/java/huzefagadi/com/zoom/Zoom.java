package huzefagadi.com.zoom;

import android.app.Application;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import huzefagadi.com.zoom.interfaces.ZoomCalls;
import huzefagadi.com.zoom.utilities.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rashida on 03/01/17.
 */
public class Zoom extends Application {

    private SharedPreferences sharedPreferences;
    private ZoomCalls zoomCalls;

    public SharedPreferences getSharedPreferences() {
        if (sharedPreferences == null)

        {
            sharedPreferences = getSharedPreferences(Constants.SHARED_PREFERENCES_NAME, MODE_PRIVATE);
        }

        return sharedPreferences;
    }

    public String getLoggedInUser() {
        String username = null;
        if (sharedPreferences != null) {
            username = sharedPreferences.getString(Constants.SP_USERNAME, null);
        } else {
            sharedPreferences = getSharedPreferences();
            username = sharedPreferences.getString(Constants.SP_USERNAME, null);
        }
        return username;
    }

    public ZoomCalls getWebService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        if (zoomCalls == null) {
            zoomCalls = retrofit.create(ZoomCalls.class);
        }
        return zoomCalls;
    }
}
