package org.irri.varipirusasyarakshna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import org.irri.varipirusasyarakshna.model.KanipincheLakshanaluItem;

public class HomeMenuActivity extends AppCompatActivity {

    LinearLayout llChidaPurugulu,llThegullu,llVividhaDasalu,llKalupuMokkalu,llLakshanalu,llPoshakaLopalu;
    private Button btnTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        llChidaPurugulu = findViewById(R.id.ll_chida_purugulu);
        llThegullu = findViewById(R.id.ll_tegullu);
        llVividhaDasalu = findViewById(R.id.ll_vividha_dasalu);
//        llArogyaPanta = findViewById(R.id.ll_arogya_panta);
        llKalupuMokkalu = findViewById(R.id.ll_kalupu_mokkalu);
        llLakshanalu = findViewById(R.id.ll_kanipinche_lakshanalu);
        llPoshakaLopalu = findViewById(R.id.ll_poshaka_lopalu);

        llChidaPurugulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeMenuActivity.this,ChidapuruguluMenuActivity.class));
            }
        });

        llThegullu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeMenuActivity.this,ThegulluMenuActivity.class));
            }
        });

        llKalupuMokkalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeMenuActivity.this,KalupuMokkaluActivity.class));
            }
        });

        llVividhaDasalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeMenuActivity.this,VividhaDasaluMenuActivity.class));
            }
        });
        llLakshanalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeMenuActivity.this,LakshanaluMenuActivity.class));
            }
        });
        llPoshakaLopalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeMenuActivity.this,PoshakaLopaluMenuActivity.class));
            }
        });

//        btnTeam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HomeMenuActivity.this,TeamMembersActivity.class));
//            }
//        });




    }
}
