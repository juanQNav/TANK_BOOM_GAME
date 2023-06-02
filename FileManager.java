import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager  
{
    //the file it's here in the "./scores.txt" root
    private static final int LEVEL_ONE = 1;
    private static final int LEVEL_TWO = 2;
    private static final int LEVEL_THREE = 3;
    private static final String FILE_SCORE_ONE = "scoreLevelOne.txt";
    private static final String FILE_SCORE_TWO = "scoreLevelTwo.txt";
    private static final String FILE_SCORE_THREE = "scoreLevelThree.txt";
    
    
    public static void registerScore(String playersName, int score, int level) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(selectFileLevel(level), true))) {
            writer.println(playersName + "," + score);
        } catch (IOException e) {
            System.out.println("Error al registrar el puntaje: " + e.getMessage());
        }
    }

    public static List<RecordScore> getAllRecordScores(int level) {
        List<RecordScore> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(selectFileLevel(level)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String playersName =parts[0]; 
                    int score = Integer.parseInt(parts[1]);
                    RecordScore scoreObj = new RecordScore(playersName, score);
                    scores.add(scoreObj);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer los puntajes: " + e.getMessage());
        }
        return scores;
    }
    
    private static final String selectFileLevel(int level){
        switch(level){
            case LEVEL_ONE:
                   return FILE_SCORE_ONE;
            case LEVEL_TWO:
                    return FILE_SCORE_TWO;
            case LEVEL_THREE:
                    return FILE_SCORE_THREE;
            default: return null;
        }
    }
}
