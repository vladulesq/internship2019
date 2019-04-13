package Domain;

public class Path
{
    private String from;
    private String to;
    private int duration;

    public Path()
    {

    }

    public Path(String from, String to, int duration)
    {
        this.from = from;
        this.to = to;
        this.duration = duration;
    }

    public String getFrom() { return from; }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
