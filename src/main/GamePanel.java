package main;

import javax.swing.JPanel;
import java.awt.*;

import entity.Player;
import object.SuperObject;
import tile.QueueTrees;
import tile.Tile;
import tile.TileManeger;

public class GamePanel extends JPanel implements Runnable{
    final int FPS = 60;
    public final int basicTitleSize = 32;

    //final int scale= 2;
    //final it tileSize =  basicTitleSize * scale; // 64

    public final  int maxScreenCol = 48;
    public final int maxScreenRow = 27;

    public final int screemWidth = basicTitleSize * maxScreenCol;  //1536px

    public final int screemHeight = basicTitleSize * maxScreenRow; // 864px
    private KeyHandler keyHandler;
    Thread gameThread;
    public Player player;

    public final int maxWorldCol = 160;
    public final int maxWorldRow = 90;
    public final int worldWidth = basicTitleSize * maxWorldCol;
    public final int worldHeight = basicTitleSize * maxWorldRow;

    public TileManeger tileM = new TileManeger(this);

    //Player player = new Player();
    //MainDrawing mainDrawing = new MainDrawing();
    public AssetSetter aSetter = new AssetSetter(this);
    public CollisionChecker cChecker = new CollisionChecker(this);
    public SuperObject[] obj = new SuperObject[10];
    public DropObjectManager dObjMan = new DropObjectManager();

    public QueueTrees qT = new QueueTrees(this);
    public UI ui = new UI(this);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screemWidth, screemHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        keyHandler = new KeyHandler();
        player = new Player(this, keyHandler);
        this.addKeyListener(keyHandler);
    }



    public void setupGame(){
        aSetter.setObject();
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();


    }


    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

       // cChecker.list.updateOfQueueTrees();

        while(gameThread != null) {

            //long currentTime = System.nanoTime();
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
//
//            if (timer >= 1000000000) {
//                System.out.println("FPS: " + drawCount);
//                timer = 0;
//            }
        }

    }

    public void update(){

        player.update();

       // qT.updateOfQueueTrees();
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);


        for(int i =0; i < obj.length; i++) {
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }


        }
        player.draw(g2);

        if(keyHandler.itemsPressed){
            ui.draw(g2);
        }
//        if(ui.messageOn){
//            g2.drawString(ui.message, basicTitleSize/2, basicTitleSize/2);
//        }

        g2.dispose();

    }


}
