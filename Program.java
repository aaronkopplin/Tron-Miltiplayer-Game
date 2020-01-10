import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Program extends JPanel implements KeyListener {
    JFrame frame;
    int width = 301;
    int height = 501;
    Grid grid;
    long time = System.currentTimeMillis();
    ArrayList<Player> players;
    Player pOne;
    Player pTwo;
    boolean gameOver = false;
    Message message;

    public Program(){
        frame = new JFrame("Tron");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
        this.setPreferredSize(new Dimension(width, height));
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setup();
        loop();
    }

    public void loop(){
        while (true) {
            long currTime = System.currentTimeMillis();
            if (currTime - time > 60){
                repaint();
                time = System.currentTimeMillis();
            }
        }
    }

    public void setup(){
        this.setBackground(new Color(60, 60, 60));
        grid = new Grid();
        pOne = new Player(0, 15, 10, Direction.SOUTH);
        pTwo = new Player(1, 15, 40, Direction.NORTH);
        players = new ArrayList<>();
        players.add(pOne);
        players.add(pTwo);
    }

    public void updatePlayers() {
        if (!gameOver){
            for (int i = 0; i < players.size(); i++) {
                players.get(i).move();
                if (players.get(i).x < 0
                        || players.get(i).y > grid.height()-1
                        || players.get(i).x > grid.width()-1
                        || players.get(i).y < 0
                        || players.get(i).isDead()) {
                    removePlayer(players.get(i));
                    if (players.size() == 1){
                        players.get(0).setCanMove(false);
                        message = new Message(players.get(0).id, 0, 20);
                        gameOver = true;
                        winAnimation();
                    }
                }
            }
            updateGrid();
        } else {
            winAnimation();
        }
    }

    public void removePlayer(Player player){
        grid.removeId(player.getId());
        for (int i = 0; i < players.size(); i++){
            if (players.get(i).getId() == player.getId()){
                players.remove(i);
            }
        }
    }

    public void winAnimation(){
        if (!grid.isFilled()){
            grid.fillRow(players.get(0).getId());
        } else {
            drawMessage();
        }
    }

    public void drawMessage(){
        for (int i = 0; i < message.getHeight(); i++){
            for (int j = 0; j < grid.width; j++){
                if (j+message.offset < message.GAME_OVER[i].length && j+message.offset >= 0)
                    grid.set(j + message.x, i + message.y, message.GAME_OVER[i][j+message.offset]);
                else
                    grid.set(j + message.x, i + message.y, players.get(0).id);
            }
        }
        if (message.offset < 50)
            message.offset++;
        else
            message.offset = -40;
    }

    public void updateGrid(){
        for (int i = 0 ; i < players.size(); i++){
            grid.set(players.get(i).x, players.get(i).y, players.get(i));
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        updatePlayers();
        for (int i = 0; i < grid.width(); i++){
            for (int j = 0; j < grid.height(); j++){
                switch(grid.get(i,j)) {
                    case -1:
                        g.setColor(new Color(100, 100, 100, 100));
                        break;
                    case 0:
                        g.setColor(new Color(255, 250, 100));
                        break;
                    case 1:
                        g.setColor(new Color(120, 255, 170));
                        break;
                }
                int x = (int)(((double)getWidth() / grid.width()) * i);
                int y = (int)(((double)getHeight() / grid.height()) * j);
                int w = (int)((double)getWidth() / grid.width());
                int h = (int)((double)getHeight() / grid.height());

                g.fillRect(x, y, w, h);
                g.setColor(new Color(150, 150, 150));
                g.drawRect(x, y, w, h);
            }
        }
    }

    public static void main(String[] yeet){
        new Program();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                pOne.setDir(Direction.NORTH);
                break;
            case KeyEvent.VK_D:
                pOne.setDir(Direction.EAST);
                break;
            case KeyEvent.VK_S:
                pOne.setDir(Direction.SOUTH);
                break;
            case KeyEvent.VK_A:
                pOne.setDir(Direction.WEST);
                break;
            case KeyEvent.VK_UP:
                pTwo.setDir(Direction.NORTH);
                break;
            case KeyEvent.VK_RIGHT:
                pTwo.setDir(Direction.EAST);
                break;
            case KeyEvent.VK_DOWN:
                pTwo.setDir(Direction.SOUTH);
                break;
            case KeyEvent.VK_LEFT:
                pTwo.setDir(Direction.WEST);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
