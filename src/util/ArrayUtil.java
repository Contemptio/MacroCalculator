package util;

/**
 * Utility class for management of arrays.
 * 
 * @author Zimon
 * @date 2017-06-24
 */
public class ArrayUtil {

    public static <T extends Comparable<T>> int indexOf(T[] ts, T t) {
        for (int i = 0; i < ts.length; ++i) {
            if (t.compareTo(ts[i]) == 0) {
                return i;
            }
        }
        return -1;
    }

}
