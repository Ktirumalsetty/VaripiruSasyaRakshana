package org.irri.varipirusasyarakshna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.irri.varipirusasyarakshna.model.MethdodsSource;

public class PiruVividhaDasaluDetailedActivity extends AppCompatActivity {

    int mDetailPageType;
    Toolbar toolbar;
    HowToIdentifyFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piru_vividha_dasalu_detailed);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        toolbar.setTitle(R.string.label_sudi_tegulu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDetailPageType = getIntent().getIntExtra("detail_page_type", -1);
        setPageTitle();
        if (findViewById(R.id.frame) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            if (mDetailPageType == MethdodsSource.AROGYA_PANTA_SARINA_MANDULU) {
                fragment = HowToIdentifyFragment.newInstance(mDetailPageType, "PiruDasalu");
            } else {
                fragment = HowToIdentifyFragment.newInstance(mDetailPageType, "AROGYA_PANTA_SARINA_MANDULU");
            }
            // Create a new Fragment to be placed in the activity layout


            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
//            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame, fragment).commit();
        }
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
            case MethdodsSource.NAARU_MADI:
                toolbar.setTitle(R.string.label_naru_madi);
                break;
            case MethdodsSource.PILAKA_DASA:
                toolbar.setTitle(R.string.label_pilaka_dasa);
                break;
            case MethdodsSource.ANKURAMU_NUNDI:
                toolbar.setTitle(R.string.label_ankuramu_nundi);
                break;
            case MethdodsSource.NAATINA_POLAMU:
                toolbar.setTitle(R.string.label_natina_polam);
                break;
            case MethdodsSource.AROGYA_PANTA_SARINA_MANDULU:
                toolbar.setTitle(R.string.label_sarina_mandula_misramalu);
                break;
            case MethdodsSource.BAKANE_THEGULU:
                toolbar.setTitle(R.string.label_bakane_thegulu);
                break;
            case MethdodsSource.KANDAMU_KULLU_THEGULU:
                toolbar.setTitle(R.string.label_kandam_kullu_tegulu);
                break;
            case MethdodsSource.VARIGINJA_MARPU_THEGULU:
                toolbar.setTitle(R.string.label_variginja_marpu_tegulu);
                break;
            case MethdodsSource.NATRAJANI_LOPAM:
                toolbar.setTitle(R.string.label_natrajani_lopam);
                break;
            case MethdodsSource.BHASWARAM_LOPAM:
                toolbar.setTitle(R.string.label_bhaswaram_lopam);
                break;
            case MethdodsSource.POTASSIUM_LOPAM:
                toolbar.setTitle(R.string.label_potassium_lopam);
                break;
            case MethdodsSource.GANDHAKAM_LOPAM:
                toolbar.setTitle(R.string.label_gandhakam_lopam);
                break;
            case MethdodsSource.ZYNC_LOPAM:
                toolbar.setTitle(R.string.label_zink_lopam);
                break;
            case MethdodsSource.INUMU_LOPAM:
                toolbar.setTitle(R.string.label_inumu_lopam);
                break;
            case MethdodsSource.CHOWDU_NELALU_LOPAM:
                toolbar.setTitle(R.string.label_choudu_lopam);
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
}
