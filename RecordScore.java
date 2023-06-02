public  class RecordScore {
    private String playersName;
    private int score;

    public RecordScore(String playersName, int score) {
        this.playersName = playersName;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getPlayersName() {
        return playersName;
    }

    @Override
    public String toString() {
        return "Name: " + playersName + ", Score: " + score;
    }
}