package android.kennedy.james.com.finalproject

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var containerDataset: MutableList<Container>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        containerDataset = getContainerDataset()
        viewManager = LinearLayoutManager(this)
        viewAdapter = ContainerAdapter(containerDataset)
            {
                val intent = Intent(this, ContainerDetailsActivity::class.java)
                intent.putExtra("Extra", it as Serializable )
                startActivity(intent)
            }

        recyclerView = findViewById<RecyclerView>(R.id.container_recycler_view).apply {

            layoutManager = viewManager
            adapter = viewAdapter

        }



        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }



    }


    private fun getContainerDataset(): MutableList<Container> {
        var containerList : MutableList<Container>
        var MyPackages: MutableList<MyPackage> = mutableListOf(MyPackage("9261291"), MyPackage("9261292"))
        var container: Container = Container("CVG1", MyPackages)
        containerList = mutableListOf(container)

        return containerList

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
