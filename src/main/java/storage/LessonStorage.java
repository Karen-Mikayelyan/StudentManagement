package storage;

import exception.LessonNotFoundException;
import model.Lesson;

public class LessonStorage {

    private Lesson[] array = new Lesson[10];
    private int size = 0;

    public void add(Lesson lesson) {
        if (array.length == size) {
            extend();
        }
        array[size++] = lesson;

    }

    public int getSize() {
        return size;
    }

    public Lesson getLessonByIndex(int index) throws LessonNotFoundException {
        if (index < 0 || index >= size) {
            throw new LessonNotFoundException("Lesson with " + index + "does not exists" );
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
        Lesson[] temp = new Lesson[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

}
