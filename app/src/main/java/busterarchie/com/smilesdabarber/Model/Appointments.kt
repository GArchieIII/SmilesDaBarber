package busterarchie.com.smilesdabarber.Model

/**
 * Created by Buster on 10/17/2018.
 */
class Appointments {


    var clientId:String = ""
    var Style:String = ""
    var contactNumber:String = ""


    constructor(clientId:String,Style:String,contactNumber:String){

        this.clientId=clientId
        this.Style=Style
        this.contactNumber=contactNumber

    }

    constructor()

}