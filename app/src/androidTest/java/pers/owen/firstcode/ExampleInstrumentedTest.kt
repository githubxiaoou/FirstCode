package pers.owen.firstcode

import android.content.Intent
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("pers.owen.firstcode", appContext.packageName)

        // 举例1:标准函数的使用举例
        val intent = Intent(appContext, MainActivity::class.java).apply {
            putExtra("param1", "data1")
            putExtra("param2", "data2")
        }
        appContext.startActivity(intent)
    }
}