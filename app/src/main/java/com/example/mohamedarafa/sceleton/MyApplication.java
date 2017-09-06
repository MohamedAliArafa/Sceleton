package com.example.mohamedarafa.sceleton;

import android.app.Application;
import android.content.Context;

import com.example.mohamedarafa.sceleton.Application.component.ApplicationComponent;
import com.example.mohamedarafa.sceleton.Application.component.DaggerApplicationComponent;
import com.example.mohamedarafa.sceleton.Application.module.ContextModule;
import com.example.mohamedarafa.sceleton.service.ApiService;
import com.squareup.picasso.Picasso;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import timber.log.Timber;

/**
 * Created by mohamed.arafa on 9/5/2017.
 */

public class MyApplication extends Application {

    private ApiService mApiService;
    private Picasso mPicasso;

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        ApplicationComponent applicationComponent = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);


        mPicasso = applicationComponent.getPicasso();
        mApiService = applicationComponent.getService();
    }

    public ApiService getApiService(){
        return mApiService;
    }

    public Picasso getPicasso() {
        return mPicasso;
    }
}

