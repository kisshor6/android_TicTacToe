package com.example.tictackotlin_feb14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class setPlayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_player)

        val p1 = findViewById<EditText>(R.id.player1)
        val p2 = findViewById<EditText>(R.id.player2)
        val setPlayer = findViewById<Button>(R.id.setPlayer)

        setPlayer.setOnClickListener {
            if (p1.text.isNullOrEmpty() && p2.text.isNullOrEmpty()){
                Toast.makeText(this, "Please set Players name", Toast.LENGTH_SHORT).show()
            }else{
                val player1 = p1.text.toString()
                val player2 = p2.text.toString()

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("player1", player1)
                intent.putExtra("player2", player2)
                startActivity(intent)
            }
        }
    }
}