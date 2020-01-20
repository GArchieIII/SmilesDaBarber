package busterarchie.com.smilesdabarber.Adapters

import android.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import busterarchie.com.smilesdabarber.Fragments.ClientNotificationFragment
import busterarchie.com.smilesdabarber.Fragments.TodaysCutsFragment

class SectionPagerAdapter(fm: FragmentManager):FragmentPagerAdapter(fm){
    override fun getItem(position: Int): android.support.v4.app.Fragment {
        when(position){

            0->  {return ClientNotificationFragment()}
            1-> {return TodaysCutsFragment()
            }
        }
        return null!!
    }

    override fun getCount(): Int {
        return 2

    }
}