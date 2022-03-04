package event;

import java.util.Date;

public class Event {

    private String name;
    private Date start;
    private Date end;
    private String comment;

    public Event(String name, Date start, Date end, String comment) {
        this.start = start;
        this.end = end;
        this.name = name;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString(){
        return "\nName: " + name +
                "\nFrom: " + start.getHours() +
                ":" + start.getMinutes() +
                "\nTo: " + end.getHours() +
                ":" + end.getMinutes() +
                "\nNote: " + comment;
    }
}
