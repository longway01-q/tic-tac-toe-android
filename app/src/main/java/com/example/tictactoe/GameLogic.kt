package com.example.tictactoe

object GameLogic {
    // Game board: 0 = empty, 1 = player (X), 2 = AI (O)
    var board = IntArray(9) { 0 }
    var isPlayerTurn = true
    var gameOver = false
    var winner = 0 // 0 = no winner, 1 = player, 2 = AI, 3 = draw

    // Winning combinations
    private val winningCombinations = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8),
        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(0, 4, 8),
        intArrayOf(2, 4, 6)
    )

    fun resetGame() {
        board = IntArray(9) { 0 }
        isPlayerTurn = true
        gameOver = false
        winner = 0
    }

    fun playerMove(position: Int): Boolean {
        if (board[position] == 0 && !gameOver) {
            board[position] = 1 // Player is X
            checkGameState()
            if (!gameOver) {
                isPlayerTurn = false
                aiMove()
                isPlayerTurn = true
            }
            return true
        }
        return false
    }

    private fun aiMove() {
        // AI strategy: Win > Block > Center > Corner > Side
        var move = findWinningMove(2) // Try to win
        if (move == -1) {
            move = findWinningMove(1) // Try to block player
        }
        if (move == -1 && board[4] == 0) {
            move = 4 // Take center
        }
        if (move == -1) {
            move = findAvailableCorner() // Take corner
        }
        if (move == -1) {
            move = findAvailableMove() // Take any available
        }

        if (move != -1) {
            board[move] = 2 // AI is O
            checkGameState()
        }
    }

    private fun findWinningMove(player: Int): Int {
        for (combination in winningCombinations) {
            val (a, b, c) = combination
            if (board[a] == player && board[b] == player && board[c] == 0) return c
            if (board[a] == player && board[c] == player && board[b] == 0) return b
            if (board[b] == player && board[c] == player && board[a] == 0) return a
        }
        return -1
    }

    private fun findAvailableCorner(): Int {
        val corners = listOf(0, 2, 6, 8)
        return corners.filter { board[it] == 0 }.randomOrNull() ?: -1
    }

    private fun findAvailableMove(): Int {
        val available = board.indices.filter { board[it] == 0 }
        return available.randomOrNull() ?: -1
    }

    private fun checkGameState() {
        // Check for winner
        for (combination in winningCombinations) {
            val (a, b, c) = combination
            if (board[a] != 0 && board[a] == board[b] && board[b] == board[c]) {
                winner = board[a]
                gameOver = true
                return
            }
        }

        // Check for draw
        if (board.all { it != 0 }) {
            winner = 3 // Draw
            gameOver = true
        }
    }

    fun getBoardValue(position: Int): String {
        return when (board[position]) {
            1 -> "X"
            2 -> "O"
            else -> ""
        }
    }
}
