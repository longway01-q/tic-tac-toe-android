# Tic Tac Toe Android Game 🎮

Ek beautiful aur interactive Tic Tac Toe game Android ke liye!

## Features 🌟

✅ **Human vs AI Gameplay** - Intelligent AI opponent  
✅ **Smart AI Logic** - AI tries to win, block your moves, aur strategy use karta hai  
✅ **Score Tracking** - Aapke aur AI ke wins track kare  
✅ **Beautiful UI** - Clean aur modern design  
✅ **Game Status** - Real-time game status updates  
✅ **Reset Game** - Anytime naya game khel sakte ho  

## AI Strategy 🤖

AI is intelligent aur ye strategy follow karta hai:
1. **Win** - Agar AI win kar sakta hai to kar deta hai
2. **Block** - Agar aap win kar sakte ho to AI block karta hai
3. **Center** - Center position (4) prefer karta hai
4. **Corners** - Phir corner positions leta hai (0, 2, 6, 8)
5. **Sides** - Finally sides (1, 3, 5, 7) khel deta hai

## Project Structure 📁

```
tic-tac-toe-android/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/tictactoe/
│   │   │   ├── MainActivity.kt       # UI aur game management
│   │   │   └── GameLogic.kt          # Game logic aur AI
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   └── activity_main.xml # Layout file
│   │   │   └── values/
│   │   │       ├── colors.xml        # App colors
│   │   │       ├── strings.xml       # String resources
│   │   │       └── themes.xml        # Theme styles
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
├── settings.gradle
└── README.md
```

## How to Run 🚀

### Prerequisites
- Android Studio latest version
- Android SDK 24 ya usse zyada
- Java 11 ya usse zyada

### Steps

1. **Repository clone karo:**
   ```bash
   git clone https://github.com/longway01-q/tic-tac-toe-android.git
   cd tic-tac-toe-android
   ```

2. **Android Studio mein open karo:**
   - Android Studio kholo
   - "Open" click karo
   - Project folder select karo

3. **Gradle sync karo:**
   - Automatic ho jayega
   - Ya manually: File > Sync Now

4. **Android Device ya Emulator connect karo**

5. **Run karo:**
   - "Run" button press karo
   - Ya keyboard shortcut: Shift + F10

## Game Rules 📋

- **3x3 Grid** par game khela jata hai
- **Player** = X, **AI** = O
- Pehle **aapka turn** hota hai
- **Teeno** X ya O ko line mein arrange karo aur jeet jao
- Horizontal, vertical, ya diagonal line se jeet sakta hai
- Agar board full ho jayegi aur koi jeetn nahi, to **Draw** hota hai

## Code Explanation 📝

### GameLogic.kt

```kotlin
// Board representation
board = IntArray(9) {
    0 = Empty
    1 = Player (X)
    2 = AI (O)
}

// Player ka move
fun playerMove(position: Int): Boolean

// AI automatically move karta hai
private fun aiMove()

// Winner check karta hai
private fun checkGameState()
```

### MainActivity.kt

```kotlin
// Game buttons setup
private fun setupGameButtons()

// Button click handle karta hai
private fun onButtonClick(position: Int)

// UI update karta hai
private fun updateUI()

// New game start karta hai
private fun resetGame()
```

## Technical Details 🔧

- **Language:** Kotlin
- **Minimum SDK:** 24 (Android 7.0)
- **Target SDK:** 34 (Android 14)
- **Architecture:** MVC Pattern
- **UI:** XML Layouts + GridLayout

## Game Screenshots 📸

```
┌───────────────────┐
│  Tic Tac Toe      │
│  You: 2  AI: 1    │
│                   │
│  Your Turn (X)    │
│                   │
│  ┌─┬─┬─┐         │
│  │X│O│X│         │
│  ├─┼─┼─┤         │
│  │O│X│ │         │
│  ├─┼─┼─┤         │
│  │ │ │O│         │
│  └─┴─┴─┘         │
│                   │
│  [ New Game ]     │
└───────────────────┘
```

## Future Enhancements 🚀

- [ ] Difficulty levels (Easy, Medium, Hard)
- [ ] Multiplayer mode (Two players)
- [ ] Sound effects aur animations
- [ ] Statistics aur game history
- [ ] Dark theme support
- [ ] Undo last move feature

## Troubleshooting 🐛

**Problem:** Gradle build fail ho raha hai
- **Solution:** File > Invalidate Caches and Restart

**Problem:** Emulator nahi chal raha
- **Solution:** Android SDK Manager mein required API levels install karo

**Problem:** App crash ho raha hai
- **Solution:** Logcat mein error check karo (View > Tool Windows > Logcat)

## License 📄

MIT License - Freely use kar sakte ho!

## Contact & Support 💬

Koi problem ya suggestion ho to GitHub issues mein add karo!

---

**Made with ❤️ by longway01-q**  
**Enjoy the game! 🎮**
