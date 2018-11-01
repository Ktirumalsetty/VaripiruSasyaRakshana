package org.irri.varipirusasyarakshna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class TeamMembersActivity extends AppCompatActivity {

    String style = " <body style=\"text-align:justify;color:black;font-size:100%;\">";

    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_members);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String menuName = getIntent().getStringExtra("MenuName");
        mWebView = findViewById(R.id.webview);

        if (menuName.equals("TeamMembers")){
            getSupportActionBar().setTitle("Team Members");
            if (mWebView != null)
                mWebView.loadData(style + getString(R.string.team_members) + "</body>", "text/html; charset=utf-8", "utf-8");
        }else if (menuName.equals("Mulam")){
            getSupportActionBar().setTitle("మూలం");
            if (mWebView != null)
                mWebView.loadData(style + getString(R.string.mulam) + "</body>", "text/html; charset=utf-8", "utf-8");
        }else if (menuName.equals("Mundu_Mata")){
            getSupportActionBar().setTitle("ముందు మాట");
            if (mWebView != null)
                mWebView.loadData(style + getString(R.string.mundu_mata) + "</body>", "text/html; charset=utf-8", "utf-8");
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
