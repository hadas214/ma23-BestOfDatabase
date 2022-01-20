package mil.matmon.database;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> columns = new HashMap<>();
        columns.put("type", "String");
        columns.put("age", "Integer");
        columns.put("color", "String");
        columns.put("birth", "Date");
        Table t = new Table(columns);

        Map<String, String> row1 = new HashMap<>();
        row1.put("type", "dog");
        row1.put("age", "17");
        row1.put("color", "brown");
        row1.put("birth", "11-12-2003");
        t.addRow(row1);

        Map<String, String> row2 = new HashMap<>();
        row2.put("type", "cat");
        row2.put("age", "5");
        row2.put("color", "pink");
        row2.put("birth", "31-02-2011");

        t.addRow(row2);
        System.out.println(t);

        t.updateRow(2, "color", "blue");
        t.updateRow(1, "birth", "29-05-2003");
        System.out.println(t);
    }
}
