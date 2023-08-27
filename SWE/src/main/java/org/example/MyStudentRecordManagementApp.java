package org.example;

import java.text.ParseException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MyStudentRecordManagementApp {
    List<Student> studentList;

    public MyStudentRecordManagementApp() {
        studentList = new ArrayList<>();
    }

    public void CreateStudentArray() {
        studentList.add(new Student("110001", "Dave", "11/18/1951"));
        studentList.add(new Student("110002", "Anna", "12/07/1990"));
        studentList.add(new Student("110003", "Erica", "01/31/1974"));
        studentList.add(new Student("110004", "Carlos", "08/22/2009"));
        studentList.add(new Student("110005", "Bob", "03/05/1990"));
    }

    public void printListOfStudents(List<Student> students) {
        for (Student st : students) {
            System.out.println(st.toString());
        }
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Student> getListOfPlatinumAlumniStudents(List<Student> students) {
        List<Student> platiniumAlumniStudents = new ArrayList<>();
        for (Student st : students) {
            try {
                long diffInMillies = Math.abs(System.currentTimeMillis() - st.GetAdmissionDate().getTime());
                long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                if (diff >= 30 * 365) {
                    platiniumAlumniStudents.add(st);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return platiniumAlumniStudents;
    }

    public void printHelloWorld(List<Integer> integerList) {
        for (Integer x : integerList) {
            if (x % 5 == 0) {
                System.out.println("Hello");
            } else if (x % 7 == 0) {
                System.out.println("HelloWorld");
            } else System.out.println("World");
        }
    }

    public List<Integer> GreateIntegerList(int Count, int minBound, int maxBound) {
        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();
        System.out.print("Integer List: [");
        for (int i = 0; i < Count; ++i) {
            Integer x = random.nextInt(maxBound);
            integerList.add(x);
            System.out.print(x.toString());
            if (i < Count - 1)
                System.out.print(",");
        }
        System.out.print("]\n");

        return integerList;
    }

    public Integer findSecondBiggest(List<Integer> integerList) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(integerList.size(), Collections.reverseOrder());
        for (Integer x : integerList) {
            priorityQueue.add(x);
        }

        priorityQueue.poll();
        Integer secondMax = priorityQueue.poll();
        System.out.println("Second biggest is:" + secondMax.toString());
        return secondMax;
    }

    public static void main(String[] args) {

        MyStudentRecordManagementApp myStudentRecordsMgmtApp = new MyStudentRecordManagementApp();
        myStudentRecordsMgmtApp.CreateStudentArray();
        myStudentRecordsMgmtApp.printListOfStudents(myStudentRecordsMgmtApp.getStudentList());

        System.out.println(" --------getListOfPlatinumAlumniStudents----------- ");
        myStudentRecordsMgmtApp.printListOfStudents(myStudentRecordsMgmtApp.getListOfPlatinumAlumniStudents(myStudentRecordsMgmtApp.getStudentList()));

        System.out.println(" --------integer list----------- ");
        myStudentRecordsMgmtApp.printHelloWorld(myStudentRecordsMgmtApp.GreateIntegerList(10, 1, 100));

        System.out.println(" --------findSecondBiggest----------- ");
        myStudentRecordsMgmtApp.findSecondBiggest(myStudentRecordsMgmtApp.GreateIntegerList(10, 1, 100));
    }

}