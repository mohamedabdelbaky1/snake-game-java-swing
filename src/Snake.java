import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Snake {
    private LinkedList<Point> body;
    private Direction direction;
    private boolean growOnNextMove;
    
    Snake(int startX , int startY){
        body = new LinkedList<>();
        body.add(new Point(startX , startY));
        body.add(new Point(startX-1 , startY));
        body.add(new Point(startX-2 , startY));

        direction = Direction.RIGHT;
        growOnNextMove = false;
    }

    public void move() {
        Point head = body.getFirst();
        Point newHead;

        switch (direction) {
            case UP:
                newHead = new Point(head.x, head.y - 1);
                break;
            case DOWN:
                newHead = new Point(head.x, head.y + 1);
                break;
            case LEFT:
                newHead = new Point(head.x - 1, head.y);
                break;
            case RIGHT:
                newHead = new Point(head.x + 1, head.y);
                break;
            default:
                newHead = new Point(head.x, head.y);
        }

        body.addFirst(newHead);

        if (!growOnNextMove) {
            body.removeLast();
        } 
        else {
            growOnNextMove = false;
        }

    }

    public void grow(){
        growOnNextMove = true;
    }

    public boolean hitsItself() {
        Point head = getHead();

        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                return true;
            }
        }

        return false;
    }

    public List<Point> getBody(){
        return body;
    }

    public Point getHead(){
        return body.getFirst();
    }

        public Direction getDirection(){
        return direction;
    }

    public void setDirection(Direction newDirection) {
        if (direction == Direction.UP && newDirection == Direction.DOWN) return;
        if (direction == Direction.DOWN && newDirection == Direction.UP) return;
        if (direction == Direction.LEFT && newDirection == Direction.RIGHT) return;
        if (direction == Direction.RIGHT && newDirection == Direction.LEFT) return;

        direction = newDirection;
    }
}
