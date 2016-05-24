import java.util.*;

public class Sleep
{
	
	public  ArrayList<ActivityData> loadData(String dataString)
    {
        ArrayList<ActivityData> data = new ArrayList<>();

        String[] tempData = dataString.split("\n");

        long timeStamp;
        short intensity;
        short steps;
        byte category;
        short heartValue = 0;
        int valoreAtteso = 0;

        for (int i = 0; i <tempData.length;i++)
        {
            String [] lineTemp = tempData[i].split(";");

            category = Byte.decode(lineTemp[0]);
            intensity = Short.decode(lineTemp[1]);
            steps = Short.decode(lineTemp[2]);
            timeStamp = Long.decode(lineTemp[3]);
			
			valoreAtteso = -1;
			if(lineTemp.length>4 && lineTemp[4]!="")
				valoreAtteso = Integer.decode(lineTemp[4]);

            data.add(new ActivityData(timeStamp, intensity, steps, category, heartValue, valoreAtteso));
        }

        return data;
    } 
	
	
	public int getMode(int category, int intensity, int steps, double distance, double max, double mode)
	{
        if (category == 0) {
            if (distance <= 0) return 0;
            if (distance > 0) {
                if (distance <= 4) return 1;
                if (distance > 4) return 0;
            }
        }
        if (category == 1) return 0;
        if (category == 3) return 0;
        if (category == 4) {
            if (distance <= 3) return 1;
            if (distance > 3) {
                if (distance <= 4) return 1;
                if (distance > 4) return 0;
            }
        }
        if (category == 5) return 1;
        if (category == 11) {
            if (distance <= 2) return 1;
            if (distance > 2) return 0;
        }
        if (category == 12) return 0;
        if (category == 16) return 0;
        if (category == 17) return 0;
        if (category == 19) return 0;
        if (category == 21) return 1;
        if (category == 28) return 0;
        if (category == 33) return 0;
        if (category == 44) return 0;
        return 0;
    }
}
