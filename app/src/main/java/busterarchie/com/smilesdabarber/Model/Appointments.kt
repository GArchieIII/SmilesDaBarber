package busterarchie.com.smilesdabarber.Model

/**
 * Created by Buster on 10/17/2018.
 */
class Appointments {

    var clientId:String = ""
    var appointTime:String = ""
    var appointDate:String = ""
    var Style:String = ""


    constructor(clientId:String,appointtime:String,appointDate:String,Style:String){

        this.clientId=clientId
        this.appointTime=appointTime
        this.appointDate=appointDate
        this.Style=Style

    }

}