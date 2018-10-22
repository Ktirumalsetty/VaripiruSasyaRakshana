package org.irri.varipirusasyarakshna.model;

public class FindImage {
    int imageUrl;
    String imageName;

    public FindImage() {
    }

    public FindImage(String imageName,int imageUrl) {
        this.imageUrl = imageUrl;
        this.imageName = imageName;
    }


    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
