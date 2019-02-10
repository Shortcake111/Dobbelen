package com.example.dobbelen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseArray
import android.widget.Button
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var random:Random
    private lateinit var linkerDobbelsteen:ImageView
    private lateinit var rechterDobbelsteen:ImageView
    private lateinit var listOfDobbelstenen:SparseArray<Int>
    private lateinit var rollenBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialiseViews()
        addEventHandlers()
        random = Random()
        listOfDobbelstenen = SparseArray()

        for (i in 1..6){
            val temp:Int = when(i){
                1-> R.drawable.die1
                2-> R.drawable.die2
                3-> R.drawable.die3
                4-> R.drawable.die4
                5-> R.drawable.die5
                6-> R.drawable.die6
                else-> 0
            }
            listOfDobbelstenen.put(i, temp)
        }

        linkerDobbelsteen.setImageResource(listOfDobbelstenen.get(1))
        rechterDobbelsteen.setImageResource(listOfDobbelstenen.get(1))
    }

    private fun initialiseViews(){
        linkerDobbelsteen = findViewById(R.id.dobbelsteenLinksImageView)
        rechterDobbelsteen = findViewById(R.id.dobbelsteenRechtsImageView)
        rollenBtn = findViewById(R.id.rollenButton)

    }

    private fun addEventHandlers(){
        rollenBtn.setOnClickListener{
            var randomNr = random.nextInt(6)+1
            linkerDobbelsteen.setImageResource(listOfDobbelstenen.get(randomNr))
            randomNr = random.nextInt(6)+1
            rechterDobbelsteen.setImageResource(listOfDobbelstenen.get(randomNr))
        }
    }
}
