package neoncore.com.lablae.api.models;

import java.util.ArrayList;

/**
 * Created by Musa on 1/5/2018.
 */

public class PhotoResp {
    private ArrayList<PhotoObjects> photoObjects;

    public PhotoResp(ArrayList<PhotoObjects> photoObjects) {
        this.photoObjects = photoObjects;
    }

    public ArrayList<PhotoObjects> getPhotoObjects() {
        return photoObjects;
    }


}
