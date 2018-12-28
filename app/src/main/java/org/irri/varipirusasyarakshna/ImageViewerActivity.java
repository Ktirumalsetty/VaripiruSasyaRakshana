package org.irri.varipirusasyarakshna;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ImageViewerActivity.this,DetailsActivity.class).putExtra("detail_page_type",mDriveItem.getItemType()));
            }
        });
//        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
//                android.R.anim.fade_out);
//        fragmentTransaction
//                .replace(R.id.frame, ImageFragment.newInstance(mDriveItem,imageTransitionName), "ImageViewer");
//        fragmentTransaction.commitAllowingStateLoss();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                supportFinishAfterTransition();

//                finish();
                return true;

            case R.id.action_home:

                Intent i = new Intent(this, HomeDrawerActivity.class);
                // Closing all the Activities
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);

                finish();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
