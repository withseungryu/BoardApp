package com.example.login.MainPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login.Board.BoardActivity
import com.example.login.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_id.text = intent.getStringExtra("userId")
        tv_password.text = intent.getStringExtra("userPassword")

        btn_board.setOnClickListener{
            val intent = Intent(this, BoardActivity::class.java)
            startActivity(intent)
        }
    }

}