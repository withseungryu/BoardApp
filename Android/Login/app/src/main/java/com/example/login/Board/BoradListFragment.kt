package com.example.login.Board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R

class BoardListFragment:Fragment {

    val mBoard:MutableList<BoardRecyclerViewItem>? = mutableListOf()
    constructor():super()
    private lateinit var mRecyclerView:RecyclerView
    private var mBoardAdapter:BoardRecyclerViewAdapter? = BoardRecyclerViewAdapter(mBoard!!)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_board_list,container,false)
        mRecyclerView = view.findViewById(R.id.list) as RecyclerView
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context = view.context
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.adapter = mBoardAdapter
    }

    fun setBoard(boards:MutableList<BoardRecyclerViewItem>){
        for(i in boards){
            if(!mBoard!!.contains(i)){
                mBoard.add(i)
                mBoardAdapter!!.notifyItemInserted(mBoard.indexOf(i))
            }
        }
    }
}