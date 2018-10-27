package org.irri.varipirusasyarakshna.model;

import java.io.Serializable;

public class KanipincheLakshanaluItem implements Serializable {

    private String imageName;
    private int imageResID;
    private int itemType;

    public KanipincheLakshanaluItem(String imageName, int imageResID, int itemType) {
        this.imageName = imageName;
        this.imageResID = imageResID;
        this.itemType = itemType;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getImageResID() {
        return imageResID;
    }

    public void setImageResID(int imageResID) {
        this.imageResID = imageResID;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}
