import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Level extends World
{
    private SimpleTimer timerHud = new SimpleTimer();
    private SimpleTimer timerSpawnEnemy = new SimpleTimer();
    private SimpleTimer timerSpawnPowerUp = new SimpleTimer();
    protected int time = 120;
    protected int score = 0;
    protected Player player = new Player(4);
    protected Eagle eagle = new Eagle();
    protected int enemyDied = 0;
    protected int previousEnemyDied = 0;

    public Level(int x, int y, int px)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(x, y, px);
        setPaintOrder(Bush.class, Enemy.class); 
    }

    public void updateScore(int score){
        this.score += score;
    }

    public void alterTime(int time){
        this.time -= time;
    }

    protected void checkTime(){
        if(time <= 0) {
            Greenfoot.setWorld(new GameOver());
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

    protected void spawPowerUp(){
        if(timerSpawnPowerUp.millisElapsed() >= 15000){
            SpawnManager spawnManager = new SpawnManager(this);
            spawnManager.spawnObject(new Shield()); 
            timerSpawnPowerUp.mark();
        }else if(timerSpawnPowerUp.millisElapsed() >= 30000){
            SpawnManager spawnManager = new SpawnManager(this);
            spawnManager.spawnObject(new Time()); 
            timerSpawnPowerUp.mark();
        }
    }

    public void updateEnemyDied(int enemyDied){
        this.enemyDied += enemyDied;
    }

    protected abstract void prepare();
}
