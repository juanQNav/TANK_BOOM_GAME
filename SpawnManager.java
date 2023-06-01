import java.util.List;
import java.util.Random;
import greenfoot.*;

public class SpawnManager <T extends Actor> {
    private World world;
    private Random random;
    private int x = 70;
    private int y = 180;
    
    public SpawnManager(World world) {
        this.world = world;
        this.random = new Random();
    }

    public void spawnObject(T object) {        
        do {
            x = random.nextInt(901); 
            y = random.nextInt(601);
        } while (!isValidSpawnLocation(x, y));
        
        world.addObject(object, x, y);
    }

    private boolean isValidSpawnLocation(int x, int y) {
        List<Block> objects = world.getObjects(Block.class);
        for (Block object : objects) {
            if (object.getX() == x || object.getY() == y) {
                return false;
            }
        }
        return true;
    }
}
