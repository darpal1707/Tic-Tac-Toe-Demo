package com.darpal.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(view: View) {
        val buttonSelected = view as Button
        var cellID = 0
        when(buttonSelected.id) {
            R.id.btn1_row1 -> cellID = 1
            R.id.btn2_row1 -> cellID = 2
            R.id.btn3_row1 -> cellID = 3
            R.id.btn1_row2 -> cellID = 4
            R.id.btn2_row2 -> cellID = 5
            R.id.btn3_row2 -> cellID = 6
            R.id.btn1_row3 -> cellID = 7
            R.id.btn2_row3 -> cellID = 8
            R.id.btn3_row3 -> cellID = 9
        }
        playGame(cellID,buttonSelected)
    }

    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    fun playGame(cellID:Int, buttonSelected:Button){
        if (activePlayer == 1){
            buttonSelected.text = "X"
            buttonSelected.setBackgroundColor(Color.parseColor("#1DE9B6"))
            player1.add(cellID)
            activePlayer = 2
            autoPlay()
        }
        else{
            buttonSelected.text = "O"
            buttonSelected.setBackgroundColor(Color.parseColor("#64FFDA"))
            player2.add(cellID)
            activePlayer = 1
        }
        buttonSelected.isEnabled = false
        checkForWinner()
    }

    fun checkForWinner(){
        var winner = -1

        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }
        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }


        if (winner == 1) {
            //player1WinsCounts += 1
            Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show()
            //restartGame()

        } else if (winner == 2) {
            //player2WinsCounts += 1
            Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()
            //restartGame()
        }

    }

    fun autoPlay(){
        var checkEmptyCells = java.util.ArrayList<Int>()
        for (cellID in 1..9){
            if (!player1.contains(cellID) || player2.contains(cellID)){
                checkEmptyCells.add(cellID)
            }
        }

        var r = Random
        val randIndex = r.nextInt(checkEmptyCells.size)
        val cellID = checkEmptyCells[randIndex]
        var btnSelected : Button?
        btnSelected = when(cellID){
            1 -> btn1_row1
            2 -> btn2_row1
            3 -> btn3_row1
            4 -> btn1_row2
            5 -> btn2_row2
            6 -> btn3_row2
            7 -> btn1_row3
            8 -> btn2_row3
            9 -> btn3_row3

            else ->{
                btn1_row1
            }
        }

        playGame(cellID, btnSelected)
    }

}
