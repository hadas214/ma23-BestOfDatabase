package mil.matmon.database;

import java.util.ArrayList;
import java.util.List;

public class Row<T> {

    private List<T> values;

    public Row(List<T> values) {
        this.values = values;
    }
    public Row()
    {
        this.values = new ArrayList<T>();
    }

    public List<T> getValues() {
        return this.values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Row{" +
                "values=" + this.values +
                '}';
    }
}
