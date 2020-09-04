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


        ConnectRetrofit.retrofitService().requestSearchBoard().enqueue(object:Callback<Board>{
            override fun onFailure(call: Call<Board>, t: Throwable) {
                Log.d("test","서버연결 실패 BoardActiivty")
            }

            override fun onResponse(call: Call<Board>, response: Response<Board>) {
                val boards = response.body()
                Log.d("test","${boards!!.msg}")
                dummyBoard.add(BoardRecyclerViewItem(boards.code, boards.msg))
                //  dummyBoard.add(Item(boards!!.title,boards!!.content))
                mBoardListFragment!!.setBoard(dummyBoard)
            }

        })


        dummyBoard.add(BoardRecyclerViewItem("가나다","absdgsdsagas"))
        mBoardListFragment!!.setBoard(dummyBoard)

        new_button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?){
                val intent = Intent(Intent.ACTION_PICK, Uri.parse("board://"))
                startActivityForResult(intent, PICK_NEWBOARD)
            }
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == PICK_NEWBOARD){
            if(resultCode == Activity.RESULT_OK){
                val mtitle:String = data!!.getStringExtra(NewBoard.EXTRA_TITLE)!!
                val mbody:String = data.getStringExtra(NewBoard.EXTRA_BODY)!!
                dummyBoard.add(BoardRecyclerViewItem(mtitle,mbody))
                mBoardListFragment!!.setBoard(dummyBoard)
            }
        }
    }

}