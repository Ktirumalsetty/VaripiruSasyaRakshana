package org.irri.varipirusasyarakshna;

import android.content.Intent;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import org.irri.varipirusasyarakshna.model.MethdodsSource;


public class DetailsActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private TabItem mTabItem1;
    private TabItem mTabItem2;
    private TabLayout mTabLayout;

    int mDetailPageType;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        toolbar.setTitle(R.string.label_sudi_tegulu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setContentInsetsAbsolute(0, 0);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mDetailPageType = getIntent().getIntExtra("detail_page_type", -1);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabItem1 = (TabItem) findViewById(R.id.tabItem);
        mTabItem2 = (TabItem) findViewById(R.id.tabItem2);
        setPageTitle();
        // Set up the ViewPager with the sections adapter.

        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }

    private void setPageTitle() {
        switch (mDetailPageType) {

            case MethdodsSource.SUDI_THEGULU:
                toolbar.setTitle(R.string.label_sudi_tegulu);

                break;
            case MethdodsSource.THATAKU_THEGULU:
                toolbar.setTitle(R.string.label_tataku_tegulu);
                break;
            case MethdodsSource.KAMPU_NALLI:
                toolbar.setTitle(R.string.label_kampu_nalli);
                break;
            case MethdodsSource.THELLA_ROGAM:
                toolbar.setTitle(R.string.label_tella_rogamu);
                break;
            case MethdodsSource.GOTTAPU_ROGAM:
                toolbar.setTitle(R.string.label_gottapu_rogam);
                break;
            case MethdodsSource.KANDAMU_THOLUCHU_PURUGU:
                toolbar.setTitle(R.string.label_kandamu_toluchu_purugu);
                break;
            case MethdodsSource.AAKU_NALLI:
                toolbar.setTitle(R.string.label_aaku_nalli);
                break;
            case MethdodsSource.AGGI_THEGULU:
                toolbar.setTitle(R.string.label_aggi_thegulu);
                break;
            case MethdodsSource.PAAMU_PODA_THEGULU:
                toolbar.setTitle(R.string.label_pamu_poda_tegulu);
                break;
            case MethdodsSource.GODHUMA_RANGU_AAKU_MACHA_THEGULU:
                toolbar.setTitle(R.string.label_godhuma_akumacha__thegulu);
                break;
            case MethdodsSource.POTTA_KULLU_THEGULU:
                toolbar.setTitle(R.string.label_potta_kullu_tegulu);
                break;
            case MethdodsSource.MAANI_PANDU_THEGULU:
                toolbar.setTitle(R.string.label_mani_pandu_thegulu);
                break;
            case MethdodsSource.BACTERIA_AAKU_ENDU_THEGULU:
                toolbar.setTitle(R.string.label_bacteria_endu_thegulu);
                break;
            case MethdodsSource.TUNGRO_VIRUS_THEGULU:
                toolbar.setTitle(R.string.label_tungro_virus_tegulu);
                break;
            case MethdodsSource.VOODA_KALUPU_MOKKA:
                toolbar.setTitle(R.string.label_vooda);
                break;
            case MethdodsSource.THUNGA_JAATHI:
                toolbar.setTitle(R.string.label_thunga);
                break;
            case MethdodsSource.VEDALPAKU_KALUPU:
                toolbar.setTitle(R.string.label_vedalpaku_kalupu);
                break;
            case MethdodsSource.NEETI_KALUPU:
                toolbar.setTitle(R.string.label_neti_kalupu);
                break;
            case MethdodsSource.KANKI_NALLI:
                toolbar.setTitle(R.string.label_kanki_nalli);
                break;
            case MethdodsSource.GOTTAPU_PURUGU:
                toolbar.setTitle(R.string.label_gottapu_purugu);
                break;
            case MethdodsSource.HORD_MAGGET:
                toolbar.setTitle(R.string.label_hord_magget);
                break;
            case MethdodsSource.THAMARA_PURUGULU:
                toolbar.setTitle(R.string.label_thamara_purugulu);
                break;
            case MethdodsSource.RELLU_RALCHU_PURUGU:
                toolbar.setTitle(R.string.label_rellu_ralchu);
                break;
            case MethdodsSource.GADDI_JATHULU:
                toolbar.setTitle(R.string.label_gaddi_jathulu);
                break;
            case MethdodsSource.AROGYA_PANTA_DOS_DONTS:
                toolbar.setTitle(R.string.label_dos_donts);
                mTabLayout.getTabAt(0).setText(getString(R.string.label_dos));
                mTabLayout.getTabAt(1).setText(getString(R.string.label_donts));

                break;

        }
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

                finish();
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

//    /**
//     * A placeholder fragment containing a simple view.
//     */
//    public static class PlaceholderFragment extends Fragment {
//        /**
//         * The fragment argument representing the section number for this
//         * fragment.
//         */
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        public PlaceholderFragment() {
//        }
//
//        /**
//         * Returns a new instance of this fragment for the given section
//         * number.
//         */
//        public static PlaceholderFragment newInstance(int sectionNumber) {
//            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_details, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
//            return rootView;
//        }
//    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
//            return PlaceholderFragment.newInstance(position + 1);
            switch (position) {
                case 0:
                    return HowToIdentifyFragment.newInstance(mDetailPageType, "");

                case 1:
                    return ProprietaryMethodsFragment.newInstance(mDetailPageType, "");

            }
            return null;

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }
    }
}
