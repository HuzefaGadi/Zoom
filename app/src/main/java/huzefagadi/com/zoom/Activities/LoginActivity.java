package huzefagadi.com.zoom.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import huzefagadi.com.zoom.utilities.Constants;
import huzefagadi.com.zoom.R;
import huzefagadi.com.zoom.Zoom;
import huzefagadi.com.zoom.fragments.LoginFragment;
import huzefagadi.com.zoom.fragments.SignUpFragment;
import huzefagadi.com.zoom.interfaces.OnFragmentInteractionListener;

public class LoginActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    FragmentManager fragmentManager;
    SharedPreferences sharedPreferences;
    Zoom zoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        zoom = ((Zoom) getApplicationContext());
        sharedPreferences = zoom.getSharedPreferences();
        fragmentManager = getSupportFragmentManager();

        if (zoom.getLoggedInUser() != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            LoginFragment loginFragment = new LoginFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragments, loginFragment, Constants.FRAGMENT_LOGIN_NAME)
                    .addToBackStack(Constants.FRAGMENT_LOGIN_NAME)
                    .commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onButtonPressed(String fragmentName,String buttonName) {

        if (buttonName.equals(String.valueOf(R.id.button_signup))) {
            SignUpFragment signUpFragment = new SignUpFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragments, signUpFragment, Constants.FRAGMENT_SIGNUP_NAME)
                    .addToBackStack(Constants.FRAGMENT_SIGNUP_NAME)
                    .commit();
        } else if (buttonName.equals(String.valueOf(R.id.button_login))) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if (buttonName.equals(String.valueOf(R.id.button_signup_signin))) {
            fragmentManager.popBackStack();
        }

    }


}
