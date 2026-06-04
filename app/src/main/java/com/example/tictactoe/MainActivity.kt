package com.example.tictactoe

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var statusText: TextView
    private lateinit var playerScoreText: TextView
    private lateinit var aiScoreText: TextView
    private lateinit var gridLayout: GridLayout
    private lateinit var resetButton: Button
    private val buttons = mutableListOf<Button>()

    private var playerScore = 0
    private var aiScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        statusText = findViewById(R.id.statusText)
        playerScoreText = findViewById(R.id.playerScore)
        aiScoreText = findViewById(R.id.aiScore)
        gridLayout = findViewById(R.id.gameGrid)
        resetButton = findViewById(R.id.resetButton)

        setupGameButtons()
        resetButton.setOnClickListener { resetGame() }
        updateStatus()
    }

    private fun setupGameButtons() {
        for (i in 0..8) {
            val button = Button(this).apply {
                text = ""
                textSize = 28f
                setOnClickListener { onButtonClick(i) }
            }
            buttons.add(button)
            gridLayout.addView(button, GridLayout.LayoutParams().apply {
                rowSpec = GridLayout.spec(i / 3, 1f)
                columnSpec = GridLayout.spec(i % 3, 1f)
                width = 0
                height = 0
            })
        }
    }

    private fun onButtonClick(position: Int) {
        if (GameLogic.playerMove(position)) {
            updateUI()
            updateStatus()
            if (GameLogic.gameOver) {
                handleGameOver()
            }
        }
    }

    private fun updateUI() {
        for (i in 0..8) {
            buttons[i].text = GameLogic.getBoardValue(i)
            buttons[i].isEnabled = GameLogic.board[i] == 0 && !GameLogic.gameOver
        }
    }

    private fun updateStatus() {
        statusText.text = when {
            GameLogic.gameOver -> when (GameLogic.winner) {
                1 -> "🎉 You Won!"
                2 -> "🤖 AI Won!"
                3 -> "🤝 It's a Draw!"
                else -> "Game Over"
            }
            GameLogic.isPlayerTurn -> "Your Turn (X)"
            else -> "AI is thinking..."
        }
    }

    private fun handleGameOver() {
        when (GameLogic.winner) {
            1 -> playerScore++
            2 -> aiScore++
        }
        updateScores()
    }

    private fun updateScores() {
        playerScoreText.text = "You: $playerScore"
        aiScoreText.text = "AI: $aiScore"
    }

    private fun resetGame() {
        GameLogic.resetGame()
        for (button in buttons) {
            button.text = ""
            button.isEnabled = true
        }
        updateStatus()
    }
}
