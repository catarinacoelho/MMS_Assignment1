package rest;

import android.util.Log;
import android.widget.Toast;

import com.example.flickrgalleryapp.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlickrServiceImplementation {
    private FlickrService flickrService;
    private MainActivity mainActivity;

    public FlickrServiceImplementation(MainActivity mainActivity) {
        this.mainActivity = mainActivity;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.flickr.com/services/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        flickrService = retrofit.create(FlickrService.class);
    }

    public void getPhotos(){
        Call<FlickrData> callFlickr = flickrService.getPhotos();
        callFlickr.enqueue(new Callback<FlickrData>() {
            @Override
            public void onResponse(Call<FlickrData> call, Response<FlickrData> response) {
                if(response.isSuccessful()){
                    mainActivity.setFlickrData(response.body());
                }
                else{
                    Toast.makeText(mainActivity.getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FlickrData> call, Throwable t) {
                Log.d("Failure", t.getMessage());
            }
        });
    }
}
