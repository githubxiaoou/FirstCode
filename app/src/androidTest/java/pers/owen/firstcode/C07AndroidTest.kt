package pers.owen.firstcode

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.core.content.contentValuesOf
import androidx.core.content.edit
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
        // 老式写法
        val edit = context.getSharedPreferences("data", Context.MODE_PRIVATE).edit()
        edit.putString("name", "Tom")
        edit.putInt("age", 28)
        edit.putBoolean("married", false)
        edit.apply()

        // 封装后的写法
        context.getSharedPreferences("data", Context.MODE_PRIVATE).open {
            putString("name", "Tom")
            putInt("age", 28)
            putBoolean("married", false)
        }

        println(context.getSharedPreferences("data", Context.MODE_PRIVATE).getString("name", "666"))

        /*该方法在KTX中已经有对应的封装方法*/
        context.getSharedPreferences("data", Context.MODE_PRIVATE).edit {
            putString("name", "Tom")
            putInt("age", 28)
            putBoolean("married", false)
        }
    }


    fun test3(db: SQLiteDatabase) {
        // 老式写法
//        var values = ContentValues()
//        values.put("name", "Game of Thrones")
//        values.put("author", "George Martin")
//        values.put("pages", 720)
//        values.put("price", 20.85)
//        db.insert("Book", null, values)

        // 封装后的写法
        val values = cvOf("name" to "Game of Thrones", "author" to "George Martin", "pages" to 720, "price" to 20.85)
        db.insert("Book", null, values)

        /*该方法在KTX中已经有对应的封装方法*/
//        val values = contentValuesOf("name" to "Game of Thrones", "author" to "George Martin", "pages" to 720, "price" to 20.85)
//        db.insert("Book", null, values)
    }


}