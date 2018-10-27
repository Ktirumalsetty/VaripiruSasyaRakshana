package org.irri.varipirusasyarakshna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class TeamMembersActivity extends AppCompatActivity {

    String style = " <body style=\"text-align:justify;color:black;font-size:100%;\">";

    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_members);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mWebView = findViewById(R.id.webview);

        if (mWebView != null)
            mWebView.loadData(style + getString(R.string.team_members) + "</body>", "text/html; charset=utf-8", "utf-8");

    }


}
