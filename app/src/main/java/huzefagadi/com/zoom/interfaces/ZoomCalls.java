package huzefagadi.com.zoom.interfaces;

import huzefagadi.com.zoom.beans.ZoomResponse;
import huzefagadi.com.zoom.beans.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Rashida on 15/01/17.
 */

public interface ZoomCalls {

    @FormUrlEncoded
    @POST("registerUser.php")
    Call<ZoomResponse> singUpUser(@Field("firstname") String firstname, @Field("lastname") String lastname,
                                  @Field("gender") String gender, @Field("email") String email,
                                  @Field("password") String password,@Field("mobile_no") String mobileNumber);

    @FormUrlEncoded
    @POST("loginUser.php")
    Call<ZoomResponse> singInUser(@Field("firstname") String firstname, @Field("lastname") String lastname,
                                  @Field("gender") String gender, @Field("email") String email,
                                  @Field("password") String password,@Field("mobile_no") String mobileNumber);
}
