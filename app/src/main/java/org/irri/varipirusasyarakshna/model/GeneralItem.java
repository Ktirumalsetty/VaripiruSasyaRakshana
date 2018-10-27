package org.irri.varipirusasyarakshna.model;

import java.io.Serializable;

public class GeneralItem extends ListItem implements Serializable {

        private KanipincheLakshanaluItem lakshanaluItem;

    public KanipincheLakshanaluItem getLakshanaluItem() {
        return lakshanaluItem;
    }

    public void setLakshanaluItem(KanipincheLakshanaluItem lakshanaluItem) {
        this.lakshanaluItem = lakshanaluItem;
    }

    @Override
        public int getType() {
            return TYPE_GENERAL;
        }
    }