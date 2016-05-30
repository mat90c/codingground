public class ActivityData {

    private long timestamp;
    private short intensity;
    private short steps;
    private short category;
    private short heartValue;
    private int type;//tipo attività calcolato
	
    private int valoreAtteso;

    /* Classes must include an empty constructor */
    public ActivityData() {
    }

    public ActivityData(long timestamp, short intensity, short steps, byte category, short heartValue, int valoreAtteso) {
        this.timestamp = timestamp;
        this.intensity=intensity;
        this.steps=steps;
        this.category=category;
        this.heartValue=heartValue;
        this.valoreAtteso=valoreAtteso;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public short getIntensity() {
        return intensity;
    }

    public void setIntensity(short intensity) {
        this.intensity = intensity;
    }

    public short getSteps() {
        return steps;
    }

    public void setSteps(short steps) {
        this.steps = steps;
    }

    public short getCategory() {
        return category;
    }

    public void setCategory(short category) {
        this.category = category;
    }



    public short getHeartValue() {
        return heartValue;
    }

    public void setHeartValue(short heartValue) {
        this.heartValue = heartValue;
    }


    public int getValoreAtteso() {
        return valoreAtteso;
    }

    public void setValoreAtteso(int valoreAtteso) {
        this.valoreAtteso = valoreAtteso;
    }
	

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
	
	
	
	public int calcType01(int category, int intensity, int steps, double distance, double max, double mode)
	{
		type = calcType01Method(category, intensity, steps, distance, max, mode);
		return type;
	}
	
	
	private int calcType01Method(int category, int intensity, int steps, double distance, double max, double mode)
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
	
	
	
	public int calcType123(int category, int intensity, int steps, double Distance, double max, double mode)
	{
		type = calcType123Method(category, intensity, steps, Distance, max, mode);
		return type;
	}
	
	private int calcType123Method(int category, int intensity, int steps, double Distance, double max, double mode)
	{
     if (Distance <= 4) {
    if (max <= 59) {
        if (max <= 3) {
            if (intensity <= 1) return 1;
            if (intensity > 1) {
                if (Distance <= 2) return 1;
                if (Distance > 2) {
                    if (max <= 2) {
                        if (Distance <= 3) return 1;
                        if (Distance > 3) return 2;
                    }
                    if (max > 2) {
                        if (Distance <= 3) return 2;
                        if (Distance > 3) return 1;
                    }
                }
            }
        }
        if (max > 3) return 1;
    }
    if (max > 59) {
        if (max <= 62) return 1;
        if (max > 62) {
            if (Distance <= 2) {
                if (max <= 91) return 3;
                if (max > 91) return 1;
            }
            if (Distance > 2) return 1;
        }
    }
}
if (Distance > 4) return 2;

        return 0;
    }
}