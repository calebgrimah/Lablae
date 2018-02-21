package neoncore.com.lablae.UI;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import neoncore.com.lablae.api.models.PhotoObjects;
import neoncore.com.lablae.repository.NetworkState;
import neoncore.com.lablae.repository.inMemory.byItem.UnsplashDataSourceFactory;
import neoncore.com.lablae.repository.inMemory.byItem.UnsplashPagedKeyedDataSource;

/**
 * Created by Musa on 1/8/2018.
 */

public class UserViewModel extends ViewModel {

    public LiveData<PagedList<PhotoObjects>> photoList;
    public LiveData<NetworkState> networkState;
    Executor executor;
    LiveData<UnsplashPagedKeyedDataSource> tDataSource;

    public UserViewModel() {
        executor = Executors.newFixedThreadPool(5);
        UnsplashDataSourceFactory unsplashDataSourceFactory = new UnsplashDataSourceFactory(executor);

        tDataSource = unsplashDataSourceFactory.getMutableLiveData();

        networkState = Transformations.switchMap(unsplashDataSourceFactory.getMutableLiveData(), new Function<UnsplashPagedKeyedDataSource, LiveData<NetworkState>>() {
                    @Override
                    public LiveData<NetworkState> apply(UnsplashPagedKeyedDataSource input) {
                        return input.getNetworkState();
                    }
                });


                PagedList.Config pagedListConfig =
                        (new PagedList.Config.Builder()).setEnablePlaceholders(false)
                                .setInitialLoadSizeHint(10)
                                .setPageSize(20).build();

        photoList = (new LivePagedListBuilder(unsplashDataSourceFactory, pagedListConfig))
                .setBackgroundThreadExecutor(executor)
                .build();
    }
}
