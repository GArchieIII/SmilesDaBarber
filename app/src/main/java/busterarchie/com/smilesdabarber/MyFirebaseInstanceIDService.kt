package busterarchie.com.smilesdabarber

import android.nfc.Tag
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

const val TAG="MyFirebase"

class MyFirebaseInstanceIDService:FirebaseInstanceIdService() {


    override fun onTokenRefresh() {

        val refreshedToken=FirebaseInstanceId.getInstance().token
        Log.d(TAG,"Token Refreshed:"+refreshedToken!!)
        super.onTokenRefresh()
    }


}