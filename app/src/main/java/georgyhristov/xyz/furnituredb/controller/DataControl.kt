package georgyhristov.xyz.furnituredb.controller

import com.google.firebase.database.*
import georgyhristov.xyz.furnituredb.model.Furniture
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener




class DataControl {
    private val database: FirebaseDatabase
    private var ref: DatabaseReference


init {
    database = FirebaseDatabase.getInstance()
    ref = database.getReference("furniture")
}
    fun write(furniture: Furniture) {
        ref.push().setValue(furniture)
    }

    fun read(){
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    val furniture = postSnapshot.getValue(Furniture::class.java)
                }
            }
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
}