package HumanReadableDurationFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class TimeFormatter {

    public static void main(String[] args){
        int[] durations = {1, 62, 120, 3600, 3662};
        for(int duration : durations){
            System.out.println(duration + ":\t" + formatDuration2(duration));
        }

    }

    public static String formatDuration(int seconds){
        if(seconds < 1){return "now";}
        LinkedHashMap<String, Integer> units = new LinkedHashMap<>();
        ArrayList<String[]> counts = new ArrayList<>();
        units.put("year",  365 * 24 * 60 * 60);
        units.put("day", 60 * 60 * 24);
        units.put("hour", 60 * 60);
        units.put("minute", 60);
        units.put("second", 1);

        StringBuffer result = new StringBuffer();

        for(String i : units.keySet()){
           int a = units.get(i);
           if(seconds/units.get(i) > 0) {
               if(seconds/units.get(i) > 1){
                   counts.add(new String[]{Integer.toString(seconds / units.get(i)),i + "s"});
               }
               else{
                   counts.add(new String[]{Integer.toString(seconds / units.get(i)),i});
               }

           }
           seconds = seconds % a;
        }

        if(counts.size() == 1){
            result.append(counts.get(0)[0] + " " + counts.get(0)[1]);
        }
        else{
            for(int i = 0; i < counts.size(); i++){
                if(i == 0){
                    result.append(counts.get(i)[0] + " " + counts.get(i)[1]);
                }
                else if(i == counts.size()-1){
                    result.append(" and " + counts.get(i)[0] + " " + counts.get(i)[1]);
                }
                else if((i != counts.size()-1) && (i !=0)){
                    result.append(", " + counts.get(i)[0] + " " + counts.get(i)[1]);
                }
            }
        }
        return result.toString();
    }

    //solution from Kata
    public static String formatDuration2(int seconds) {
        return seconds == 0 ? "now" :
                Arrays.stream(
                                new String[]{
                                        formatTime("year",  (seconds / 31536000)),
                                        formatTime("day",   (seconds / 86400)%365),
                                        formatTime("hour",  (seconds / 3600)%24),
                                        formatTime("minute",(seconds / 60)%60),
                                        formatTime("second",(seconds%3600)%60)})
                        .filter(e->e!="")
                        .collect(Collectors.joining(", "))
                        .replaceAll(", (?!.+,)", " and ");
    }
    public static String formatTime(String s, int time){
        return time==0 ? "" : Integer.toString(time)+ " " + s + (time==1?"" : "s");
    }
}
