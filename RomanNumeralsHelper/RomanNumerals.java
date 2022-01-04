package RomanNumeralsHelper;

import java.util.LinkedHashMap;

public class RomanNumerals {

    public static void main(String[] args){
        int[] examples = {2008, 1990, 1666};
        String[] examplesReversed = {"II", "CMLXXXVIII", "IV"};

        for(int example : examples){
            System.out.println(example + " in Roman: " + toRoman(example));
        }

        for(String example : examplesReversed){
            System.out.println(example + " from Roman: " + fromRoman(example));
        }

    }

    public static String toRoman(int n) {
        if (n > 4000 || n < 1) return null;
        LinkedHashMap<Integer, String> symbols = new LinkedHashMap<>();
        symbols.put(1000, "M");
        symbols.put(500, "D");
        symbols.put(100, "C");
        symbols.put(50, "L");
        symbols.put(10, "X");
        symbols.put(5, "V");
        symbols.put(1, "I");

        StringBuffer result = new StringBuffer();

        for(int i = 0; i < symbols.size(); i+=2){
            StringBuffer digit = new StringBuffer();
            for(int y = 0; y < n/((int)symbols.keySet().toArray()[i]); y++){
                if(y==3) {
                    digit.delete(0, 2);
                    digit.append(symbols.values().toArray()[i-1]);
                }
                else if(y == 8){
                    digit.delete(0, 3);
                    digit.append(symbols.values().toArray()[i-2]);
                }
                else if(y < 3 || y > 4){
                    digit.append(symbols.values().toArray()[i]);
                }
                else{
                    digit.deleteCharAt(0);
                }
            }
            result.append(digit);
            n = n % (int) symbols.keySet().toArray()[i];
        }
        return result.toString();
    }

    public static int fromRoman(String romanNumeral) {
        LinkedHashMap<Character, Integer> symbols = new LinkedHashMap<>();
        symbols.put('M', 1000);
        symbols.put('D', 500);
        symbols.put('C', 100);
        symbols.put('L', 50);
        symbols.put('X', 10);
        symbols.put('V', 5);
        symbols.put('I', 1);

        int result = 0;

        for(int i=0; i < romanNumeral.length(); i++){
            if(i == romanNumeral.length()-1){
                result+=symbols.get(romanNumeral.charAt(i));
            }
            else if(romanNumeral.charAt(i) == romanNumeral.charAt(i+1)){
                result+=symbols.get(romanNumeral.charAt(i));
            }
            else if(symbols.get(romanNumeral.charAt(i)) > symbols.get(romanNumeral.charAt(i+1))){
                result+=symbols.get(romanNumeral.charAt(i));
            }
            else{
                result-=symbols.get(romanNumeral.charAt(i));
            }
        }
        return result;
    }

}
