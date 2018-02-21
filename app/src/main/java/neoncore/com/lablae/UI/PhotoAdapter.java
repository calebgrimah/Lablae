package neoncore.com.lablae.UI;


import android.app.Activity;
import android.arch.paging.PagedListAdapter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import neoncore.com.lablae.R;
import neoncore.com.lablae.Util.ListItemClickListener;
import neoncore.com.lablae.api.models.Links;
import neoncore.com.lablae.api.models.PhotoObjects;
import neoncore.com.lablae.api.models.Urls;
import neoncore.com.lablae.repository.NetworkState;
import neoncore.com.lablae.repository.Status;

/**
 * Created by Musa on 1/8/2018.
 */

public class PhotoAdapter extends PagedListAdapter<PhotoObjects,RecyclerView.ViewHolder> {

    private static final String TAG = "PhotoAdapter";
    private NetworkState networkState;
    private ListItemClickListener itemClickListener;
    Activity mActivity;


    public PhotoAdapter(ListItemClickListener itemClickListener,Activity activity) {
        super(PhotoObjects.DIFF_CALLBACK);
        this.itemClickListener = itemClickListener;
        mActivity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;

        if (viewType == R.layout.item_user_list) {
            view = layoutInflater.inflate(R.layout.item_user_list, parent, false);
            return new PhotoItemViewHolder(view,mActivity);
        } else if (viewType == R.layout.network_state_item) {
            view = layoutInflater.inflate(R.layout.network_state_item, parent, false);
            return new NetworkStateItemViewHolder(view, itemClickListener);
        } else {
            throw new IllegalArgumentException("unknown view type");
        }

    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case R.layout.item_user_list:
                ((PhotoItemViewHolder) holder).bindTo(getItem(position));
                break;
            case R.layout.network_state_item:
                ((NetworkStateItemViewHolder) holder).bindView(networkState);
                break;
        }
    }

    private boolean hasExtraRow() {
        if (networkState != null && networkState != NetworkState.LOADED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (hasExtraRow() && position == getItemCount() - 1) {
            return R.layout.network_state_item;
        } else {
            return R.layout.item_user_list;
        }
    }
    public void setNetworkState(NetworkState newNetworkState) {
        NetworkState previousState = this.networkState;
        boolean previousExtraRow = hasExtraRow();
        this.networkState = newNetworkState;
        boolean newExtraRow = hasExtraRow();
        if (previousExtraRow != newExtraRow) {
            if (previousExtraRow) {
                notifyItemRemoved(getItemCount());
            } else {
                notifyItemInserted(getItemCount());
            }
        } else if (newExtraRow && previousState != newNetworkState) {
            notifyItemChanged(getItemCount() - 1);
        }
    }

    static class PhotoItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        Activity mActivity;




        public PhotoItemViewHolder(View itemView, Activity activity) {
            super(itemView);
            mActivity = activity;

           // photoID = itemView.findViewById(R.id.imageID);
            //createdAt = itemView.findViewById(R.id.createdAt);
            imageView = itemView.findViewById(R.id.image);
        }


        public void bindTo(final PhotoObjects objects) {

            final Urls urls = objects.getPhotoUrls();
            final Links links = objects.getLinks();
           //createdAt.setText(objects.getCreatedAt());
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mActivity, objects.getPhotoID(), Toast.LENGTH_SHORT).show();
                    Picasso.with(mActivity)
                            .load(links.getDownload_location()).into(new Target() {
                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                            try {
                                String root = Environment.getExternalStorageDirectory().toString();
                                File myDir = new File(root + "/lablae");

                                if (!myDir.exists()) {
                                    myDir.mkdirs();
                                }
                                    String name = new Date().toString() + ".jpg";
                                    myDir = new File(myDir, name);
                                    FileOutputStream out = new FileOutputStream(myDir);
                                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
                                    out.flush();
                                    out.close();
                                    Toast.makeText(mActivity.getBaseContext(),"Download Success, Check Gallery",Toast.LENGTH_SHORT).show();




                            } catch(Exception e){
                                // some action
                                Toast.makeText(mActivity.getBaseContext(),"Download Failed" + e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onBitmapFailed(Drawable errorDrawable) {

                        }

                        @Override
                        public void onPrepareLoad(Drawable placeHolderDrawable) {

                        }
                    });


                }
            });
//            imageView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    DownloadDialog dd = new DownloadDialog();
//                    //dd.show(,"Dialog");
//                    return true;
//                }
//            });



            //photoID.setText(urls.getRegularPhotoUrl());








//            Glide.with(mActivity)
//                    .load(urls.getSmallPhotoUrl())
//                    .into(imageView);
            Picasso.with(mActivity)
                    .load(urls.getSmallPhotoUrl())


                    .into(imageView);




        }
    }

    static class NetworkStateItemViewHolder extends RecyclerView.ViewHolder {

        private final ProgressBar progressBar;
        private final TextView errorMsg;
        private Button button;

        public NetworkStateItemViewHolder(View itemView, final ListItemClickListener listItemClickListener) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progress_bar);
            errorMsg = itemView.findViewById(R.id.error_msg);
            button = itemView.findViewById(R.id.retry_button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listItemClickListener.onRetryClick(view, getAdapterPosition());
                    Log.d("REtry RV Adater", getAdapterPosition() + " ");
                }
            });
        }
        public void bindView(NetworkState networkState) {
            if (networkState != null && networkState.getStatus() == Status.RUNNING) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }

            if (networkState != null && networkState.getStatus() == Status.FAILED) {
                errorMsg.setVisibility(View.VISIBLE);
                errorMsg.setText(networkState.getMsg());
            } else {
                errorMsg.setVisibility(View.GONE);
            }
        }
    }


}
