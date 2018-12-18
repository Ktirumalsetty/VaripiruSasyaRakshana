package org.irri.varipirusasyarakshna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.irri.varipirusasyarakshna.model.MethdodsSource;

public class ChidapuruguluMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_chidapurugulu_menu);
        findViewById(R.id.ll_sudi_tegulu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChidapuruguluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.SUDI_THEGULU));
            }
        });

        findViewById(R.id.ll_thataku_thegulu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChidapuruguluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.THATAKU_THEGULU));
            }
        });
        findViewById(R.id.ll_kampu_nalli).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChidapuruguluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.KAMPU_NALLI));
            }
        });
        findViewById(R.id.ll_kandamu_tholuchu_pur).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChidapuruguluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.KANDAMU_THOLUCHU_PURUGU));
            }
        });

        findViewById(R.id.ll_gottapu_rogamu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChidapuruguluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.GOTTAPU_ROGAM));
            }
        });
        findViewById(R.id.ll_thella_rogamu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChidapuruguluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.THELLA_ROGAM));
            }
        });
        findViewById(R.id.ll_aaku_nalli).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChidapuruguluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.AAKU_NALLI));
            }
        });
        findViewById(R.id.ll_rellu_ralchu_purugu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChidapuruguluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.RELLU_RALCHU_PURUGU));
            }
        });

        findViewById(R.id.ll_gottapu_purugu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChidapuruguluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.GOTTAPU_PURUGU));
            }
        });

        findViewById(R.id.ll_horl_magget).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChidapuruguluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.HORD_MAGGET));
            }
        });
        findViewById(R.id.ll_thamara_purugu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChidapuruguluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.THAMARA_PURUGULU));
            }
        });

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
