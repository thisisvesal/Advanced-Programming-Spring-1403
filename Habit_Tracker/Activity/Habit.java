package Activity;

public class Habit extends ToDo {
    private int frequency;
    private String category;

    @Override
    public String getInfo() {
        return super.getInfo() + "\nfrequency: " + frequency + "\ncategory: " + category;
    }

    @Override
    public void setStartTime(Double startTime) {
        this.startTime = (double) Math.round(startTime);
    }

    public void setFrequency(int frequency) {
        if (frequency < 0) {
            System.out.println("Invalid frequency");
            return;
        }
        this.frequency = frequency;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}