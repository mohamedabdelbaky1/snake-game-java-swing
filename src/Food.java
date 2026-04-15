import java.awt.Point;
import java.util.List;
import java.util.Random;

public class Food {
    private Point position;
    private final Random random;

    public Food() {
        random = new Random();
    }

    public void spawn(int columns, int rows, List<Point> snakeBody) {
        Point newPosition;
        boolean onSnake;

        do {
            int x = random.nextInt(columns);
            int y = random.nextInt(rows);
            newPosition = new Point(x, y);

            onSnake = false;
            for (Point part : snakeBody) {
                if (part.equals(newPosition)) {
                    onSnake = true;
                    break;
                }
            }

        } while (onSnake);

        position = newPosition;
    }

    public Point getPosition() {
        return position;
    }
}