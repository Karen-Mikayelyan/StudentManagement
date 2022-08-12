package storage;

import model.Student;

public class StudentStorage {

    private Student[] array = new Student[10];
    private int size = 0;

    public void add(Student student) {
        if (array.length == size) {
            extend();
        }
        array[size++] = student;

    }

    public int getSize() {
        return size;
    }

    public Student getStudentByIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return array[index];
    }


    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
        } else {
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
        }
        size--;
        print();
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ". " + array[i]);
        }
    }

    private void extend() {
        Student[] temp = new Student[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public void printStudentsByLessonName(String lessonName) {
        for (int i = 0; i < size; i++) {
            if (array[i].getLesson().equals(lessonName)) {
                System.out.println(array[i]);
            }
        }
    }

}
