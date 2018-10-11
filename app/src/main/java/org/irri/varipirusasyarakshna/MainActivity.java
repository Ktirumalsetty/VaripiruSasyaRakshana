package org.irri.varipirusasyarakshna;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewContent;
    private WebView mWebView;
    private ImageView mImageViewOne, mImageViewTwo,mImageViewThree,mImageViewFour;
    String style = " <body style=\"text-align:justify;color:black;font-size:120%;\">";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        mTextViewContent = findViewById(R.id.tv_content);
        mWebView = findViewById(R.id.webview);
        mImageViewOne = findViewById(R.id.image1);

        mTextViewContent.setText(Html.fromHtml(getResources().getString(R.string.rice_protection)));
       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        loadContent(R.string.rice_protection);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mImageViewOne.setImageDrawable(getResources().getDrawable(R.drawable.rice_protection));
            }
        }, 1000);
    }

    private void loadContent(int content) {
        if (mWebView != null)
            mWebView.loadData(style + getString(content) + "</body>", "text/html; charset=utf-8", "utf-8");

    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
