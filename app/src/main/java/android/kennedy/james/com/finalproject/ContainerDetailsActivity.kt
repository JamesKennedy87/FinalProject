package android.kennedy.james.com.finalproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.HORIZONTAL
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.intellij.lang.annotations.JdkConstants

class ContainerDetailsActivity: AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container_details)

        var container: Container = intent.getSerializableExtra("Extra") as Container
        var packages: MutableList<MyPackage> = container.packages
        this.title = container.id
        viewManager = LinearLayoutManager(this)
        viewAdapter = ContainerDetailsAdapter(packages)

        recyclerView = findViewById<RecyclerView>(R.id.details_recyclerView).apply {

            layoutManager = viewManager
            adapter = viewAdapter

        }
        recyclerView.addItemDecoration(DividerItemDecoration(this, HORIZONTAL))

    }
}