package pers.owen.firstcode

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

@RunWith(AndroidJUnit4::class)
class C07AndroidTest : ExampleInstrumentedTest() {

    @Test
    fun test() {
        save("lalal")
        println(load())
    }

    private fun save(inputText: String) {
        val openFileOutput = context.openFileOutput("data", Context.MODE_PRIVATE)
        val bufferedWriter = BufferedWriter(OutputStreamWriter(openFileOutput))
        bufferedWriter.use {
            it.write(inputText)
        }
    }

    private fun load(): String {
        val content = StringBuilder()
        val input = context.openFileInput("data")
        val reader = BufferedReader(InputStreamReader(input))
        println(reader.readLine())
        reader.use {
            reader.forEachLine {
                content.append(it)
            }
        }
        println(content.toString())
        return content.toString()
    }


    @Test
    fun test2() {
        context.getSharedPreferences("data", Context.MODE_PRIVATE).open {
            putString("name", "Tom")
            putInt("age", 28)
            putBoolean("married", false)
        }

        println(context.getSharedPreferences("data", Context.MODE_PRIVATE).getString("name", "666"))
    }
}