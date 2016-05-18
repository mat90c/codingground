import java.util.*;
import java.text.*;

public class HelloWorld{

     public static void main(String []args){
        //System.out.println("Hello World");
        Sleep sleep = new Sleep();
        
         String pattern = "yyyy-MM-dd HH:mm:ss";
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    sdf.setTimeZone(TimeZone.getTimeZone("Europe/Rome"));
        
        ArrayList<ActivityData> data = sleep.loadData(RawData1.part1+RawData2.part2+RawData3.part3);
        final int start = 1500;
        double categoryAvg = 0;
        double intensityAvg = 0;
        double stepsAvg = 0;
        for(int i=start;i<start+800;i++)
        {
            if(i>3)
            {
                categoryAvg = (data.get(i).getCategory() + data.get(i-1).getCategory() + data.get(i-2).getCategory()) / 3.0;
                intensityAvg = (data.get(i).getIntensity() + data.get(i-1).getIntensity() + data.get(i-2).getIntensity()) / 3.0;
                stepsAvg = (data.get(i).getSteps() + data.get(i-1).getSteps() + data.get(i-2).getSteps()) / 3.0;
            }
            ActivityData d = data.get(i);
            System.out.println(sdf.format(d.getTimestamp()*1000)+" "+d.getTimestamp()+";"+d.getCategory()+";"+d.getIntensity()+";"+d.getSteps()+" = "+sleep.getMode(Math.round(categoryAvg),intensityAvg,stepsAvg));
        }
     }
}
