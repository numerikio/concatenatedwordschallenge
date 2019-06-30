package schallenge.provider;

import java.util.Collection;
import java.util.List;

public class ListDataProvider implements DataProvider {
    private List<String> list;

    public ListDataProvider(List<String> list) {
        this.list = list;
    }

    @Override
    public Collection<String> getData() {
        return list;
    }
}
