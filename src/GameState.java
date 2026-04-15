public class GameState {
    private boolean running;
    private boolean paused;
    private boolean gameOver;
    private boolean started;
    private int score;

    public GameState() {
        running = false;
        paused = false;
        gameOver = false;
        started = false;
        score = 0;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void reset() {
        running = false;
        paused = false;
        gameOver = false;
        started = false;
        score = 0;
    }
}