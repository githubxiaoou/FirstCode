package pers.owen.firstcode

import android.content.Intent
import org.junit.Test
import pers.owen.firstcode.c10test.startActivity

class C10AndroidTest : ExampleInstrumentedTest() {

    @Test
    fun test1() {
        val intent = Intent(context, TestActivity::class.java)
        context.startActivity(intent)
    }


    @Test
    fun test02() {
        startActivity<TestActivity>(context = context)

        startActivity<TestActivity>(context){
            putExtra("param1", "data")
            putExtra("param2", 123)
        }
    }


}