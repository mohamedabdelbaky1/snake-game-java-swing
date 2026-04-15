import java.awt.Point;

public class GameController {
    private GameState gameState;
    private Snake snake;
    private Food food;

    public GameController() {
        resetGame();
    }

    public void resetGame() {
        gameState = new GameState();
        gameState.reset();

        int startX = GamePanel.COLUMNS / 2;
        int startY = GamePanel.ROWS / 2;

        snake = new Snake(startX, startY);

        food = new Food();
        food.spawn(GamePanel.COLUMNS, GamePanel.ROWS, snake.getBody());
    }

    public void startGame() {
        if (!gameState.isGameOver()) {
            gameState.setStarted(true);
            gameState.setRunning(true);
            gameState.setPaused(false);
        }
    }

    public void update() {
        if (!gameState.isStarted() || !gameState.isRunning() || gameState.isPaused() || gameState.isGameOver()) {
            return;
        }

        snake.move();

        if (checkWallCollision() || snake.hitsItself()) {
            gameState.setGameOver(true);
            gameState.setRunning(false);
            return;
        }

        checkFoodEaten();
    }

    private boolean checkWallCollision() {
        Point head = snake.getHead();

        return head.x < 0 ||
               head.y < 0 ||
               head.x >= GamePanel.COLUMNS ||
               head.y >= GamePanel.ROWS;
    }

    private void checkFoodEaten() {
        Point head = snake.getHead();

        if (head.equals(food.getPosition())) {
            snake.grow();
            gameState.setScore(gameState.getScore() + 1);
            food.spawn(GamePanel.COLUMNS, GamePanel.ROWS, snake.getBody());
        }
    }

    public void changeDirection(Direction direction) {
        if (gameState.isStarted() && !gameState.isPaused() && !gameState.isGameOver()) {
            snake.setDirection(direction);
        }
    }

    public void togglePause() {
        if (gameState.isStarted() && !gameState.isGameOver()) {
            gameState.setPaused(!gameState.isPaused());
            gameState.setRunning(!gameState.isPaused());
        }
    }

    public GameState getGameState() {
        return gameState;
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }
}