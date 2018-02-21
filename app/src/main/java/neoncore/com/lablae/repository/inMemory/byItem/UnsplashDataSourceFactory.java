package neoncore.com.lablae.repository.inMemory.byItem;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

import neoncore.com.lablae.api.models.PhotoObjects;

/**
 * Created by Musa on 1/6/2018.
 */

public class UnsplashDataSourceFactory implements DataSource.Factory{
    MutableLiveData<UnsplashPagedKeyedDataSource> mutableLiveData;
    UnsplashPagedKeyedDataSource unsplashPagedKeyedDataSource;
   // UnsplashItemKeyedDataSource unsplashItemKeyedDataSource;
    Executor executor;

    public UnsplashDataSourceFactory(Executor executor) {
        this.mutableLiveData = new MutableLiveData<UnsplashPagedKeyedDataSource>();
        this.executor = executor;
    }

    @Override
    public DataSource<String, PhotoObjects> create() {

        unsplashPagedKeyedDataSource = new UnsplashPagedKeyedDataSource(executor);
        mutableLiveData.postValue(unsplashPagedKeyedDataSource);
        return unsplashPagedKeyedDataSource;

    }

    public MutableLiveData<UnsplashPagedKeyedDataSource> getMutableLiveData() {
        return mutableLiveData;
    }
}
