package org.irri.varipirusasyarakshna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ThegulluMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thegullu_menu);
        findViewById(R.id.ll_aggi_tegulu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
