package com.example.login.Board

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.login.R
import kotlinx.android.synthetic.main.new_board.*

class NewBoard:AppCompatActivity {
    companion object{
        val EXTRA_TITLE = "TITLE"
        val EXTRA_BODY = "BODY"
    }
    constructor():super()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_board)

        add_button.setOnClickListener(object:View.OnClickListener {
            override fun onClick(p0: View?) {
                val outdata = Intent()
                outdata.putExtra(EXTRA_TITLE,mtitle.text.toString())
                outdata.putExtra(EXTRA_BODY,mbody.text.toString())
                setResult(Activity.RESULT_OK, outdata)
                finish()
            }
        })
    }
}