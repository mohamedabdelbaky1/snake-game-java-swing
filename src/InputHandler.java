import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {

    private final GameController controller;

    public InputHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_ENTER) {
            controller.startGame();
            return;
        }

        if (key == KeyEvent.VK_R) {
            controller.resetGame();
            return;
        }

        if (key == KeyEvent.VK_P) {
            controller.togglePause();
            return;
        }

        switch (key) {
            case KeyEvent.VK_UP:
                controller.changeDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                controller.changeDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                controller.changeDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                controller.changeDirection(Direction.RIGHT);
                break;
        }
    }
}