package org.irri.varipirusasyarakshna.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.irri.varipirusasyarakshna.R;
import org.irri.varipirusasyarakshna.model.GeneralItem;
import org.irri.varipirusasyarakshna.model.ImageTypeItem;
import org.irri.varipirusasyarakshna.model.KanipincheLakshanaluItem;
import org.irri.varipirusasyarakshna.model.ListItem;
import org.irri.varipirusasyarakshna.model.MethdodsSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KTirumalsetty on 10/30/2017.
 */

public class LakshanaluMediaStickyHeaderAdapter extends SelectableAdapter<RecyclerView.ViewHolder> {

    private static final String TAG = "LakshanaluMediaStickyHeaderAdapter";
//    private final ArrayList<ListItem> mDriveItems;
    private final List<KanipincheLakshanaluItem> mDriveItems;
    private final Context mContext;
//    ChatApplication mChatApplication;
//    public LakshanaluMediaStickyHeaderAdapter(Context context, ArrayList<ListItem> homeList) {
//        this.mContext = context;
//        this.mDriveItems = homeList;
////        mChatApplication = (ChatApplication) ((Activity)context).getApplication();
//    }
    public LakshanaluMediaStickyHeaderAdapter(Context context, List<KanipincheLakshanaluItem> homeList) {
        this.mContext = context;
        this.mDriveItems = homeList;
//        mChatApplication = (ChatApplication) ((Activity)context).getApplication();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        public final ImageView mImageView;

        public MyViewHolder(View view) {
            super(view);

            mImageView = (ImageView) view.findViewById(R.id.imageView);

        }
    }
    class DateViewHolder extends RecyclerView.ViewHolder {
        private final TextView mHeaderLabel;

        public DateViewHolder(View view) {
            super(view);
            mHeaderLabel = (TextView) view.findViewById(R.id.label);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v1 = inflater.inflate(R.layout.lakshanalu_media_list_item, parent, false);
                viewHolder = new MyViewHolder(v1);
//        switch (viewType) {
//
//            case ListItem.TYPE_GENERAL:
//                View v1 = inflater.inflate(R.layout.lakshanalu_media_list_item, parent,
//                        false);
//                viewHolder = new MyViewHolder(v1);
//                break;
//
//            case ListItem.TYPE_IMAGE_CATEGORY:
//                View v2 = inflater.inflate(R.layout.lakshanalu_media_row_header, parent, false);
//                viewHolder = new DateViewHolder(v2);
//                break;
//        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        KanipincheLakshanaluItem item = (KanipincheLakshanaluItem) mDriveItems.get(position);
        MyViewHolder generalViewHolder = (MyViewHolder) viewHolder;
        populateGeneralView(item,generalViewHolder,position);
//        switch (viewHolder.getItemViewType()) {
//
//            case ListItem.TYPE_GENERAL:
//
//                GeneralItem generalItem = (GeneralItem) mDriveItems.get(position);
//                MyViewHolder generalViewHolder = (MyViewHolder) viewHolder;
//                populateGeneralView(generalItem.getLakshanaluItem(),generalViewHolder,position);
//                break;
//
//            case ListItem.TYPE_IMAGE_CATEGORY:
//                ImageTypeItem dateItem
//                        = (ImageTypeItem) mDriveItems.get(position);
//                DateViewHolder dateViewHolder = (DateViewHolder) viewHolder;
//
//                // Populate date item data here
//                populateDateView(dateItem,dateViewHolder);
//                break;
//        }


    }

//    @Override
//    public int getItemViewType(int position) {
//        return mDriveItems.get(position).getType();
//    }

    @Override
    public int getItemCount() {
        return mDriveItems.size();
    }

    void populateDateView(ImageTypeItem dateItem, DateViewHolder dateViewHolder){

        switch (dateItem.getItemType()) {

            case MethdodsSource.SUDI_THEGULU:
                dateViewHolder.mHeaderLabel.setText(R.string.label_sudi_tegulu);

                break;
            case MethdodsSource.THATAKU_THEGULU:
                dateViewHolder.mHeaderLabel.setText(R.string.label_tataku_tegulu);
                break;
            case MethdodsSource.KAMPU_NALLI:
                dateViewHolder.mHeaderLabel.setText(R.string.label_kampu_nalli);
                break;
            case MethdodsSource.THELLA_ROGAM:
                dateViewHolder.mHeaderLabel.setText(R.string.label_tella_rogamu);
                break;
            case MethdodsSource.GOTTAPU_ROGAM:
                dateViewHolder.mHeaderLabel.setText(R.string.label_gottapu_rogam);
                break;
            case MethdodsSource.KANDAMU_THOLUCHU_PURUGU:
                dateViewHolder.mHeaderLabel.setText(R.string.label_kandamu_toluchu_purugu);
                break;
            case MethdodsSource.AAKU_NALLI:
                dateViewHolder.mHeaderLabel.setText(R.string.label_aaku_nalli);
                break;
            case MethdodsSource.AGGI_THEGULU:
                dateViewHolder.mHeaderLabel.setText(R.string.label_aggi_thegulu);
                break;
            case MethdodsSource.PAAMU_PODA_THEGULU:
                dateViewHolder.mHeaderLabel.setText(R.string.label_pamu_poda_tegulu);
                break;
            case MethdodsSource.GODHUMA_RANGU_AAKU_MACHA_THEGULU:
                dateViewHolder.mHeaderLabel.setText(R.string.label_godhuma_akumacha__thegulu);
                break;
            case MethdodsSource.POTTA_KULLU_THEGULU:
                dateViewHolder.mHeaderLabel.setText(R.string.label_potta_kullu_tegulu);
                break;
            case MethdodsSource.MAANI_PANDU_THEGULU:
                dateViewHolder.mHeaderLabel.setText(R.string.label_mani_pandu_thegulu);
                break;
            case MethdodsSource.BACTERIA_AAKU_ENDU_THEGULU:
                dateViewHolder.mHeaderLabel.setText(R.string.label_bacteria_endu_thegulu);
                break;
            case MethdodsSource.TUNGRO_VIRUS_THEGULU:
                dateViewHolder.mHeaderLabel.setText(R.string.label_tungro_virus_tegulu);
                break;
            case MethdodsSource.VOODA_KALUPU_MOKKA:
                dateViewHolder.mHeaderLabel.setText(R.string.label_vooda);
                break;
            case MethdodsSource.THUNGA_JAATHI:
                dateViewHolder.mHeaderLabel.setText(R.string.label_thunga);
                break;
            case MethdodsSource.VEDALPAKU_KALUPU:
                dateViewHolder.mHeaderLabel.setText(R.string.label_vedalpaku_kalupu);
                break;
            case MethdodsSource.NEETI_KALUPU:
                dateViewHolder.mHeaderLabel.setText(R.string.label_neti_kalupu);
                break;
                default:
                    dateViewHolder.mHeaderLabel.setText("UnKnown");

        }
//        dateViewHolder.mHeaderLabel.setText(""+dateItem.getItemType());
    }

    void populateGeneralView(KanipincheLakshanaluItem driveItem,MyViewHolder holder,int position){
        ViewCompat.setTransitionName(holder.mImageView, "transition"+position);
        String mediaUrlDecoded = "";
//        holder.mImageView.setImageResource(driveItem.getImageResID());
        Glide.with(mContext)
                .load(driveItem.getImageResID())
                .into(holder.mImageView);

    }
}
