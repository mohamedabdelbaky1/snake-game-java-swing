import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;


public class GamePanel extends JPanel {

    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 600;
    public static final int UNIT_SIZE = 25;

    public static final int COLUMNS = SCREEN_WIDTH / UNIT_SIZE ; 
    public static final int ROWS = SCREEN_HEIGHT / UNIT_SIZE ; 

    private static final int DELAY = 150;
    private final Timer timer;


    private final GameController controller;

    public GamePanel(){
        controller = new GameController();
        
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);

        this.addKeyListener(new InputHandler(controller));


        timer = new Timer(DELAY, e -> {
            controller.update();
            repaint();
        });

        timer.start(); 
        this.requestFocusInWindow();
    }

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    drawGrid(g);
    drawFood(g);
    drawSnake(g);
    drawBoardInfo(g);

    if (!controller.getGameState().isStarted()) {
        drawStartScreen(g);
    }

    if (controller.getGameState().isPaused()) {
        drawPaused(g);
    }

    if (controller.getGameState().isGameOver()) {
        drawGameOver(g);
    }
}

       private void drawGrid(Graphics g) {
        g.setColor(Color.DARK_GRAY);

        for (int x = 0; x <= SCREEN_WIDTH; x += UNIT_SIZE) {
            g.drawLine(x, 0, x, SCREEN_HEIGHT);
        }

        for (int y = 0; y <= SCREEN_HEIGHT; y += UNIT_SIZE) {
            g.drawLine(0, y, SCREEN_WIDTH, y);
        }
    }

        private void drawFood(Graphics g) {
        Point foodPosition = controller.getFood().getPosition();
        int pixelX = foodPosition.x * UNIT_SIZE;
        int pixelY = foodPosition.y * UNIT_SIZE;

        g.setColor(Color.RED);
        g.fillOval(pixelX, pixelY, UNIT_SIZE, UNIT_SIZE);
    }

     private void drawBoardInfo(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("Snake Game Board", 240, 20);
        g.drawString("Columns: " + COLUMNS, 20, 20);
        g.drawString("Rows: " + ROWS, 20, 40);
        g.drawString("Unit Size: " + UNIT_SIZE, 20, 60);
    }

    private void drawSnake(Graphics g) {
        for (Point part : controller.getSnake().getBody()) {
            int pixelX = part.x * UNIT_SIZE;
            int pixelY = part.y * UNIT_SIZE;

            g.setColor(Color.GREEN);
            g.fillRect(pixelX, pixelY, UNIT_SIZE, UNIT_SIZE);

            g.setColor(Color.BLACK);
            g.drawRect(pixelX, pixelY, UNIT_SIZE, UNIT_SIZE);
        }

        Point head = controller.getSnake().getHead();
        int headX = head.x * UNIT_SIZE;
        int headY = head.y * UNIT_SIZE;

        g.setColor(new Color(0, 180, 0));
        g.fillRect(headX, headY, UNIT_SIZE, UNIT_SIZE);

        g.setColor(Color.BLACK);
        g.drawRect(headX, headY, UNIT_SIZE, UNIT_SIZE);
    }

    private void drawPaused(Graphics g) {
    String pausedText = "Paused";

    g.setColor(Color.YELLOW);
    g.setFont(new Font("Arial", Font.BOLD, 50));

    FontMetrics metrics = getFontMetrics(g.getFont());
    int x = (SCREEN_WIDTH - metrics.stringWidth(pausedText)) / 2;
    int y = SCREEN_HEIGHT / 2;

    g.drawString(pausedText, x, y);
}

private void drawStartScreen(Graphics g) {
    String titleText = "Snake Game";
    String startText = "Press Enter to Start";
    String controlsText = "Arrow Keys = Move | P = Pause | R = Restart";

    g.setColor(Color.GREEN);
    g.setFont(new Font("Arial", Font.BOLD, 50));

    FontMetrics titleMetrics = getFontMetrics(g.getFont());
    int titleX = (SCREEN_WIDTH - titleMetrics.stringWidth(titleText)) / 2;
    int titleY = SCREEN_HEIGHT / 2 - 40;

    g.drawString(titleText, titleX, titleY);

    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.BOLD, 28));

    FontMetrics startMetrics = getFontMetrics(g.getFont());
    int startX = (SCREEN_WIDTH - startMetrics.stringWidth(startText)) / 2;
    int startY = SCREEN_HEIGHT / 2 + 10;

    g.drawString(startText, startX, startY);

    g.setFont(new Font("Arial", Font.PLAIN, 18));
    FontMetrics controlsMetrics = getFontMetrics(g.getFont());
    int controlsX = (SCREEN_WIDTH - controlsMetrics.stringWidth(controlsText)) / 2;
    int controlsY = startY + 40;

    g.drawString(controlsText, controlsX, controlsY);
}

    private void drawGameOver(Graphics g) {
    String gameOverText = "Game Over";
    String scoreText = "Final Score: " + controller.getGameState().getScore();
    String restartText = "Press R to Restart";

    g.setColor(Color.RED);
    g.setFont(new Font("Arial", Font.BOLD, 50));

    FontMetrics metrics1 = getFontMetrics(g.getFont());
    int x1 = (SCREEN_WIDTH - metrics1.stringWidth(gameOverText)) / 2;
    int y1 = SCREEN_HEIGHT / 2;

    g.drawString(gameOverText, x1, y1);

    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.BOLD, 30));

    FontMetrics metrics2 = getFontMetrics(g.getFont());
    int x2 = (SCREEN_WIDTH - metrics2.stringWidth(scoreText)) / 2;
    int y2 = y1 + 50;

    g.drawString(scoreText, x2, y2);

    g.setFont(new Font("Arial", Font.PLAIN, 24));
    FontMetrics metrics3 = getFontMetrics(g.getFont());
    int x3 = (SCREEN_WIDTH - metrics3.stringWidth(restartText)) / 2;
    int y3 = y2 + 45;

    g.drawString(restartText, x3, y3);
}

}
