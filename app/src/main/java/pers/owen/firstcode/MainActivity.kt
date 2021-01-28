package pers.owen.firstcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pers.owen.firstcode.bean.Msg

class MainActivity : AppCompatActivity() {

    // lateinit延迟初始化
    private lateinit var msg: Msg

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 如果用lateinit延迟初始化一定要保证在各处调用之前都已经完成了初始化操作
        if (!::msg.isInitialized) {// 判断是否已经初始化
            msg = Msg("lala", 1)
        }

    }
}