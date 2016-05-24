import java.util.*;
import java.text.*;
import java.io.*;

public class HelloWorld{

		public static int mode(int a[]) {
			
			if(a[0]!=a[1] && a[1]!=a[2] && a[2]!=a[3] && a[3]!=a[4])
				return -1;				
			
			int maxValue=-1, maxCount=0;

			for (int i = 0; i < a.length; ++i) {
				int count = 0;
				for (int j = 0; j < a.length; ++j) {
					if (a[j] == a[i]) ++count;
				}
				if (count > maxCount) {
					maxCount = count;
					maxValue = a[i];
				}
			}

			return maxValue;
		}


     public static void main(String []args){
        //System.out.println("Hello World");
        Sleep sleep = new Sleep();
        
         String pattern = "yyyy-MM-dd HH:mm:ss";
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    sdf.setTimeZone(TimeZone.getTimeZone("Europe/Rome"));
        
        //ArrayList<ActivityData> data = sleep.loadData(RawData1.part1+RawData2.part2+RawData3.part3);
        ArrayList<ActivityData> data = sleep.loadDataFile("rawdata.csv");
		
		
        final int start = 0;
		
        double Distance = 0;
        double max = 0;
        double mode = 0;
		
		PrintWriter out = null;
		try{
			out = new PrintWriter("esito.csv");
		}
		catch(Exception e){return;}
        for(int i=start;i<start+1200000;i++)
        {
			if(i>=data.size())
				return;
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
				
				
				mode = mode(new int[]{data.get(i).getCategory(),data.get(i-1).getCategory(),data.get(i-2).getCategory(),data.get(i-3).getCategory(),data.get(i-4).getCategory()});
            }
            ActivityData d = data.get(i);
            
			int valoreCalcolato = sleep.getMode(d.getCategory(),d.getIntensity(),d.getSteps(), Distance, max, mode);
			
			String riga = sdf.format(d.getTimestamp()*1000)+";"+d.getTimestamp()+";"+d.getCategory()+";"+d.getIntensity()+";"+d.getSteps();
			if(d.getValoreAtteso()>=0){
				riga +="; atteso=;"+d.getValoreAtteso();
			}
			riga +="; vs;"+valoreCalcolato;
			if(d.getValoreAtteso()>0){
				if(valoreCalcolato==0)
					riga +=";   ERRORE";
					else
					riga +=";   OK";
			}
			
			System.out.println(riga);

			out.println(riga);
        }
		
		out.close();
     }
}
