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
        ArrayList<ActivityData> dataList = sleep.loadDataFile("rawdata.csv");
		
		
        final int start = 0;
		
        double Distance = 0;
        double max = 0;
        double mode = 0;
		
		PrintWriter out = null;
		try{
			out = new PrintWriter("esito.csv");
		}
		catch(Exception e){return;}
		
		
		//TODO limitare dataList a meno elementi per test più piccoli
		
		//1. applico primo algoritmo per trovare 1 o 0 (sonno)
		int errori1=0, ok1=0, totali1=0;
		int i=0;
        for(ActivityData data : dataList)
        {
			//Distance è il numero di 0 della variabile intensity in una finestra temporale di dimensione 5 
			//Max è il massimo della variabile intensity in una finestra temporale di dimensione 5 
			//Mode è la mode della variabile category in una finestra temporale di dimensione 5 se non esiste moda si imposta a -1
			
			Distance = 0;
			max=0;
			mode=-1;
			
            if(i>5)
            {
				if(dataList.get(i).getIntensity()==0)
					Distance++;
				if(dataList.get(i-1).getIntensity()==0)
					Distance++;
				if(dataList.get(i-2).getIntensity()==0)
					Distance++;
				if(dataList.get(i-3).getIntensity()==0)
					Distance++;
				if(dataList.get(i-4).getIntensity()==0)
					Distance++;
				
				max = Math.max(max,dataList.get(i).getIntensity());
				max = Math.max(max,dataList.get(i-1).getIntensity());
				max = Math.max(max,dataList.get(i-2).getIntensity());
				max = Math.max(max,dataList.get(i-3).getIntensity());
				max = Math.max(max,dataList.get(i-4).getIntensity());
				
				
				mode = mode(new int[]{dataList.get(i).getCategory(),dataList.get(i-1).getCategory(),dataList.get(i-2).getCategory(),dataList.get(i-3).getCategory(),dataList.get(i-4).getCategory()});
            }
            
			int valoreCalcolato = data.calcType(data.getCategory(),data.getIntensity(),data.getSteps(), Distance, max, mode);
			
			String riga = sdf.format(data.getTimestamp()*1000)+";"+data.getTimestamp()+";"+data.getCategory()+";"+data.getIntensity()+";"+data.getSteps();
			if(data.getValoreAtteso()>=0){
				riga +="; atteso=;"+data.getValoreAtteso();
			}
			riga +="; vs;"+valoreCalcolato;
			if(data.getValoreAtteso()>0){
				if(valoreCalcolato==0){
					riga +=";   ERRORE";
					errori1++;
				}else{
					riga +=";   OK";
					ok1++;
				}
				totali1++;
			}
			
			System.out.println(riga);

			out.println(riga);
			
			i++;
        }
		
		System.out.println("Errori "+errori1);
		out.println("Errori "+errori1);
		System.out.println("Esatti "+ok1);
		out.println("Esatti "+ok1);
		System.out.println("Totale "+totali1);
		out.println("Totale "+totali1);
		
		
		//2. correggo 1 e 0 isolati errati
		for(ActivityData data : dataList)
        {
			
		}
		
		
		//3. applico secondo algoritmo per riconoscere 1 2 3
		
		out.close();
     }
}
