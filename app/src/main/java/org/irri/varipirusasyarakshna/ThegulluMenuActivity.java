package org.irri.varipirusasyarakshna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import org.irri.varipirusasyarakshna.model.MethdodsSource;

public class ThegulluMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_thegullu_menu);

        findViewById(R.id.ll_aggi_tegulu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThegulluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.AGGI_THEGULU));
            }
        });
        findViewById(R.id.ll_pamu_poda_thegulu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThegulluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.PAAMU_PODA_THEGULU));
            }
        });
        findViewById(R.id.ll_menu_godhuma_akumacha).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThegulluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.GODHUMA_RANGU_AAKU_MACHA_THEGULU));
            }
        });
        findViewById(R.id.ll_menu_potta_kullu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThegulluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.POTTA_KULLU_THEGULU));
            }
        });
        findViewById(R.id.ll_menu_mani_pandu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThegulluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.MAANI_PANDU_THEGULU));
            }
        });
        findViewById(R.id.ll_menu_bac_endu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThegulluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.BACTERIA_AAKU_ENDU_THEGULU));
            }
        });
        findViewById(R.id.ll_menu_tungro).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThegulluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.TUNGRO_VIRUS_THEGULU));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
