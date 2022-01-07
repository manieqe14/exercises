package OtherExercises.FormatterEx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FormatterExercise {

    public static void main(String args[]) throws IOException {

        String[] data = new String(Files.readAllBytes(Paths.get("src/main/java/OtherExercises/FormatterEx/data.txt"))).split("\\n");
        for(String item : data){
            String[] columns = item.split(",");
            System.out.format("| %-8s | %8.2f | %-8s",columns[0], Double.parseDouble(columns[1]), columns[2]);
        }
    }
}
