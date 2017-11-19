package com.abishov.hexocat.common.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
final class SchedulerProviderImpl implements SchedulerProvider {

  @Inject
  SchedulerProviderImpl() {
    // keeping this constructor for dagger
  }

  @Override
  public Scheduler computation() {
    return Schedulers.computation();
  }

  @Override
  public Scheduler io() {
    return Schedulers.io();
  }

  @Override
  public Scheduler ui() {
    return AndroidSchedulers.mainThread();
  }
}
