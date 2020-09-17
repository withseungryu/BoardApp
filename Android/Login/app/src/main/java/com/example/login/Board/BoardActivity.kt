package com.example.login.Board

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.login.R
import com.example.login.Retrifit.ConnectRetrofit
import kotlinx.android.synthetic.main.activity_board.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BoardActivity : AppCompatActivity() {

    companion object{
        const val TAG_LIST_FRAGMENT = "TAG_LIST_FRAGMENT"
        const val PICK_NEWBOARD = 1
    }
    var mBoardListFragment: BoardListFragment? = null
    val dummyBoard:MutableList<BoardRecyclerViewItem> = mutableListOf()
    val connect_server = ConnectRetrofit.retrofitService()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        val fm = supportFragmentManager
        if(savedInstanceState == null){
            val ft = fm.beginTransaction()
            mBoardListFragment = BoardListFragment()
            ft.add(R.id.main_activity_frame, mBoardListFragment!!, TAG_LIST_FRAGMENT)
            ft.commitNow()
        }
        else{
            mBoardListFragment = fm.findFragmentByTag(TAG_LIST_FRAGMENT) as BoardListFragment
        }


        connect_server.requestSearchBoard().enqueue(object:Callback<board>{
            override fun onFailure(call: Call<board>, t: Throwable) {
                Log.d("test","서버연결 실패 BoardActivity")
            }

            override fun onResponse(call: Call<board>, response: Response<board>) {
                val boards:board = response.body()!!

                Log.d("test", "${boards}, ${boards._embedded.boards[0].title}")
                //dummyBoard.add(BoardRecyclerViewItem(boards.title, boards.content))
                //dummyBoard.add(Item(boards!!.title,boards!!.content))
                mBoardListFragment!!.setBoard(dummyBoard)
            }

        })

        dummyBoard.add(BoardRecyclerViewItem("가나다","absdgsdsagas"))
        mBoardListFragment!!.setBoard(dummyBoard)

        new_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, Uri.parse("board://"))
            startActivityForResult(intent, PICK_NEWBOARD)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val mtitle =data?.getStringExtra(NewBoard?.EXTRA_TITLE)
        val msubtitle = data?.getStringExtra(NewBoard?.EXTRA_SUBTITLE)
        val content = data?.getStringExtra(NewBoard?.EXTRA_CONTENT)
        if(requestCode == PICK_NEWBOARD){
            if(resultCode == Activity.RESULT_OK){
                connect_server.requestAdd(mtitle!!, msubtitle!!, content!!,"2020-09-06T07:34:55.000+00:00","2020-09-06T07:34:55.000+00:00").enqueue(object:Callback<board>{
                    override fun onFailure(call: Call<board>, t: Throwable) {
                        Log.d("test", "실패실패")
                    }

                    override fun onResponse(call: Call<board>, response: Response<board>) {
                        Log.d("test", "$mtitle")
                    }

                })



//                val mtitle:String = data!!.getStringExtra(NewBoard.EXTRA_TITLE)!!
//                val mbody:String = data.getStringExtra(NewBoard.EXTRA_BODY)!!
//                dummyBoard.add(BoardRecyclerViewItem(mtitle,mbody))
//                mBoardListFragment!!.setBoard(dummyBoard)
            }
        }
    }

}