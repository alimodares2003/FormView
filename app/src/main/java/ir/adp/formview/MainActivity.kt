package ir.adp.formview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationIcon(R.drawable.ic_close)

        fv.errorText = "is required"

        fv.setOnSubmitClickListener {
            val et = et.getText()
            val et1 = et1.getText()
            val et2 = et2.getText()
            val et3 = et3.getText()
            Toast.makeText(this, "$et $et1 $et2 $et3", Toast.LENGTH_LONG).show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        fv.onNavigationItemSelected(menu){
            val et = et.getText()
            val et1 = et1.getText()
            val et2 = et2.getText()
            val et3 = et3.getText()
            Toast.makeText(this, "$et $et1 $et2 $et3", Toast.LENGTH_LONG).show()
        }
        return true
    }
}
