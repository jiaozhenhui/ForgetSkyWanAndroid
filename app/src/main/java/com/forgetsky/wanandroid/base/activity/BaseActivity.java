package com.forgetsky.wanandroid.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * MVP模式的Base Activity
 *
 */

public abstract class BaseActivity<T> extends AbstractSimpleActivity implements HasSupportFragmentInjector{

    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentDispatchingAndroidInjector;
    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

//    @Override
//    protected void onViewCreated() {
//        if (mPresenter != null) {
//            mPresenter.attachView(this);
//        }
//    }
//
//    @Override
//    protected void onDestroy() {
//        if (mPresenter != null) {
//            mPresenter.detachView();
//            mPresenter = null;
//        }
//        super.onDestroy();
//    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentDispatchingAndroidInjector;
    }


}
