package georgyhristov.xyz.furnituredb.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

import georgyhristov.xyz.furnituredb.R
import georgyhristov.xyz.furnituredb.controller.DataControl
import georgyhristov.xyz.furnituredb.model.Furniture

class AddFurnitureFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.layout_addfurniture,container,false)
        val button: Button = view.findViewById(R.id.saveButton)
        val typeEditText: EditText = view.findViewById(R.id.typeEditText)
        val priceEditText: EditText = view.findViewById(R.id.priceEditText)
        val storeEditText: EditText = view.findViewById(R.id.storeNameEditText)
        val linkEditText: EditText = view.findViewById(R.id.linkEditText)



        button.setOnClickListener {
            val type = typeEditText.text.toString()
            val price = priceEditText.text.toString()
            val store = storeEditText.text.toString()
            val link = linkEditText.text.toString()

            val furniture = Furniture(type,price,store,link)
            val dataControl = DataControl()

            dataControl.write(furniture)

            clearInput(typeEditText,"")
            clearInput(priceEditText,"")
            clearInput(storeEditText,"")
            clearInput(linkEditText,"")

        }

        return view

    }

    private fun clearInput(editText: EditText,clear: String){
        editText.setText(clear)
    }
}
