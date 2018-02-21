package neoncore.com.lablae;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import neoncore.com.lablae.UI.PhotoAdapter;
import neoncore.com.lablae.UI.UserViewModel;
import neoncore.com.lablae.Util.ListItemClickListener;
import neoncore.com.lablae.api.models.PhotoObjects;
import neoncore.com.lablae.repository.NetworkState;

public class MainActivity extends AppCompatActivity implements ListItemClickListener {
    private UserViewModel viewModel;
    private String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.userList);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);


        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        final PhotoAdapter userUserAdapter = new PhotoAdapter(this,this);

       viewModel.photoList.observe(this, new Observer<PagedList<PhotoObjects>>() {
           @Override
           public void onChanged(@Nullable PagedList<PhotoObjects> photoObjects) {
               userUserAdapter.setList(photoObjects);
           }
       });

        viewModel.networkState.observe(this, new Observer<NetworkState>() {
            @Override
            public void onChanged(@Nullable NetworkState networkState) {
                userUserAdapter.setNetworkState(networkState);
//                Log.d(TAG, "Network State Change");
            }


        });

        recyclerView.setAdapter(userUserAdapter);
    }

    @Override
    public void onRetryClick(View view, int position) {
        Log.d(TAG, "Position " + position);
    }
}
