package georgyhristov.xyz.furnituredb.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.*
import georgyhristov.xyz.furnituredb.FurnitureAdapter

import georgyhristov.xyz.furnituredb.R
import georgyhristov.xyz.furnituredb.controller.DataControl
import georgyhristov.xyz.furnituredb.model.Furniture


class FurnitureFragment : Fragment() {


    private lateinit var database: FirebaseDatabase
    private lateinit var ref: DatabaseReference


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.layout_furniture,container,false)
        val dataBase = DataControl()
        database = FirebaseDatabase.getInstance()
        ref = database.getReference("furniture")
        val rec = view.findViewById<RecyclerView>(R.id.recycler_view)
        val list = arrayListOf<Furniture>()


        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    val furniture = postSnapshot.getValue(Furniture::class.java)
                    list.add(furniture)
                    val adapter = FurnitureAdapter(list,context)

                    rec.adapter = adapter
                    rec.layoutManager = LinearLayoutManager(context)
                }
            }
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })



        return view
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
