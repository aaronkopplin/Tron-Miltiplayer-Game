public class Message {
    int[][] GAME_OVER;
    int x;
    int y;
    boolean blank = false;
    int id;

    public Message(int id, int x, int y){
        GAME_OVER = new int[][]
            {
                {id,id,id,-1,-1,-1,id,id,-1,-1,id,id,-1,id,id,id,-1,id,-1,-1,-1,-1,id,id},
                {id,id,-1,id,id,id,id,-1,id,id,-1,id,-1,-1,id,-1,-1,id,-1,id,id,id,id,id},
                {id,id,-1,id,-1,-1,id,-1,-1,-1,-1,id,-1,id,-1,id,-1,id,-1,-1,-1,id,id,id},
                {id,id,-1,id,id,-1,id,-1,id,id,-1,id,-1,id,id,id,-1,id,-1,id,id,id,id,id},
                {id,id,id,-1,-1,-1,id,-1,id,id,-1,id,-1,id,id,id,-1,id,-1,-1,-1,-1,id,id},
                {id,id,id,id,id,id,id,id,id,id,id,id,id,id,id,id,id,id,id,id,id,id,id,id},
                {id,-1,-1,-1,id,id,-1,id,id,id,-1,id,-1,-1,-1,-1,id,-1,-1,-1,id,id,id,-1},
                {-1,id,id,id,-1,id,-1,id,id,id,-1,id,-1,id,id,id,id,-1,id,id,-1,id,id,-1},
                {-1,id,id,id,-1,id,-1,id,id,id,-1,id,-1,-1,-1,id,id,-1,-1,-1,id,id,id,-1},
                {-1,id,id,id,-1,id,id,-1,id,-1,id,id,-1,id,id,id,id,-1,id,id,-1,id,id,id},
                {id,-1,-1,-1,id,id,id,id,-1,id,id,id,-1,-1,-1,-1,id,-1,id,id,-1,id,id,-1}

            };

        this.y = y;
        this.x = x;
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void changeBlank(){
        blank = !blank;
    }

    public boolean isBlank(){
        return blank;
    }

    public int getHeight(){
        return GAME_OVER.length;
    }

    public int getWidth(){
        return GAME_OVER[0].length;
    }
}
