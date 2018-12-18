package org.irri.varipirusasyarakshna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.irri.varipirusasyarakshna.model.MethdodsSource;

public class PoshakaLopaluMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_poshaka_lopalu_menu);

        findViewById(R.id.ll_natrajani_lopam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PoshakaLopaluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.SUDI_THEGULU));
            }
        });

        findViewById(R.id.ll_bhaswaram_lopam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PoshakaLopaluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.THATAKU_THEGULU));
            }
        });
        findViewById(R.id.ll_potassium_lopam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PoshakaLopaluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.KAMPU_NALLI));
            }
        });
        findViewById(R.id.ll_gandhakam_lopam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PoshakaLopaluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.KANDAMU_THOLUCHU_PURUGU));
            }
        });

        findViewById(R.id.ll_zink_lopam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PoshakaLopaluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.GOTTAPU_ROGAM));
            }
        });
        findViewById(R.id.ll_inumu_lopam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PoshakaLopaluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.THELLA_ROGAM));
            }
        });
        findViewById(R.id.ll_choudu_lopam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PoshakaLopaluMenuActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.AAKU_NALLI));
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
