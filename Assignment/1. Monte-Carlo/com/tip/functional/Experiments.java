//package com.tip.functional;
//
//import java.util.Iterator;
//
//public class Experiments<T extends Number> implements Iterator<T> {
//    // TODO: 채우기
//}


package com.tip.functional;

        import java.util.Iterator;

public class Experiments<T extends Number> implements Iterator<T> {
    private final Iterator<T> itr;
    private final String str1;
    private final String str2;
    private double prefixSum = 0;
    private int count = 0;

    public Experiments(Iterator<T> itr, String str1, String str2) {
        this.itr = itr;
        this.str1 = str1;
        this.str2 = str2;
    }

    @Override
    public boolean hasNext() {
        return itr.hasNext();
    }

    @Override
    public T next() {
        count = Math.addExact(count, 1);
        T old = itr.next();
        prefixSum += old.doubleValue();
        return old;
    }

    public void report() {
        System.out.print(str1 + " " + str2 + " ");
        System.out.println(prefixSum / count);
    }
}
