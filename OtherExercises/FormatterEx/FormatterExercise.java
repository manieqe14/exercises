package OtherExercises.FormatterEx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FormatterExercise {

    public static void main(String args[]) throws IOException {
        List<String> data = Files.readAllLines(Paths.get("src/main/java/OtherExercises/FormatterEx/data.txt"));
        for(String item : data){
            String[] columns = item.split(",");
            System.out.format("| %-8s | %-8.2f | %-12s |\n",columns[0], Double.parseDouble(columns[1]), columns[2]);
        }
    }
}
