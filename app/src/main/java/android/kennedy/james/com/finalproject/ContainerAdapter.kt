package android.kennedy.james.com.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContainerAdapter(private val containerDataset: MutableList<Container>, val clickListener: (Container) -> Unit) :
    RecyclerView.Adapter<ContainerAdapter.ContainerViewHolder>() {



    class ContainerViewHolder(val containerView: View) : RecyclerView.ViewHolder(containerView){
        var containerTxt = containerView.findViewById<TextView>(R.id.containerId)

    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int) : ContainerViewHolder{

        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_container, parent, false)

        return ContainerViewHolder(textView)
    }

    override fun onBindViewHolder(holder: ContainerViewHolder, position: Int) {
        var item: Container = containerDataset[position]
        holder.containerTxt.text = item.id
        holder.containerView.setOnClickListener{clickListener(item)}

    }
    override fun getItemCount() = containerDataset.size
}