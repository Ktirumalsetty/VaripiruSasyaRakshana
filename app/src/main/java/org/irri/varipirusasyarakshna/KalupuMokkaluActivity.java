package org.irri.varipirusasyarakshna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.irri.varipirusasyarakshna.model.MethdodsSource;

public class KalupuMokkaluActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_kalupu_mokkalu);
        findViewById(R.id.ll_vooda).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KalupuMokkaluActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.VOODA_KALUPU_MOKKA));
            }
        });

        findViewById(R.id.ll_menu_thunga).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KalupuMokkaluActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.THUNGA_JAATHI));
            }
        });
        findViewById(R.id.ll_menu_vedalpaku_kalupu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KalupuMokkaluActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.VEDALPAKU_KALUPU));
            }
        });
        findViewById(R.id.ll_menu_neti_kalupu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KalupuMokkaluActivity.this,DetailsActivity.class).putExtra("detail_page_type",MethdodsSource.NEETI_KALUPU));
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
