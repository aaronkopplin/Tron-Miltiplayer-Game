public class Player {
    int id, x, y;
    Direction dir;
    boolean canMove = true;
    boolean dead = false;

    public Player(int id, int x, int y, Direction dir) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void move() {
        if (canMove){
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

    public boolean isDead(){
        return dead;
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
