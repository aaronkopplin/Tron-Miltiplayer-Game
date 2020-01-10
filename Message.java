public class Message {
    int[][] GAME_OVER;
    int x;
    int y;
    int offset;

    public Message(int id, int x, int y){
        GAME_OVER = new int[][]
            {
                {id,-1,-1,-1,id,id,-1,-1,id,id,-1,id,id,id,-1,id,-1,-1,-1,-1,id,id,id,-1,-1,-1,id,id,-1,id,id,id,-1,id,-1,-1,-1,-1,id,-1,-1,-1,id,id,id,-1},
                {-1,id,id,id,id,-1,id,id,-1,id,-1,-1,id,-1,-1,id,-1,id,id,id,id,id,-1,id,id,id,-1,id,-1,id,id,id,-1,id,-1,id,id,id,id,-1,id,id,-1,id,id,-1},
                {-1,id,-1,-1,id,-1,-1,-1,-1,id,-1,id,-1,id,-1,id,-1,-1,-1,id,id,id,-1,id,id,id,-1,id,-1,id,id,id,-1,id,-1,-1,-1,id,id,-1,-1,-1,id,id,id,-1},
                {-1,id,id,-1,id,-1,id,id,-1,id,-1,id,id,id,-1,id,-1,id,id,id,id,id,-1,id,id,id,-1,id,id,-1,id,-1,id,id,-1,id,id,id,id,-1,id,id,-1,id,id,id},
                {id,-1,-1,-1,id,-1,id,id,-1,id,-1,id,id,id,-1,id,-1,-1,-1,-1,id,id,id,-1,-1,-1,id,id,id,id,-1,id,id,id,-1,-1,-1,-1,id,-1,id,id,-1,id,id,-1}
            };

        this.y = y;
        this.x = x;
        this.offset = -40;
    }

    public int getHeight(){
        return GAME_OVER.length;
    }

    public int getWidth(){
        return GAME_OVER[0].length;
    }
//
//    public int[][] getShortMessage(int x, int width){
//        int[][] ans = new int[x][width];
//    }
}
