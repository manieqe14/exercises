package PerfectPower;

import java.util.Arrays;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class PerfectPower {

    public static void main(String[]args){
        int[] tests = new int[]{4,8,9,32,36,100,81};
        for(int test : tests){
            System.out.println(test + " is perfect power? " + Arrays.toString(isPerfectPower(test)));
        }
    }

    public static int[] isPerfectPower(int n){
        for(int a = 2; a <= sqrt(n); a++){
            for(int b = 2; pow(a,b) <= n; b++ ){
                if(pow(a,b) == n){
                    return new int[]{a, b};
                }
            }

        }
        return null;
    }
}
