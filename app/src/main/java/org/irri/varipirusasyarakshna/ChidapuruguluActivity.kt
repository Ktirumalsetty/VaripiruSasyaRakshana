package org.irri.varipirusasyarakshna

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import org.irri.varipirusasyarakshna.R.id.toolbar

class ChidapuruguluActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chidapurugulu)
//        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        /*var ll_menu_item_one = findViewById(R.id.ll_menu_one) as LinearLayout
        ll_menu_item_one.set*/
       /* fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }*/
    }

    fun onClickMenuItemOne(view: View?){
        var intent = Intent(this,DetailsActivity::class.java)
        startActivity(intent)

    }
}
