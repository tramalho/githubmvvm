package br.com.tramalho.githubmvvm.infraestructure;

import android.support.annotation.NonNull;

import br.com.tramalho.githubmvvm.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by trama on 12/12/17.
 */

public class RemoteProvider {

    private Retrofit getRetrofit() {

        OkHttpClient.Builder httpClient = createLogInterceptor();

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();
    }

    @NonNull
    private OkHttpClient.Builder createLogInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        return httpClient;
    }

    public ServiceApi create() {
        Retrofit retrofit = getRetrofit();
        return retrofit.create(ServiceApi.class);
    }
}
