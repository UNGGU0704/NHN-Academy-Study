package com.example.refectionb;

public class ArrayListTestMain {
    public static void main(String[] args) {
        ArrayListTest arrayListTest = new ArrayListTest();
        ArrayListTestProxy arrayListTestProxy = new ArrayListTestProxy(arrayListTest);
        arrayListTestProxy.test();

        LinkedListTest linkedListTest = new LinkedListTest();
        ArrayListTestProxy linkedListTestProxy = new ArrayListTestProxy(linkedListTest);
        linkedListTestProxy.test();
    }
}