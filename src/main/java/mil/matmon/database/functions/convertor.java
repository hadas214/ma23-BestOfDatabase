package mil.matmon.database.functions;

import mil.matmon.database.Row;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class convertor {

    public <T> Object convert(String type, String value){
        if (type.compareTo("String") == 0)
            return value;
        else {
            if (type.compareTo("Integer") == 0)
                return Integer.parseInt(value);
            else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                return LocalDate.parse(value,formatter);
            }
        }
    }
    public Row convertRow(String type)
    {
        Row row;
        if (type.compareTo("String") == 0)
            row = new Row<String>();
        else {
            if (type.compareTo("Integer") == 0)
                row = new Row<Integer>();
            else
                row = new Row<Date>();;
        }
        return row;
    }
}
