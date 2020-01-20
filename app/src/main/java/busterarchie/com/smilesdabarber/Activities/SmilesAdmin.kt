package busterarchie.com.smilesdabarber.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import busterarchie.com.smilesdabarber.Adapters.SectionPagerAdapter
import busterarchie.com.smilesdabarber.R
import kotlinx.android.synthetic.main.activity_smiles_admin.*

class SmilesAdmin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var sectionAdapter: SectionPagerAdapter?=null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smiles_admin)

        sectionAdapter=SectionPagerAdapter(supportFragmentManager)
        vpSmilesAdmin.adapter=sectionAdapter
        tlSmilesAdmin.setupWithViewPager(vpSmilesAdmin)



    }
}
