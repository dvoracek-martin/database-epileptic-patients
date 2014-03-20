package cz.cvut.fit.genepi.util;

import java.util.Collections;
import java.util.List;

public class Sorter<T extends Comparable<T>> {

    public List<T> sortByDate(List<T> list) {
        if (list == null) {
            return null;
        }
        Collections.sort(list);
        return list;
    }
}
