package rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface FlickrService {
    @GET("photos_public.gne?format=json")
    Call<FlickrData> getPhotos();
}
