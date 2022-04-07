package com.example.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView

//En tiempo de compilación, te va a dejar acceder a cualquier vista desde cualquier otra
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        //Busca los id de los textViews de los recursos
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
        val pictureView1 = findViewById<TextView>(R.id.picture1)
        val pictureView2 = findViewById<TextView>(R.id.picture2)
        //Esta linea se agrega para saber el id del constraint de la activity para cambiar el fondo
        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)
        //Estas lineas buscan los id de lso botones
        val redButton = findViewById<Button>(R.id.red_button)
        val greenButton = findViewById<Button>(R.id.green_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)

        //Los agregamos a una lista
        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, rootConstraintLayout, pictureView1, pictureView2
                , redButton,greenButton,yellowButton)
        //genera un click listener que espera que clickes alguno de los id de los texviews para
        //para accionar la funcion makeColored
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

// se declara la funcion makeColored, y se un establece un argumento cualquiera (view) y su tipo (View)
    private fun makeColored(view: View) =
        when (view.id) {

        // Boxes using Color class colors for the background
        R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
        R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
        R.id.box_three_text -> view.setBackgroundColor(Color.BLUE)
        R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
        R.id.box_five_text -> view.setBackgroundColor(Color.BLUE)
        R.id.picture1 -> view.setBackgroundResource(R.drawable.craneo)
        R.id.picture2 -> view.setBackgroundResource(R.drawable.juancho)

        R.id.red_button -> box_three_text.setBackgroundResource(R.color.my_red)
        R.id.yellow_button -> box_four_text.setBackgroundResource(R.color.my_yellow)
        R.id.green_button -> box_five_text.setBackgroundResource(R.color.my_green)

        else -> view.setBackgroundResource(R.drawable.fondoespacial)
    }

}