import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Level extends World
{
    private SimpleTimer timerHud = new SimpleTimer();
    private SimpleTimer timerSpawnEnemy = new SimpleTimer();
    private SimpleTimer timerSpawnPowerUpShield = new SimpleTimer();
    private SimpleTimer timerSpawnPowerUpTime = new SimpleTimer();
    private int level;
    protected int time = 120;
    protected int score = 0;
    protected Player player = new Player(1);
    protected Eagle eagle = new Eagle();
    protected int enemyDied = 0;
    protected int previousEnemyDied = 0;
    
    public Level(int x, int y, int px, int level)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(x, y, px);
        setPaintOrder(GreenfootImage.class, Bush.class, Block.class, Tank.class);
        this.level = level;
        
    }

    protected void checkTime(){
        if(time <= 0) {
            Greenfoot.setWorld(new GameOver(score, level));
        }
    }

    protected void updateHud(){
        showText("Score: " + score, getWidth() - 100,20);
        showText("Lives: " + eagle.getLifes(), getWidth() - 100,40);
        if (timerHud.millisElapsed() >= 1000) {
            timerHud.mark();
            time--;
            showText("Game Time: " + time + " s", getWidth() - 100, 60);
        }
    }

    protected void spawnEnemyWhenAnotherDied(){
        if (enemyDied > previousEnemyDied && timerSpawnEnemy.millisElapsed() >= 200) {
            SpawnManager spawnManager = new SpawnManager(this);
            spawnManager.spawnObject(new Enemy(1)); 
            previousEnemyDied = enemyDied;
            timerSpawnEnemy.mark();
        }
    }

    protected void spawnPowerUp(){
        if(timerSpawnPowerUpShield.millisElapsed() >= 15000){
            SpawnManager spawnManager = new SpawnManager(this);
            spawnManager.spawnObject(new Shield()); 
            timerSpawnPowerUpShield.mark();
        }else if(timerSpawnPowerUpTime.millisElapsed() >= 30000){
            SpawnManager spawnManager = new SpawnManager(this);
            spawnManager.spawnObject(new Time()); 
            timerSpawnPowerUpTime.mark();
        }
    }
    public void updateEnemyDied(int enemyDied){
        this.enemyDied += enemyDied;
    }
    public void updateScore(int score){
        this.score += score;
    }

    public void alterTime(int time){
        this.time -= time;
    }
    public int getScore(){
        return score;
    }
    public int getLevel(){
        return level;
    }
    protected abstract void prepare();
}
