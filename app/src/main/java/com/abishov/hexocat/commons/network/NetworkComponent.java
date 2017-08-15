package com.abishov.hexocat.commons.network;

import android.support.annotation.NonNull;

import com.abishov.hexocat.commons.dagger.PerSession;
import com.abishov.hexocat.home.trending.TrendingComponent;
import com.abishov.hexocat.home.trending.TrendingModule;

import dagger.Subcomponent;

@PerSession
@Subcomponent(modules = NetworkModule.class)
public interface NetworkComponent {

    @NonNull
    TrendingComponent plus(@NonNull TrendingModule trendingModule);
}