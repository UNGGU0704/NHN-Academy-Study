package com.nhnacademy.study.jsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapStudentRepository implements StudentRepository{
    private Map<String, Student> studentsMap = new ConcurrentHashMap<>();

    @Override
    public void save(Student student) {
        studentsMap.put(student.getID(), student);
    }

    @Override
    public void update(Student student) {
        studentsMap.put(student.getID(), student);
    }

    @Override
    public void deleteById(String id) {
        studentsMap.remove(id);
    }

    @Override
    public Student getStudentById(String id) {
        return studentsMap.get(id);
    }

    @Override
    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        for (String id : studentsMap.keySet()) {
            studentList.add(studentsMap.get(id));
        }
        return new ArrayList<>(studentList);
    }

    @Override
    public boolean existById(String id) {
        return studentsMap.containsKey(id);
    }
    // ...
}
