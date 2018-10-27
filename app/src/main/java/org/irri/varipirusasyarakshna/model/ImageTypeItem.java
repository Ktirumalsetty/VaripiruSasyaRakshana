package org.irri.varipirusasyarakshna.model;

import java.io.Serializable;

public class ImageTypeItem extends ListItem implements Serializable {

        private Integer itemType;

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
        public int getType() {
            return TYPE_IMAGE_CATEGORY;
        }
    }