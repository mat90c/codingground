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

        for (int i = 0; i <tempData.length;i++)
        {
            String [] lineTemp = tempData[i].split(";");

            category = Byte.decode(lineTemp[0]);
            intensity = Short.decode(lineTemp[1]);
            steps = Short.decode(lineTemp[2]);
            timeStamp = Long.decode(lineTemp[3]);
            //heartValue = Short.decode(lineTemp[4]);

            data.add(new ActivityData(timeStamp, intensity, steps, category, heartValue));
        }

        return data;
    } 
	
	
	public int getMode(int category, int intensity, int steps)
	{
		if (intensity <= 3.333333) {
    if (intensity <= 0) {
        if (steps <= 0) return 0;
        if (steps > 0) {
            if (steps <= 35) {
                if (steps <= 0.666667) return 1;
                if (steps > 0.666667) return 0;
            }
            if (steps > 35) return 0;
        }
    }
    if (intensity > 0) return 0;
}
if (intensity > 3.333333) {
    if (steps <= 1) {
        if (category == 0) return 0;
        if (category == 1) return 0;
        if (category == 2) return 0;
        if (category == 3) return 0;
        if (category == 4) return 0;
        if (category == 5) {
            if (steps <= 0) return 0;
            if (steps > 0) {
                if (steps <= 0.333333) return 2;
                if (steps > 0.333333) return 1;
            }
        }
        if (category == 6) return 0;
        if (category == 7) return 0;
        if (category == 9) return 0;
        if (category == 11) return 0;
        if (category == 15) return 0;
    }
    if (steps > 1) {
        if (steps <= 33) {
            if (steps <= 21) return 1;
            if (steps > 21) {
                if (category == 0) return 1;
                if (category == 1) return 1;
                if (category == 2) return 1;
                if (category == 3) return 1;
                if (category == 4) {
                    if (steps <= 22.333333) return 0;
                    if (steps > 22.333333) return 1;
                }
                if (category == 5) return 1;
                if (category == 6) return 0;
                if (category == 7) return 1;
                if (category == 9) return 0;
                if (category == 11) return 1;
                if (category == 15) return 1;
            }
        }
        if (steps > 33) {
            if (steps <= 42.666667) {
                if (steps <= 35) return 0;
                if (steps > 35) return 3;
            }
            if (steps > 42.666667) return 0;
        }
    }
}
		
		return 0;
	}
	
}