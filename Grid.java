import java.awt.*;
import java.util.ArrayList;

public class Grid {
    private int defaultVal = -1;
    private int startMenu = 2;
    private int pauseMenu = 3;
    private int currentFillVal = startMenu;
    private int[][] grid;
    private int width = 30;
    private int height = 50;
    private Player pOne;
    private Player pTwo;
    private ArrayList<Player> players;
    private GameState state = GameState.START_MENU;
    private TextManager textManager = new TextManager();

    public Grid(){
        grid = new int[width][height];
        setNewGame();
    }

    public void setNewGame(){
        state = GameState.START_MENU;
        fill();
        pOne = new Player(0, 15, 10, Direction.SOUTH);
        pTwo = new Player(1, 15, 40, Direction.NORTH);
        players = new ArrayList<>();
        players.add(pOne);
        players.add(pTwo);
    }

    public void update(){
        switch (state){
            case START_MENU:
                if (currentFillVal != startMenu){
                    currentFillVal = startMenu;
                    fill();
                }
                loadString(1, 20, "T R O N");
                break;
            case IN_PROGRESS:
                if (currentFillVal != defaultVal){
                    currentFillVal = defaultVal;
                    fill();
                }
                updatePlayers();
                break;
            case PAUSE_MENU:
                if (currentFillVal != pauseMenu){
                    currentFillVal = pauseMenu;
                    fill();
                }
                loadString(1, 16, "P A U");
                loadString(1, 23, "S E");
                break;
            case GAME_OVER:
                if (currentFillVal != players.get(0).getId()){
                    currentFillVal = players.get(0).getId();
                    fill();
                }
                loadString(1, 16, "G A M E");
                loadString( 1, 23, "O V E R");
                break;
        }
    }

    private void loadString(int x, int y, String word){
        ArrayList<boolean[][]> tron = textManager.makeText(word);
        for (int i = 0; i < tron.size(); i++){
            for (int r = 0; r < tron.get(i).length; r++){
                for (int c = 0; c < tron.get(i)[0].length; c++) {
                    if (tron.get(i)[r][c]){
                        grid[x + c][y + r] = defaultVal;
                    }
                }
            }

            x += tron.get(i)[0].length;
        }
    }

    private void updatePlayers(){
        for (int i = 0; i < players.size(); i++){
            Player p = players.get(i);
            if (p.getX() < 0 || p.getX()  >= width || p.getY() < 0 || p.getY() >= height
                    ||grid[p.getX()][p.getY()] != defaultVal){
                removePlayer(players.get(i));
            } else {
                players.get(i).move();
                ArrayList<Point> trail = players.get(i).getTrail();
                for (int j = 0; j < trail.size(); j++){
                    grid[trail.get(j).x][trail.get(j).y] = players.get(i).getId();
                }
            }
        }
    }

    private void fill(){
        System.out.println("filling");
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                grid[i][j] = currentFillVal;
            }
        }
    }

    public void removePlayer(Player p){
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == p.getId()){
                    grid[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < players.size(); i++){
            if (players.get(i).getId() == p.getId()){
                players.remove(i);
            }
        }

        if (players.size() == 1){
            state = GameState.GAME_OVER;
            players.get(0).setCanMove(false);
        }
    }

    public void changeMenu(){
        switch (state){
            case START_MENU:
                state = GameState.IN_PROGRESS;
                break;
            case IN_PROGRESS:
                state = GameState.PAUSE_MENU;
                break;
            case PAUSE_MENU:
                state = GameState.IN_PROGRESS;
                break;
            case GAME_OVER:
                setNewGame();
                state = GameState.IN_PROGRESS;
                break;
        }
    }

    public void setPlayerOneDirection(Direction d){
        pOne.setDir(d);
    }

    public void setPlayerTwoDirection(Direction d){
        pTwo.setDir(d);
    }

    public int get(int i, int j) {
        return this.grid[i][j];
    }

    public int width() {
        return grid.length;
    }

    public int height() {
        return grid[0].length;
    }
}
