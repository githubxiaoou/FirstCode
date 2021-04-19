package pers.owen.firstcode

import android.widget.Toast
import org.junit.Test
import pers.owen.firstcode.c12Test.showToast

class C12AndroidTest: ExampleInstrumentedTest() {

    @Test
    fun test2() {
        "This is Toast".showToast(context)
        R.string.app_name.showToast(context, Toast.LENGTH_LONG)
    }
}