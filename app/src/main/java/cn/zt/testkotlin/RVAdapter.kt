package cn.zt.testkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * 作者：Tony
 * 日期：2016年12月18日
 * 时间：下午 7:52
 */

class RVAdapter(val context:Context,val list:List<String>) : RecyclerView.Adapter<RVAdapter.ViewHolder>(){
    /**
     * holder?表示这个值可能为空，内部做好了null的处理
     * “:”表示只带这个对象是什么类型的属性
     * 不带问号的数据，表示这个数据一定不为空，并且我们最后有问号就带上，没有就不要带，因为框架帮我们做好了null的处理
    */
    private var onItem:OnItemClick? = null
    //写法一：
//    override fun getItemCount(): Int {
//        return list.size
//    }
    //写法二：
    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val text = LayoutInflater.from(context).inflate(R.layout.item_rv,parent,false) as TextView
        val viewHolder = ViewHolder(text)
        viewHolder.itemView.setOnClickListener {
            onItem?.onItemClick(text,viewHolder.adapterPosition)
        }
        return viewHolder
    }
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val text = holder?.itemView as TextView
        text.text = list.get(position)
    }
    fun setOnItemClick(onItemClick: OnItemClick){
        onItem = onItemClick
    }
    interface OnItemClick{
        fun onItemClick(view:View, position: Int)
    }

    /**
     * 申明一个类，通过(直接降数据给初始化了，只带了set和get方法)
     * ： 表示继承父类，因为父类是有参数的构造，那么子类一定要实现这个有参数的构造
     *
     */
    class ViewHolder(textView:TextView) : RecyclerView.ViewHolder(textView)
}