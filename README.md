# 🐍 Snake Game - Java Swing

A classic **Snake Game** built using **Java Swing** with a clean **Object-Oriented Programming (OOP)** architecture.
This project focuses on mastering Java fundamentals, GUI development, and game logic design.

---

## 🎮 Features

* Smooth grid-based snake movement
* Real-time keyboard controls
* Dynamic food spawning
* Snake growth mechanics
* Score tracking system
* Wall collision detection
* Self-collision detection
* Pause / Resume functionality (`P`)
* Restart game (`R`)

---

## 🧠 Architecture & Design

This project follows clean OOP principles with clear separation of concerns:

* **Main** → Application entry point
* **GameFrame** → Main window setup
* **GamePanel** → Rendering and game loop
* **GameController** → Core game logic
* **GameState** → Manages game state (running, paused, game over)
* **Snake** → Handles movement and growth
* **Food** → Handles food spawning logic
* **InputHandler** → Handles keyboard input
* **Direction** → Enum for movement directions

### 💡 Design Principles Applied

* Encapsulation
* Single Responsibility Principle
* Loose Coupling
* Event-driven programming
* Clean architecture separation

---

## 🕹 Controls

| Key     | Action         |
| ------- | -------------- |
| ↑ ↓ ← → | Move snake     |
| P       | Pause / Resume |
| R       | Restart game   |

---

## 📸 Screenshots

<img width="758" height="785" alt="snakeGame" src="https://github.com/user-attachments/assets/3ba7a1d6-16ed-4d7e-ba4e-e270a483dd38" />


---

## ⚙️ How to Run

### 1. Compile

```bash
javac src/*.java
```

### 2. Run

```bash
java -cp src Main
```

---

## 📁 Project Structure

```text
snake-game-java-swing/
├── src/
│   ├── Main.java
│   ├── GameFrame.java
│   ├── GamePanel.java
│   ├── GameController.java
│   ├── GameState.java
│   ├── Snake.java
│   ├── Food.java
│   ├── Direction.java
│   └── InputHandler.java
├── assets/
│   ├── snakeGame.png
│   └── snakeGame2.png
├── README.md

```

---

## 🚀 Future Improvements

* Add start screen
* Save high score
* Add sound effects
* Difficulty levels
* Improve UI/animations

---

## 👨‍💻 Author

**Mohamed Abdelbaky**

---

## ⭐ Support

If you like this project, consider giving it a ⭐ on GitHub!
