import java.awt.*;
import java.util.ArrayList;

public class Player {
    private int id, x, y;
    private Direction dir;
    private boolean canMove = true;
    private boolean dead = false;
    private ArrayList<Point> trail = new ArrayList<>();

    public Player(int id, int x, int y, Direction dir) {
        this.id = id;
        this.x = x;
        this.y = y;
        trail = new ArrayList<>();
        trail.add(new Point(this.x, this.y));
        this.dir = dir;
    }

    public ArrayList<Point> getTrail(){
        return trail;
    }

    public void move() {
        if (canMove){
            trail.add(new Point(this.x, this.y));
            switch (this.dir){
                case NORTH:
                    y--;
                    break;
                case EAST:
                    x++;
                    break;
                case SOUTH:
                    y++;
                    break;
                case WEST:
                    x--;
                    break;
            }
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void die(){
        dead = true;
    }

    public void setCanMove(boolean canMove){
        this.canMove = canMove;
    }

    public int getId(){
        return id;
    }

    public void setDir(Direction dir){
        boolean change = false;
        switch (dir){
            case NORTH:
                if (this.dir != Direction.SOUTH){
                    change = true;
                }
                break;
            case EAST:
                if (this.dir != Direction.WEST){
                    change = true;
                }
                break;
            case SOUTH:
                if (this.dir != Direction.NORTH){
                    change = true;
                }
                break;
            case WEST:
                if (this.dir != Direction.EAST){
                    change = true;
                }
                break;
        }

        if (change){
            this.dir = dir;
        }
    }
}
