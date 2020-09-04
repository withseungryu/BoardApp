package com.example.login.Register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.login.Login.LoginActivity
import com.example.login.R
import com.example.login.Retrifit.ConnectRetrofit
import kotlinx.android.synthetic.main.activity_login.btn_register
import kotlinx.android.synthetic.main.activity_login.et_id
import kotlinx.android.synthetic.main.activity_login.et_password
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) { //엑티비티 실행시 처음으로 실행되는 생명주기
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        btn_register.setOnClickListener{
            val textId = et_id.text.toString()
            val textPassword = et_password.text.toString()
            val textName = et_name.text.toString()
            val textAge = et_age.text.toString()

            ConnectRetrofit.retrofitService().requestRegister(textId,textPassword,textName,textAge).enqueue(object:Callback<Register>{

                override fun onFailure(call: Call<Register>, t: Throwable) {
                    val dialog = AlertDialog.Builder(this@RegisterActivity)
                    dialog.setTitle("실패!")
                    dialog.setMessage("회원가입에 실패 하셨습니다.")
                    dialog.show()
                }

                override fun onResponse(call: Call<Register>, response: Response<Register>) {
                    val register = response.body()

                    val dialog = AlertDialog.Builder(this@RegisterActivity)

                    if (register?.code == "0000"){
                        dialog.setTitle("회원가입을 축하드립니다.")
                        dialog.setMessage("code : " + register?.code + ",  msg: "+ register?.msg)
                        dialog.show()
                        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                        intent.putExtra("userId", textId)
                        startActivity(intent)
                    }
                    else if(register?.code =="2002"){
                        dialog.setTitle("이미 존재하는 아이디 입니다.")
                        dialog.setMessage("code : " + register?.code + ",  msg: "+ register?.msg)
                        dialog.show()
                    }
                }

            })
        }

        btn_loginPage.setOnClickListener{
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}