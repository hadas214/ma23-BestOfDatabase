package mil.matmon.database;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList columns = new ArrayList<>();
        columns.add("type");
        columns.add("age");
        columns.add("color");
        Table t = new Table(columns);
        System.out.println(t);
    }
}
