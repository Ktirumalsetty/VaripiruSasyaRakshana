package org.irri.varipirusasyarakshna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.irri.varipirusasyarakshna.model.MethdodsSource;

public class VividhaDasaluMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_vividha_dasalu_menu);

        findViewById(R.id.ll_menu_naru_madi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VividhaDasaluMenuActivity.this,PiruVividhaDasaluDetailedActivity.class).putExtra("detail_page_type",MethdodsSource.NAARU_MADI));
            }
        });
        findViewById(R.id.ll_menu_pilaka_dasa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VividhaDasaluMenuActivity.this,PiruVividhaDasaluDetailedActivity.class).putExtra("detail_page_type",MethdodsSource.PILAKA_DASA));
            }
        });
        findViewById(R.id.ll_menu_ankuramu_nundi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VividhaDasaluMenuActivity.this,PiruVividhaDasaluDetailedActivity.class).putExtra("detail_page_type",MethdodsSource.ANKURAMU_NUNDI));
            }
        });
        findViewById(R.id.ll_menu_natina_polam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VividhaDasaluMenuActivity.this,PiruVividhaDasaluDetailedActivity.class).putExtra("detail_page_type",MethdodsSource.NAATINA_POLAMU));
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
