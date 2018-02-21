//package neoncore.com.lablae.repository.inMemory.byItem;
//
//import android.arch.lifecycle.MutableLiveData;
//import android.arch.paging.ItemKeyedDataSource;
//import android.support.annotation.NonNull;
//import android.util.Log;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.Executor;
//
//import neoncore.com.lablae.api.UnsplashAPI;
//import neoncore.com.lablae.api.UnsplashService;
//import neoncore.com.lablae.api.models.PhotoObjects;
//import neoncore.com.lablae.repository.NetworkState;
//import neoncore.com.lablae.repository.Status;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
///**
// * Created by Musa on 1/9/2018.
// */
//
//public class UnsplashItemKeyedDataSource extends ItemKeyedDataSource<String,PhotoObjects> {
//
//    public static final String TAG = "ItemKeyedUserDataSource";
//    UnsplashService unsplashService;
//    ItemKeyedDataSource.LoadInitialParams<String> initialParams;
//    ItemKeyedDataSource.LoadParams<String> afterParams;
//    private MutableLiveData networkState;
//    private MutableLiveData initialLoading;
//    private Executor retryExecutor;
//
//    public UnsplashItemKeyedDataSource(Executor retryExecutor) {
//        unsplashService = UnsplashAPI.createUnsplashService();
//        networkState = new MutableLiveData();
//        initialLoading = new MutableLiveData();
//        this.retryExecutor = retryExecutor;
//    }
//
//    public MutableLiveData getNetworkState() {
//        return networkState;
//    }
//
//    public MutableLiveData getInitialLoading() {
//        return initialLoading;
//    }
//
//    @Override
//    public void loadInitial(@NonNull LoadInitialParams<String> params, @NonNull final LoadInitialCallback<PhotoObjects> callback) {
//        Log.i(TAG, "Loading Rang " + 1 + " Count " + params.requestedLoadSize);
//        final List<PhotoObjects> photoObjectsList = new ArrayList();
//        initialParams = params;
//        initialLoading.postValue(NetworkState.LOADING);
//        networkState.postValue(NetworkState.LOADING);
//        unsplashService.getPhotosListInitial(String.valueOf(1),params.requestedLoadSize).enqueue(new Callback<ArrayList<PhotoObjects>>() {
//            @Override
//            public void onResponse(Call<ArrayList<PhotoObjects>> call, Response<ArrayList<PhotoObjects>> response) {
//                if (response.isSuccessful() && response.code() == 200) {
//                    photoObjectsList.addAll(response.body());
//                    callback.onResult(photoObjectsList);
//                    initialLoading.postValue(NetworkState.LOADED);
//                    networkState.postValue(NetworkState.LOADED);
//                    initialParams = null;
//                } else {
//                    Log.e("API CALL", response.message());
//                    initialLoading.postValue(new NetworkState(Status.FAILED, response.message()));
//                    networkState.postValue(new NetworkState(Status.FAILED, response.message()));
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<PhotoObjects>> call, Throwable t) {
//                String errorMessage;
//                errorMessage = t.getMessage();
//                if (t == null) {
//                    errorMessage = "unknown error";
//                }
//                networkState.postValue(new NetworkState(Status.FAILED, errorMessage));
//
//
//            }
//        });
//    }
//
//    @Override
//    public void loadAfter(@NonNull LoadParams<String> params, @NonNull final LoadCallback<PhotoObjects> callback) {
//        Log.i(TAG, "Loading Rang " + params.key + " Count " + params.requestedLoadSize);
//        final List<PhotoObjects> photoObjects = new ArrayList();
//        afterParams = params;
//        networkState.postValue(NetworkState.LOADING);
//        unsplashService.getPhotosListInitial(afterParams.key,params.requestedLoadSize).enqueue(new Callback<ArrayList<PhotoObjects>>() {
//            @Override
//            public void onResponse(Call<ArrayList<PhotoObjects>> call, Response<ArrayList<PhotoObjects>> response) {
//                if (response.isSuccessful()) {
//                    photoObjects.addAll(response.body());
//                    callback.onResult(photoObjects);
//                    networkState.postValue(NetworkState.LOADED);
//                    afterParams = null;
//                } else {
//                    networkState.postValue(new NetworkState(Status.FAILED, response.message()));
//                    Log.e("API CALL", response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<PhotoObjects>> call, Throwable t) {
//
//                String errorMessage;
//                errorMessage = t.getMessage();
//                if (t == null) {
//                    errorMessage = "unknown error";
//                }
//                networkState.postValue(new NetworkState(Status.FAILED, errorMessage));
//
//            }
//        });
//
//
//    }
//
//    @Override
//    public void loadBefore(@NonNull LoadParams<String> params, @NonNull LoadCallback<PhotoObjects> callback) {
//
//    }
//
//    @NonNull
//    @Override
//    public String getKey(@NonNull PhotoObjects item) {
//        return item.getPhotoID();
//    }
//}
