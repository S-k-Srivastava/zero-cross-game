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

    private lateinit var binding: ActivityMainBinding
    private lateinit var ll: Array<LinearLayout>
    private lateinit var img: Array<ImageView>
    private lateinit var gameState: Array<Int>
    private var xClicked: Boolean = true
    private var gameActive: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ll = arrayOf(
            binding.ll1,
            binding.ll2,
            binding.ll3,
            binding.ll4,
            binding.ll5,
            binding.ll6,
            binding.ll7,
            binding.ll8,
            binding.ll9
        )
        img = arrayOf(
            binding.box1,
            binding.box2,
            binding.box3,
            binding.box4,
            binding.box5,
            binding.box6,
            binding.box7,
            binding.box8,
            binding.box9
        )
        gameState = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)

        startPlay()

        binding.playAgainBtn.setOnClickListener {
            resetGame()
        }

    }




    private fun setOnClickOnBoxes(i: Int) {
        ll[i].setOnClickListener {
            if (xClicked) {
                img[i].setImageDrawable(getDrawable(R.drawable.o))
                xClicked = false
                gameState[i] = 0
                disableOnClickOnBoxes(i)
                checkWin()
            } else {
                img[i].setImageDrawable(getDrawable(R.drawable.x))
                xClicked = true
                gameState[i] = 1
                disableOnClickOnBoxes(i)
                checkWin()
                //test
            }
        }
    }





    private fun disableOnClickOnBoxes(i: Int) {
        ll[i].setOnClickListener(null)
    }

    private fun stopPlay(){
        var i = 0
        while (i < 9) {
            disableOnClickOnBoxes(i)
            i++
        }
    }

    private fun startPlay(){
        var i = 0
        while (i < 9) {
            setOnClickOnBoxes(i)
            i++
        }
    }




    private fun checkWin() {
        if (gameActive) {
            if (gameState[0] == gameState[1] && gameState[1] == gameState[2] && gameState[2] != 2) {
                whoWon(gameState[2])
                gameActive = false
                stopPlay()
            } else if (gameState[3] == gameState[4] && gameState[4] == gameState[5] && gameState[5] != 2) {
                whoWon(gameState[5])
                gameActive = false
                stopPlay()
            } else if (gameState[6] == gameState[7] && gameState[7] == gameState[8] && gameState[8] != 2) {
                whoWon(gameState[8])
                gameActive = false
                stopPlay()
            } else if (gameState[0] == gameState[3] && gameState[3] == gameState[6] && gameState[6] != 2) {
                whoWon(gameState[6])
                gameActive = false
                stopPlay()
            } else if (gameState[1] == gameState[4] && gameState[4] == gameState[7] && gameState[7] != 2) {
                whoWon(gameState[7])
                gameActive = false
                stopPlay()
            } else if (gameState[2] == gameState[5] && gameState[5] == gameState[8] && gameState[8] != 2) {
                whoWon(gameState[8])
                gameActive = false
                stopPlay()
            } else if (gameState[0] == gameState[4] && gameState[4] == gameState[8] && gameState[8] != 2) {
                whoWon(gameState[8])
                gameActive = false
                stopPlay()
            } else if (gameState[2] == gameState[4] && gameState[4] == gameState[6] && gameState[6] != 2) {
                whoWon(gameState[6])
                gameActive = false
                stopPlay()
            } else if (gameState[0] != 2 && gameState[1] != 2 && gameState[2] != 2 && gameState[3] != 2 && gameState[4] != 2 && gameState[5] != 2 && gameState[6] != 2 && gameState[7] != 2 && gameState[8] != 2) {
                Toast.makeText(this, "Match Draw", Toast.LENGTH_SHORT).show()
                gameActive = false
                stopPlay()
            }
        } else {
            //gameActive = false --> Won
            Toast.makeText(this, "Game Over!", Toast.LENGTH_SHORT).show()
        }
    }



    private fun whoWon(gameState: Int) {
        if (gameState == 1) {
            binding.winnerText.text = "X is the Winner!"
        } else {
            binding.winnerText.text = "O is the Winner!"
        }
    }

    private fun resetGame(){
        gameActive = true
        gameState = arrayOf(2,2,2,2,2,2,2,2,2)
        xClicked = true

        var i = 0
        while (i < 9) {
            img[i].setImageDrawable(null)
            i++
        }
        startPlay()
    }

}

//Ui sound Animations Computer

//winPosition = arrayOf(
//
//arrayOf(1,2,3),
//arrayOf(4,5,6),
//arrayOf(7,8,9),
//arrayOf(1,4,7),
//arrayOf(2,5,8),
//arrayOf(3,6,9),
//arrayOf(1,5,9),
//arrayOf(3,5,7)
//
//)