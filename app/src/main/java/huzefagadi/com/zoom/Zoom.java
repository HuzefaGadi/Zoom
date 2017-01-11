package huzefagadi.com.zoom;

import android.app.Application;
import android.content.SharedPreferences;

import huzefagadi.com.zoom.utilities.Constants;

/**
 * Created by Rashida on 03/01/17.
 */
public class Zoom extends Application {

    private SharedPreferences sharedPreferences;


    public SharedPreferences getSharedPreferences()
    {
        if(sharedPreferences == null)

        {
            sharedPreferences = getSharedPreferences(Constants.SHARED_PREFERENCES_NAME,MODE_PRIVATE);
        }

        return sharedPreferences;
    }

    public String getLoggedInUser()
    {
        String username = null;
        if(sharedPreferences!=null)
        {
            username = sharedPreferences.getString(Constants.SP_USERNAME,null);
        }
        else
        {
            sharedPreferences = getSharedPreferences();
            username = sharedPreferences.getString(Constants.SP_USERNAME, null);
        }
        return username;
    }
}
