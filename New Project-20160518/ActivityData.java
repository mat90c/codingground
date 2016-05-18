public class ActivityData {

    private long timestamp;
    private short intensity;
    private short steps;
    private short category;
    private short heartValue;

    /* Classes must include an empty constructor */
    public ActivityData() {
    }

    public ActivityData(long timestamp, short intensity, short steps, byte category, short heartValue) {
        this.timestamp = timestamp;
        this.intensity=intensity;
        this.steps=steps;
        this.category=category;
        this.heartValue=heartValue;
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

}