package org.example;

import java.util.Arrays;
import java.util.Objects;

public class MyLinkedList<T> implements List<T> {

    // Указатель на первый узел списка
    private Node<T> head;

    // Текущее количество элементов в списке
    private int size;

    // Конструктор MyLinkedList инициализирует пустой связанный список
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // Метод add(value) добавляет элемент в конец списка
    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Метод add(value, index) добавляет элемент в указанную позицию списка
    @Override
    public void add(T value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> newNode = new Node<>(value);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    // Метод get(index) возвращает элемент по указанному индексу
    @Override
    public T get(int index) {
        try {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Ошибка индекса: " + e.getMessage());
            return null;
        }
    }

    // Метод remove(value) удаляет первый найденный элемент, равный заданному значению
    @Override
    public void remove(T value) {
        // Если список пуст, ничего не делать
        if (head == null) {
            return;
        }

        // Если удаляем первый элемент
        if (Objects.equals(value, head.value)) {
            head = head.next;
            size--;
            return;
        }

        // Проходим по списку, чтобы найти элемент для удаления
        Node<T> current = head;
        while (current.next != null) {
            if (Objects.equals(value, current.next.value)) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    // clear метод класса MyLinkedList очищает список полностью
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    // Метод sort сортирует элементы списка
    @Override
    public void sort() {
        try {
            Object[] array = toArray();
            java.util.Arrays.sort((T[]) array, null);
            head = null;
            for (Object obj : array) {
                add((T) obj);
            }
        } catch (Exception e) {
            System.err.println("Ошибка при сортировке: " + e.getMessage());
        }
    }

    // Метод toArray преобразует список в массив
    private Object[] toArray() {
        // Создаем массив для хранения элементов
        Object[] array = new Object[size];
        Node<T> current = head;
        int index = 0;

        // Обходим все узлы списка
        while (current != null && index < size) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    // метод toString возвращает строковое представление связанного списка
    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}