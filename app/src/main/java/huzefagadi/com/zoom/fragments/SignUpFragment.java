package huzefagadi.com.zoom.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import huzefagadi.com.zoom.R;
import huzefagadi.com.zoom.Zoom;
import huzefagadi.com.zoom.beans.User;
import huzefagadi.com.zoom.beans.ZoomResponse;
import huzefagadi.com.zoom.interfaces.OnFragmentInteractionListener;
import huzefagadi.com.zoom.interfaces.ZoomCalls;
import huzefagadi.com.zoom.utilities.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class SignUpFragment extends Fragment {

    @BindView(R.id.input_firstname)
    EditText etFirstName;

    @BindView(R.id.input_lastname)
    EditText etLastName;

    @BindView(R.id.input_username)
    EditText etEmail;

    @BindView(R.id.input_password)
    EditText etPassword;

    @BindView(R.id.input_confirm_password)
    EditText etConfirmPassword;

    @BindView(R.id.input_mobile)
    EditText etMobileNumber;

    @BindView(R.id.gender)
    Spinner spGender;

    ZoomCalls zoomCalls;
    private OnFragmentInteractionListener mListener;
    ProgressDialog progressDialog;
    SharedPreferences preferences;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        zoomCalls = ((Zoom) getActivity().getApplicationContext()).getWebService();
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        preferences = ((Zoom) getActivity().getApplicationContext()).getSharedPreferences();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @OnClick(R.id.button_signup_signin)
    public void signUp(View v) {
        User user = new User();
        user.setFirstName(etFirstName.getText().toString());
        user.setLastName(etLastName.getText().toString());
        user.setEmail(etEmail.getText().toString());
        user.setPassword(etPassword.getText().toString());
        user.setGender(spGender.getSelectedItem().toString().equalsIgnoreCase("Male") ? "M" : "F");
        user.setMobileNumber(etMobileNumber.getText().toString());
        progressDialog.setTitle("SignUp in progress");
        progressDialog.setMessage("Please wait..");
        progressDialog.show();
        if (validateFields(user)) {
            Call<ZoomResponse> response = zoomCalls.singUpUser(user.getFirstName(), user.getLastName(), user.getGender(),
                    user.getEmail(), user.getPassword(), user.getMobileNumber());
            response.enqueue(new Callback<ZoomResponse>() {

                @Override
                public void onResponse(Call<ZoomResponse> call, Response<ZoomResponse> response) {
                    progressDialog.cancel();
                    ZoomResponse zoomResponse = response.body();
                    if (zoomResponse.getStatus().equalsIgnoreCase("success")) {
                        preferences.edit().putString(Constants.LOGGED_IN_USER_AUTH,zoomResponse.getAuthkey()).commit();
                        mListener.onButtonPressed(this.getClass().getName(), String.valueOf(R.id.button_signup_signin));
                    } else {
                        Toast.makeText(getActivity(), zoomResponse.getDescription(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<ZoomResponse> call, Throwable t) {
                    // Log error here since request failed
                    progressDialog.cancel();
                    Toast.makeText(getActivity(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });


        }

    }

    public boolean validateFields(User user) {

        if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
            Toast.makeText(getActivity(), "First Name cannot be empty", Toast.LENGTH_LONG).show();
            etFirstName.setError("First Name cannot be empty");
            return false;
        }
        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            Toast.makeText(getActivity(), "Last Name cannot be empty", Toast.LENGTH_LONG).show();
            etLastName.setError("Last Name cannot be empty");
            return false;
        }
        if (user.getGender() == null || user.getGender().isEmpty()) {
            Toast.makeText(getActivity(), "Please select Gender", Toast.LENGTH_LONG).show();
            return false;
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            Toast.makeText(getActivity(), "Email cannot be empty", Toast.LENGTH_LONG).show();
            etEmail.setError("Email cannot be empty");
            return false;
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            Toast.makeText(getActivity(), "Password cannot be empty", Toast.LENGTH_LONG).show();
            etPassword.setError("Password cannot be empty");
            return false;
        }
        if (etConfirmPassword.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "Confirm Password cannot be empty", Toast.LENGTH_LONG).show();
            etConfirmPassword.setError("Confirm Password cannot be empty");
            return false;
        }
        if (user.getMobileNumber() == null || user.getMobileNumber().isEmpty()) {
            Toast.makeText(getActivity(), "Mobile number cannot be empty", Toast.LENGTH_LONG).show();
            etMobileNumber.setError("Mobile number cannot be empty");
            return false;
        }
        if (!etConfirmPassword.getText().toString().equals(user.getPassword())) {
            Toast.makeText(getActivity(), "Passwords doesn't match", Toast.LENGTH_LONG).show();
            etConfirmPassword.setError("Passwords doesn't match");
            etConfirmPassword.setText("");
            return false;
        }

        return true;
    }
}
