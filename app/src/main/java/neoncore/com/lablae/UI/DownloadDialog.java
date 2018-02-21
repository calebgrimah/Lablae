package neoncore.com.lablae.UI;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import neoncore.com.lablae.R;

/**
 * Created by Musa on 1/9/2018.
 */

public class DownloadDialog extends DialogFragment  {


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.pick_download_option)
                .setItems(getUrls(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        switch (which){
                            case 0:
                                //create service with this url
                                break;
                            case 1:

                                break;
                            case 2:
                                break;
                        }
                    }
                });
        return builder.create();
    }

    public String[] getUrls(){
        String[] ops = {"Small", "Regular","Full"};
        return ops;
    }
}
