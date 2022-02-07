package com.skdevstudio.zerocross

import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.IdRes
import com.skdevstudio.zerocross.databinding.ActivityMainBinding
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var ll : Array<LinearLayout>
    private lateinit var img : Array<ImageView>
    private lateinit var gameState : Array<Int>
    private lateinit var winPosition: Array<Array<Int>>
    private var xClicked : Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ll = arrayOf(binding.ll1,binding.ll2,binding.ll3,binding.ll4,binding.ll5,binding.ll6,binding.ll7,binding.ll8,binding.ll9)
        img = arrayOf(binding.box1,binding.box2,binding.box3,binding.box4,binding.box5,binding.box6,binding.box7,binding.box8,binding.box9)
        gameState = arrayOf(2,2,2,2,2,2,2,2,2)
        winPosition = arrayOf(
            
            arrayOf(1,2,3),
            arrayOf(4,5,6),
            arrayOf(7,8,9),
            arrayOf(1,4,7),
            arrayOf(2,5,8),
            arrayOf(3,6,9),
            arrayOf(1,5,9),
            arrayOf(3,5,7)
            
        )


        setOnClickOnBoxes(0)
        setOnClickOnBoxes(1)
        setOnClickOnBoxes(2)
        setOnClickOnBoxes(3)
        setOnClickOnBoxes(4)
        setOnClickOnBoxes(5)
        setOnClickOnBoxes(6)
        setOnClickOnBoxes(7)
        setOnClickOnBoxes(8)

    }

    private fun setOnClickOnBoxes(i : Int){
        ll[i].setOnClickListener{
            if(xClicked){
                img[i].setImageDrawable(getDrawable(R.drawable.o))
                xClicked = false
                gameState[i] = 0
                checkWin()
            }else{
                img[i].setImageDrawable(getDrawable(R.drawable.x))
                xClicked = true
                gameState[i] = 1
                checkWin()
            }
        }
    }

    private fun checkWin(){
        if(gameState[0] == gameState[1] && gameState[1] == gameState[2] && gameState[1] != 2){
            Toast.makeText(this, "Won", Toast.LENGTH_SHORT).show()
        }else if(gameState[3] == gameState[4] && gameState[4] == gameState[5] && gameState[1] != 2){
            Toast.makeText(this, "Won", Toast.LENGTH_SHORT).show()
        }else if(gameState[6] == gameState[7] && gameState[7] == gameState[8] && gameState[1] != 2) {
            Toast.makeText(this, "Won", Toast.LENGTH_SHORT).show()
        }else if(gameState[0] == gameState[3] && gameState[3] == gameState[6] && gameState[1] != 2) {
            Toast.makeText(this, "Won", Toast.LENGTH_SHORT).show()
        }else if(gameState[1] == gameState[4] && gameState[4] == gameState[7] && gameState[1] != 2) {
            Toast.makeText(this, "Won", Toast.LENGTH_SHORT).show()
        }else if(gameState[2] == gameState[5] && gameState[5] == gameState[8] && gameState[1] != 2) {
            Toast.makeText(this, "Won", Toast.LENGTH_SHORT).show()
        }else if(gameState[0] == gameState[4] && gameState[4] == gameState[8] && gameState[1] != 2) {
            Toast.makeText(this, "Won", Toast.LENGTH_SHORT).show()
        }else if(gameState[2] == gameState[4] && gameState[4] == gameState[6] && gameState[1] != 2) {
            Toast.makeText(this, "Won", Toast.LENGTH_SHORT).show()
        }else {
        }
    }

}



