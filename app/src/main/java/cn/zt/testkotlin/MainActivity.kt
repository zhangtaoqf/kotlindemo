package cn.zt.testkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import cn.zt.testkotlin.RVAdapter.OnItemClick

/**使用Kotlin的步骤
 * 1.先安装kotlin插件
 *      在setting里面的plugin里面安装kotlin插件，并重启studio
 * 2.讲插件配置在自己的新建的项目中
 *      1.在project的build.gradle中配置
 *          dependencies{
 *              classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
 *          }
 *      2.在module中的build.gradle中配置plugin 和 依赖
 *          apply plugin: 'kotlin-android' ：注意：这个是在android节点上面配置就可以
 *          compile "org.jetbrains.kotlin:kotlin-stdlib:1.0.5-3" :注意：这个需要配置在dependencies里面
 *
 */
class MainActivity : AppCompatActivity(),OnItemClick{
    override fun onItemClick(view: View, position: Int) {
        toast("点击了"+position)
    }

    //定义一个集合变量，并赋值
    private val items = listOf("Kotlin DEMO数据1",
            "Kotlin DEMO数据21/8", "Kotlin DEMO数据17",
            "Kotlin DEMO数据111", "Kotlin DEMO数据1",
            "Kotlin DEMO数据1", "Kotlin DEMO数据17")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //查找控件
        val recyclerView = findViewById(R.id.activity_recyclerview) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        //实例化适配器
        val adapter = RVAdapter(this,items)
        //设置item的点击事件
        adapter.setOnItemClick(this)
        //设置适配器
        recyclerView.adapter = adapter
    }

    private fun toast(s: String) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
    }
}
