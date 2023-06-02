import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager  
{
    //the file it's here in the "./scores.txt" root
    private static final String FILE_NAME = "scores.txt";

    /*public static void main(String[] args) {
        registerScore(100, 10);
        registerScore(200, 15);
        registerScore(150, 12);

        List<Score> scores = getAllScores();
        System.out.println("Puntajes registrados:");
        for (Score score : scores) {
            System.out.println(score);
        }
    }*/

    public static void registerScore(int score, int time) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            writer.println(score + "," + time);
        } catch (IOException e) {
            System.out.println("Error al registrar el puntaje: " + e.getMessage());
        }
    }

    public static List<Score> getAllScores() {
        List<Score> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    int score = Integer.parseInt(parts[0]);
                    int time = Integer.parseInt(parts[1]);
                    Score scoreObj = new Score(score, time);
                    scores.add(scoreObj);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer los puntajes: " + e.getMessage());
        }
        return scores;
    }

    static class Score {
        private int score;
        private int time;

        public Score(int score, int time) {
            this.score = score;
            this.time = time;
        }

        public int getScore() {
            return score;
        }

        public int getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "Puntaje: " + score + ", Tiempo: " + time;
        }
    }
}
