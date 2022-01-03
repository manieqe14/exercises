package PhoneDirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PhoneDir {

    public static void main(String[] args) throws IOException {
        //System.out.println(phone(" 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\\n<Anastasia> +48-421-674-8974 Via Quirinal Roma\\n", "1-541-914-3010"));
        String data = new String(Files.readAllBytes(Paths.get("src/main/java/PhoneDirectory/data.txt")));
        String data2 = new String(Files.readAllBytes(Paths.get("src/main/java/PhoneDirectory/data2.txt")));

        String[] numbers1 = {"1-541-754-3010", "48-421-674-8974", "1-908-512-2222", "1-541-754-3010"};
        for(String number : numbers1){
            System.out.println(phone(data, number));
        }
        //test
        System.out.println("\nTESTS");
        String[] numbers2 = {"3-741-984-3090", "1-541-984-3012", "3-098-512-2222",
                "1-541-914-3010", "1-481-512-2222", "6-541-914-3010","8-421-674-8974",
                "1-921-333-2222"};
        for(String number : numbers2){
            System.out.println(phone(data2, number));
        }
    }
    public static String phone(String strng, String num){
        List<String> results = Arrays.stream(strng
                .split("\n"))
                .filter(c->c.contains("+" + num))
                .collect(Collectors.toList());
        if(results.size() > 1) return "Error => Too many people: " + num;
        else if(results.size() == 0) return "Error => Not found: " + num;
        else {
            Pattern namePattern = Pattern.compile("<.*>");
            Matcher nameMatcher = namePattern.matcher(results.get(0));
            nameMatcher.find();
            String name = nameMatcher.group().replaceAll("[<>]","");
            String address = results.get(0).replaceAll("<" + name + ">", "")
                    .replaceAll("[^a-zA-Z0-9]{1,2}+" + num + "[^a-zA-Z0-9]", "")
                    .replaceAll("(\\s)+", " ")
                    .replaceAll("_", " ")
                    .replaceAll("[;,]","")
                    .trim()
                    .replaceAll("^[^a-zA-Z_0-9]", "");
            return "Phone => " + num + ", Name => " + name + ", Address => " + address;
        }
    }
}
