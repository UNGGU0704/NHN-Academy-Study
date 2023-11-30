package com.example.refectionb;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        try {
            Class userClass = Class.forName(User.class.getName());
            Constructor<?> constructor = userClass.getConstructor(String.class, Integer.TYPE);
            User user = (User) constructor.newInstance("unggu", 25);
            System.out.println(user);
        } catch (ClassNotFoundException | NoSuchMethodException e){
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
