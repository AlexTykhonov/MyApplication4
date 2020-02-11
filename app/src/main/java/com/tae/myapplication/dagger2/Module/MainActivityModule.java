package com.tae.myapplication.dagger2.Module;

import com.tae.myapplication.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivity();

}
