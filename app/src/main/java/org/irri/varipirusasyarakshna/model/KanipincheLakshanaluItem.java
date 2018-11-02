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
        return removeLastOcc(imageName);
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

    private String removeLastOcc(String imagName){
        String result;
       int lastOccPos = imagName.lastIndexOf("_");
       if (lastOccPos != -1){
           result = imagName.substring(0,lastOccPos);
       }else{
           result = imagName;
       }
       return  result;
    }
}
