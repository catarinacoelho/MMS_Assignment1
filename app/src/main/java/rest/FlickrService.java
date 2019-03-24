package rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface FlickrService {
    @GET("feeds/photos_public.gn?format=json")
    Call<FlickrData> getPhotos();
}
