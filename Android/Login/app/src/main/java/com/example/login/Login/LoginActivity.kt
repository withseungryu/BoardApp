package com.example.login.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.login.MainPage.MainActivity
import com.example.login.R
import com.example.login.Register.RegisterActivity
import com.example.login.Retrifit.ConnectRetrofit
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //로그인 버튼을 눌럿을 경
        btn_loginPage.setOnClickListener{
            val textId = et_id.text.toString()
            val textPw = et_password.text.toString()

            ConnectRetrofit.retrofitService().requestLogin(textId, textPw).enqueue(object : Callback<Login>{

                override fun onFailure(call: Call<Login>, t: Throwable) {
                    //웹 통신에 실패 했을 실행된다

                    val dialog = AlertDialog.Builder(this@LoginActivity)
                    dialog.setTitle("실패!")
                    dialog.setMessage("로그인에 실패 하셨습니다.")
                    dialog.show()

                }

                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    //응답값을 성공적으로 받아왔을 경우 실행된다
                    val login = response.body() //서버에서 응답으로 받아온 code와 msg

                    val dialog = AlertDialog.Builder(this@LoginActivity)


                    Log.d("test", login?.code.toString())
                    if (login?.code == "0000"){
                        dialog.setTitle("로그인 성공!")
                        dialog.setMessage("code : " + login?.code + ",  msg: "+ login?.msg)
                        dialog.show()
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.putExtra("userId", textId)
                        intent.putExtra("userPassword", textPw)
                        startActivity(intent)
                    }
                    else{
                        dialog.setTitle("아이디와 비밀번호를 확인하십시오.!")
                        dialog.setMessage("code : " + login?.code + ",  msg: "+ login?.msg)
                        dialog.show()
                    }
                }
            })
        }

        //회원가입 버튼을 눌렀을 경우, RegisterActivity로 이동
        btn_register.setOnClickListener{
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }


    }
}