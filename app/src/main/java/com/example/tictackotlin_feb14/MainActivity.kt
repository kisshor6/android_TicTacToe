package com.example.tictackotlin_feb14

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var flag = 0
    private var count = 0
     lateinit var p1 : String
    lateinit var p2 : String

     var player1_Winner : Boolean = false
     var player2_Winner : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val player1 = findViewById<TextView>(R.id.firstPlayer)
        val player2 = findViewById<TextView>(R.id.secondPlayer)

         p1 = intent.getStringExtra("player1").toString()
         p2 = intent.getStringExtra("player2").toString()

        player1.text = p1
        player2.text = p2
        playerFirst.background = ContextCompat.getDrawable(this, R.drawable.playerturn)

        back.setOnClickListener{
            popupDialog()
        }

    }
    fun check(view: View) {
        val btnCurrent = view as ImageView

        if (btnCurrent.drawable == null) {
            count++

            if (flag == 0) {
                playerFirst.background = null
                playerSecond.background = ContextCompat.getDrawable(this, R.drawable.playerturn)
                btnCurrent.setImageDrawable(resources.getDrawable(R.drawable.close))
                btnCurrent.tag = "a"
                flag = 1
            } else if(flag == 1){
                playerSecond.background = null
                playerFirst.background = ContextCompat.getDrawable(this, R.drawable.playerturn)
                btnCurrent.setImageDrawable(resources.getDrawable(R.drawable.circle))
                btnCurrent.tag = "b"
                flag = 0
            }else{
                btnCurrent.setImageDrawable(null)
            }
            val b1 = btn1.tag
            val b2 = btn2.tag
            val b3 = btn3.tag
            val b4 = btn4.tag
            val b5 = btn5.tag
            val b6 = btn6.tag
            val b7 = btn7.tag
            val b8 = btn8.tag
            val b9 = btn9.tag

            checkWinner(b1, b2, b3)
            checkWinner(b4, b5, b6)
            checkWinner(b7, b8, b9)
            checkWinner(b1, b5, b9)
            checkWinner(b3, b5, b7)
            checkWinner(b1, b4, b7)
            checkWinner(b2, b5, b8)
            checkWinner(b3, b6, b9)

        }
    }

    private fun checkWinner(c1: Any?, c2: Any?, c3: Any?) {
        if (c1 == "a" && c2  == "a" && c3 == "a"){
            winnweName.text = "$p1 Won"
            winnwe.visibility = View.VISIBLE
            winnweName.visibility = View.VISIBLE
            playerFirst.background = null
            playerSecond.background = null
            player1_Winner = true
            flag = 3
        }else if (c1 == "b" && c2  == "b" && c3 == "b"){
            winnweName.text = "$p2 Won"
            winnwe.visibility = View.VISIBLE
            winnweName.visibility = View.VISIBLE
            playerFirst.background = null
            playerSecond.background = null
            player2_Winner = true
            flag = 3
        }else if (count == 9){
            flag = 3
        }
    }


    fun newGame(view: View) {

        if (player2_Winner){
            playerSecond.background = ContextCompat.getDrawable(this, R.drawable.playerturn)
            playerFirst.background = null
            flag = 1
            player2_Winner = false
        }else{
            playerFirst.background = ContextCompat.getDrawable(this, R.drawable.playerturn)
            playerSecond.background = null
            flag = 0
        }
        winnwe.visibility = View.GONE
        winnweName.visibility = View.GONE
        btn1.setImageDrawable(null)
        btn1.tag = null
        btn2.setImageDrawable(null)
        btn2.tag = null
        btn3.setImageDrawable(null)
        btn3.tag = null
        btn4.setImageDrawable(null)
        btn4.tag = null
        btn5.setImageDrawable(null)
        btn5.tag = null
        btn6.setImageDrawable(null)
        btn6.tag = null
        btn7.setImageDrawable(null)
        btn7.tag = null
        btn8.setImageDrawable(null)
        btn8.tag = null
        btn9.setImageDrawable(null)
        btn9.tag = null

        count = 0
    }

    override fun onBackPressed() {
        popupDialog()
    }

    private fun popupDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to exit the Game?")
            .setCancelable(false)
            .setPositiveButton("Yes") { dialog, _ -> finish() }
            .setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
        val alert = builder.create()
        alert.show()
        val messageTextView = alert.findViewById<TextView>(android.R.id.message)
        messageTextView?.setTextColor(ContextCompat.getColor(this, R.color.white))
    }
}
