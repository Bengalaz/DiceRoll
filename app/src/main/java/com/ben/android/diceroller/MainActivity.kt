package com.ben.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    /*Se inicializa en null porque no puedes inicialar una vista sin que primero
    se ejecuta el Oncreate y el setContentView
    var diceImage : ImageView? = null
    por eso se puede iniciar como null pero eso complica el código porque ahora
    deberemos verificiar el null valor cada vez que quieramos usar diceImage
    */

    lateinit var  diceImage : ImageView
    lateinit var  diceImage2 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)

        val rollButton : Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        var restartButton : Button = findViewById(R.id.restart_button)
        restartButton.setOnClickListener{ restartRoll()}
    }

    private fun rollDice(){
        var randomInt = (1..6).random()
        var randimInt2 = (1..6).random()
        /* Eliminamos el texto y lo reemplazamos por una img
        val resulText : TextView = findViewById(R.id.result_text)
        resulText.text = randomInt.toString()
        */

        val drawableResource = when(randomInt){
            1 ->R.drawable.dice_1
            2 ->R.drawable.dice_2
            3 ->R.drawable.dice_3
            4 ->R.drawable.dice_4
            5 ->R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        //Toast.makeText(this,"button clicked",Toast.LENGTH_SHORT).show()

        val drawableResource2 = when(randimInt2){
            1 ->R.drawable.dice_1
            2 ->R.drawable.dice_2
            3 ->R.drawable.dice_3
            4 ->R.drawable.dice_4
            5 ->R.drawable.dice_5
            else -> R.drawable.dice_6
        }


        diceImage2.setImageResource(drawableResource2)
    }

    private fun restartRoll(){
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
    }

}