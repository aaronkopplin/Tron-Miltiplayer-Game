public class Grid {
    int[][] grid;
    int currRow;
    int width = 30;
    int height = 50;
    boolean filled = false;

    public Grid(){
        grid = new int[width][height];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                grid[i][j] = -1;
            }
        }
        currRow = height-1;
    }

    public void fillRow(int id){
        for (int i = 0; i < grid.length; i++){
            grid[i][currRow] = id;
        }
        if (currRow > 0){
            currRow--;
        } else {
            filled = true;
        }
    }

    public boolean isFilled(){
        return filled;
    }

    public void removeId(int id){
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == id){
                    grid[i][j] = -1;
                }
            }
        }
    }

    public int get(int i, int j) {
        return this.grid[i][j];
    }

    public void set(int i, int j, int id){
        grid[i][j] = id;
    }

    public void set(int i, int j, Player player){
        if (grid[i][j] == -1){
            this.grid[i][j] = player.getId();
        } else {
            player.die();
        }
    }

    public int width() {
        return grid.length;
    }
    public int height() {
        return grid[0].length;
    }
}
