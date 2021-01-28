package pers.owen.firstcode.bean

public class Msg(val content: String, val type: Int){
    companion object {
        const val type_received = 0
        const val type_send = 1
    }
}
