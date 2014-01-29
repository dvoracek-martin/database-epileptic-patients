package cz.cvut.fit.genepi.util;

import java.util.Collections;
import java.util.List;

public class Sorter<T extends Comparable<T>> {
    public List<T> sortByDate(List<T> list) {
        Collections.sort(list);
        return list;
    }
}
