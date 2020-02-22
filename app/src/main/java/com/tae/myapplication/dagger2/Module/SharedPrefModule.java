package com.tae.myapplication.dagger2.Module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.tae.myapplication.entity.ApiRetrofit;
import com.tae.myapplication.entity.RetrofitClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by anupamchugh on 06/11/17.
 */

@Module
public class SharedPrefModule {
    private Context context;

   // public SharedPrefModule(Context context) {
     //   this.context = context;
   // }


    @Singleton
    @Provides
    public Context provideContext(Application application) {
        return application;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Singleton
    @Provides
    public ApiRetrofit provideRetrofit ()
    {return RetrofitClient.callRetrofit().create(ApiRetrofit.class);
    }
}
