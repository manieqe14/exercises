package MergedStringChecker;

import java.util.ArrayList;

public class StringMerger {

    public static void main(String[] args){
        ArrayList<String[]> examples = new ArrayList<>();
        examples.add(new String[]{"codewars", "code", "wars"});
        examples.add(new String[]{"codewars", "cdwr", "oeas"});
        examples.add(new String[]{"codewars", "cod", "wars"});
        examples.add(new String[]{"Bananas from Bahamas", "Bahas","Bananas from am"});

        for(String[] example : examples){
            System.out.println("'" + example[0] + "' is merge from '" + example[1] + "' and '" + example[2] + "'?\t" + isMerge(example[0], example[1], example[2]));
        }


    }

    public static boolean isMerge(String s, String part1, String part2) {

        //System.out.println(s + " is merged from " + part1 + " and " + part2);
        if(((part1.trim() == "") && (part2 != s)) || ((part2.trim() == "") && (part1 != s))){return false;}
        int markerString1 = 0;
        int markerString2 = 0;
        part1 = part1 + " ";
        part2 = part2 + " ";
        

        for(int i = 0; i < s.length(); i++){
                if (s.charAt(i) == part1.charAt(markerString1)) {
                    markerString1++;
                } else if (s.charAt(i) == part2.charAt(markerString2)) {
                    markerString2++;
                } else {
                    return false;
                }
        }
        if((markerString1 != part1.length()-1) || (markerString2 != part2.length()-1)) return false;
        return true;
    }
}
