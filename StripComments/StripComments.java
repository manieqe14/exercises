package StripComments;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StripComments {

    public static void main(String[] args){
        String data = "a \n" +
                " b \n" +
                "c ";
        String[] commentSymbols = {"#", "!"};

        System.out.println(stripComments(data,commentSymbols));

    }
    public static String stripComments(String text, String[] commentSymbols) {
        return Arrays.stream(text.split("\\n"))
                .map(s->s.replaceAll("[\\s]*" + Arrays.toString(commentSymbols).replaceAll("[,\\s]", "") +".*", ""))
                .map(s->s.replaceAll("[\\s]*$", ""))
                .collect(Collectors.joining("\n"));
    }
}
