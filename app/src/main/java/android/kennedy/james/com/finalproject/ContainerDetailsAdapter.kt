package android.kennedy.james.com.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContainerDetailsAdapter(private val containerDetailsDataset: MutableList<MyPackage>) :
    RecyclerView.Adapter<ContainerDetailsAdapter.ContainerViewHolder>() {



    class ContainerViewHolder(val containerView: View) : RecyclerView.ViewHolder(containerView){
        var packageTxt = containerView.findViewById<TextView>(R.id.packageId)

    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int) : ContainerViewHolder{

        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_container_details, parent, false)

        return ContainerViewHolder(textView)
    }

    override fun onBindViewHolder(holder: ContainerViewHolder, position: Int) {
        var item: MyPackage = containerDetailsDataset[position]
        holder.packageTxt.text = item.id
    }
    override fun getItemCount() = containerDetailsDataset.size
}