package org.irri.varipirusasyarakshna.model;

import java.io.Serializable;

public abstract class ListItem implements Serializable {

        public static final int TYPE_IMAGE_CATEGORY = 0;
        public static final int TYPE_GENERAL = 1;

        abstract public int getType();
    }