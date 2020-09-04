package com.example.login.Board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R

class BoardRecyclerViewAdapter:RecyclerView.Adapter<BoardRecyclerViewAdapter.ViewHolder> {
    var mBoards:MutableList<BoardRecyclerViewItem>? = null

    constructor(boards:MutableList<BoardRecyclerViewItem>){
        mBoards = boards
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BoardRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_board,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BoardRecyclerViewAdapter.ViewHolder, position: Int) {
        holder.board = mBoards!![position]
        holder.detailsView!!.text = mBoards!![position].toString()
    }

    override fun getItemCount(): Int {
        return mBoards!!.size
    }

    class ViewHolder: RecyclerView.ViewHolder{
        var parentView: View? = null
        var detailsView:TextView? = null
        var board:BoardRecyclerViewItem? = null
        constructor(view:View):super(view){
            parentView = view
            detailsView = view.findViewById(R.id.list_item_board_details) as TextView
        }
        override fun toString(): String {
            return super.toString() + " '" + detailsView!!.text + "'"
        }
    }


}