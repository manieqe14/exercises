package LambdaExercises.SamouczekProgramisty.Tasks;

import java.util.ArrayList;

public class First {
    public static void main(String[] args){
        ArrayList<String> words = new ArrayList<>();
        words.add("333");
        words.add("55555");
        words.add("1");

        System.out.println("before sorting: " + words.toString());
        words.sort((o1, o2) -> o2.length() - o1.length());
        System.out.println("after sorting: " + words.toString());
    }
}
