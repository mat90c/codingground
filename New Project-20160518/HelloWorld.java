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
		
        double Distance = 0;
        double max = 0;
		
        for(int i=start;i<start+800;i++)
        {
			//Distance è il numero di 0 della variabile intensity in una finestra temporale di dimensione 5 
			//Max è il massimo della variabile intensity in una finestra temporale di dimensione 5 
            if(i>5)
            {
				Distance = 0;
				if(data.get(i).getIntensity()==0)
					Distance++;
				if(data.get(i-1).getIntensity()==0)
					Distance++;
				if(data.get(i-2).getIntensity()==0)
					Distance++;
				if(data.get(i-3).getIntensity()==0)
					Distance++;
				if(data.get(i-4).getIntensity()==0)
					Distance++;
				
				max=0;
				max = Math.max(max,data.get(i).getIntensity());
				max = Math.max(max,data.get(i-1).getIntensity());
				max = Math.max(max,data.get(i-2).getIntensity());
				max = Math.max(max,data.get(i-3).getIntensity());
				max = Math.max(max,data.get(i-4).getIntensity());
            }
            ActivityData d = data.get(i);
            System.out.println(sdf.format(d.getTimestamp()*1000)+" "+d.getTimestamp()+";"+d.getCategory()+";"+d.getIntensity()+";"+d.getSteps()+" = "+sleep.getMode(d.getCategory(),d.getIntensity(),d.getSteps(), Distance, max));
        }
     }
}
