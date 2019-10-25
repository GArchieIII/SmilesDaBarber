package busterarchie.com.smilesdabarber.Model

/**
 * Created by Buster on 10/17/2018.
 */
class Client {

    private var clientUID:String=""
    var clientName:String=""
    var clientPhone:String=""
    var clientEmail:String=""
    var clientPassword:String = ""
     var clientPhotoUrl:String=""

    constructor(clientName:String,clientPhone:String,clientEmail:String,clientPassword:String){

        this.clientName=clientName
        this.clientPhone = clientPhone
        this.clientEmail = clientEmail
        this.clientPassword = clientPassword


    }

    constructor()

    fun GetClientName():String{

        return clientName


    }



}