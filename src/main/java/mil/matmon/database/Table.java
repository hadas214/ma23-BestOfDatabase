package mil.matmon.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table <T> {

    // Column name, values
    private Map<String, List<T>> rows;
    // All the columns
    private List<String> columns;

    // An automatic column to identify
    public static final String ID_COLUMN = "id_column";
    private int idColumn = 0;

    public Table()
    {
        this.rows = new HashMap<>();
        this.columns = new ArrayList<>();
        this.columns.add(ID_COLUMN);
    }
    public Table(ArrayList<String> columns)
    {
        this.rows = new HashMap<>();
        this.columns = new ArrayList<>();
        this.columns.add(ID_COLUMN);
        this.columns.addAll(columns);

        for (String col: this.columns) {
            this.addRow();
            String name = col;
            this.rows.put(col, null);
        }
    }
    public void addRow()
    {
        this.idColumn = this.idColumn + 1;
    }

    @Override
    public String toString() {
        return "Table{" +
                "rows=" + rows +
                ", columns=" + columns +
                '}';
    }
}
