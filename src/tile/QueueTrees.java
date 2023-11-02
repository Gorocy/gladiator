package tile;

import main.GamePanel;

import java.util.LinkedList;

public class QueueTrees {
    private LinkedList<PairOfInts> list;// = new LinkedList<>();
    GamePanel gp;
    public QueueTrees(GamePanel gp){
        list = new LinkedList<>();
        this.gp = gp;
    }
    public void enqueue(int x, int y) {
        PairOfInts pair = new PairOfInts(x, y);
        list.addLast(pair);
    }

    public PairOfInts dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Empty");
        }

        return list.removeFirst();
    }



    public int size() {
        return list.size();
    }

    public void updateOfQueueTrees() {
        if(!list.isEmpty()) {
            for (PairOfInts pair : list) {
                pair.time++;
                System.out.println("nowy");
            }
            PairOfInts pair = list.getFirst();
            if (pair.time >= 180) {
                //list.removeFirst();
                System.out.println("nowy");
                gp.tileM.mapTileNum[pair.x][pair.y] = 8;
                dequeue();
            }
        }
    }
}




class PairOfInts {
    public int x;
    public int y;
    public int time;

    public PairOfInts(int x, int y) {
        this.x = x;
        this.y = y;
        time = 0;
    }



//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }

}
