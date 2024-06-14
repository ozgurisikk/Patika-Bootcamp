public class Snake extends Obstacle{

    public Snake() {
        super(4, "Snake", snakeDmg() , 12, 0);

    }

    private static int snakeDmg(){
        int dmg = (int)(Math.random() * (7 - 3)) + 3;
        return dmg;
    }
}
