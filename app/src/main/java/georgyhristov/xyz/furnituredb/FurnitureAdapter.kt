package georgyhristov.xyz.furnituredb

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import georgyhristov.xyz.furnituredb.model.Furniture


class FurnitureAdapter(private val furnitureList: List<Furniture>, val context: Context)
    : RecyclerView.Adapter<FurnitureAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.layout_furniture_item, parent, false)

        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val furniture = furnitureList[position]
        holder.type_text.text =  context.getString(R.string.string_type, furniture.type)
        holder.price_text.text = context.getString(R.string.string_price, furniture.price)
        holder.store_text.text = context.getString(R.string.string_store, furniture.storeName)
        holder.link_text.text = context.getString(R.string.string_link, furniture.link)
    }

    override fun getItemCount(): Int {
        return furnitureList.size
    }


    class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var type_text: TextView
        var price_text: TextView
        var store_text: TextView
        var link_text: TextView

        init {

            type_text = view.findViewById(R.id.type_text)
            price_text = view.findViewById(R.id.price_text)
            store_text = view.findViewById(R.id.store_text)
            link_text = view.findViewById(R.id.link_text)
        }
    }
}
