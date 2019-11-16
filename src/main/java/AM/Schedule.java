package AM;

import java.util.Collections;

public class Schedule {
    private Node[] Schedule = new Node[24];
    private String date;
    public Schedule(String date) {
        this.date = date;

        String time = "";

        for (int i = 0; i < 24; i++) {
            if (i < 10) {
                time = "0" + Integer.toString(i) + ":00";
            } else {
                time = Integer.toString(i) + ":00";
            }
            Node bruh = new Node("Free", 0, 0);
            bruh.time = time;
            Schedule[i] = bruh;
        }
    }

    public String getdate() {
        return this.date;
    }

    public String getEventAtHour(int hour) { // in 24h format
        return Schedule[hour].name;
    }

    public void addEventToHour(Node event, int hour) {
        Schedule[hour] = event;
    }

    public void GenerateSchedule(int size, int startTime) {
        TheMap sch = new TheMap();
        sch.initRoute(size);
        Collections.sort(sch.Route);
        for (int i = 0; i < sch.Route.size(); i++) {
            this.Schedule[i + startTime].name = sch.Route.get(i).name;
            this.Schedule[i + startTime].exp = sch.Route.get(i).exp;
            this.Schedule[i + startTime].pos = sch.Route.get(i).pos;
        }

    }

    public void printEntireSchedule() {
        for (int i = 0; i < 24; i++) {
            System.out.printf("%02d:00 - %s [+%d Exp.]\n", i, this.Schedule[i].name, this.Schedule[i].exp);
        }
    }

    public Node[] getNodes() {
        return Schedule;
    }
}