package org.irri.varipirusasyarakshna;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import org.irri.varipirusasyarakshna.model.KanipincheLakshanaluItem;
import org.irri.varipirusasyarakshna.utils.TouchImageView;

/**
 * The type Image viewer activity.
 */
public class ImageViewerActivity extends AppCompatActivity {

    private KanipincheLakshanaluItem mDriveItem;
    private TouchImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image_viewer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDriveItem = (KanipincheLakshanaluItem) getIntent().getSerializableExtra("DriveItemObj");
        String imageTransitionName = getIntent().getStringExtra("EXTRA_MEDIA_IMAGE_TRANSITION_NAME");
        imageView = (TouchImageView) findViewById(R.id.imageView);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && imageTransitionName!=null ) {
            imageView.setTransitionName(imageTransitionName);
        }
        setTitle(mDriveItem.getImageName());
        imageView.setImageResource(mDriveItem.getImageResID());
//        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
//                android.R.anim.fade_out);
//        fragmentTransaction
//                .replace(R.id.frame, ImageFragment.newInstance(mDriveItem,imageTransitionName), "ImageViewer");
//        fragmentTransaction.commitAllowingStateLoss();

    }
}
