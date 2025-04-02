package org.example;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> implements List<T> {

    // Начальная емкость массива по умолчанию
    private static final int DEFAULT_CAPACITY = 5;
    // Массив для хранения элементов списка
    private Object[] elements;

    // Текущее количество элементов в списке
    private int size;

    // Конструктор MyArrayList инициализирует список с начальной емкостью равной DEFAULT_CAPACITY(10)
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Метод add(value) добавляет элемент в конец списка
    @Override
    public void add(T value) {
        increaseCapacityCheck();
        elements[size++] = value;
    }

    // Метод add(value, index) добавляет элемент в указанную позицию списка
    @Override
    public void add(T value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        increaseCapacityCheck();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = value;
        size++;
    }

    // Метод get возвращает элемент по указанному индексу
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    // Метод remove удаляет первый найденный элемент, равный заданному значению
    @Override
    public void remove(T value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(value, elements[i])) {
                removeByIndex(i);
                return;
            }
        }
    }

    // Метод removeByIndex используется в основном методе remove
    // и способствует удалению элемента по индексу
    private void removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    // Метод clear очищает список
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Метод sort сортирует элементы списка
    @Override
    public void sort() {
        Arrays.sort((T[]) elements, 0, size, null);
    }

    // метод increaseCapacityCheck проверяет, нужно ли увеличить емкость списка
    // И в случае если необходимость есть - удваивает его емкость
    private void increaseCapacityCheck() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = java.util.Arrays.copyOf(elements, newCapacity);
        }
    }

    // метод toString возвращает строковое представление связанного списка
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }


}
