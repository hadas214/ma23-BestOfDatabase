package mil.matmon.database;

import com.sun.jdi.Value;

import java.lang.reflect.Type;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import mil.matmon.database.functions.convertor;
import java.util.*;

public class Table {

    // Column name, values
    private Map<String, Row> rows;
    // All the columns, column's type
    private Map<String, String> columns;

    private Map<String, Object> function;

    // An automatic column to identify
    public static final String ID_COLUMN = "id_column";
    public static final String ID_Type = "Integer";
    private int idColumn = 0;

    public Table()
    {
        this.rows = new HashMap<>();
        this.columns = new HashMap<>();
        this.columns.put(ID_COLUMN, ID_Type);
    }
    public Table(Map<String, String> columns)
    {
        this.rows = new HashMap<>();
        this.columns = new HashMap<>();
        this.columns.put(ID_COLUMN, ID_Type);
        this.rows.put(ID_COLUMN, new Row<Integer>());

        for (String key:columns.keySet()) {
            this.columns.put(key, columns.get(key));
            this.rows.put(key, this.convertRow(columns.get(key)));
        }
    }


    public <T> Object convert(String type, String value){
        convertor c = new convertor();
        return c.convert(type, value);
    }
    public Row convertRow(String type)
    {
        convertor c = new convertor();
        return  c.convertRow(type);
    }
    // Add new row
    public void addRow(Map<String, String> values){
        this.idColumn = this.idColumn + 1;
        this.rows.get(ID_COLUMN).getValues().add(this.idColumn);

        for (String columnName: values.keySet()) {
            String type = this.columns.get(columnName);
            String value = values.get(columnName);
            this.rows.get(columnName).getValues().add(this.convert(type, value));
        }
    }
    // Update row
    public void updateRow(int idColumn, String columnName, String value)
    {
        Collections.replaceAll(this.rows.get(columnName).getValues(),
                this.rows.get(columnName).getValues().get(idColumn - 1),
                this.convert(this.columns.get(columnName),value));
        this.rows.get(columnName).getValues().get(idColumn -1);
    }

    // Delete row
    public void removeRow(int idRow)
    {
        for (String columnName: this.rows.keySet()) {
            this.rows.get(columnName).getValues().remove(idRow - 1);
        }
        this.idColumn = idColumn - 1;

        List<Integer> indexes = this.rows.get(ID_COLUMN).getValues();

        for (Integer num: indexes) {
            if (num > idRow){
                Collections.replaceAll(indexes,num, num - 1);
            }
        }
    }

    @Override
    public String toString() {
        return "Table{" +"\n" +
                "rows = " + rows +  "\n" +
                " columns = " + columns +"\n" +
                " idColumn = " + idColumn +"\n" +
                '}';
    }
}
