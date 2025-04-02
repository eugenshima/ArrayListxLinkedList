package org.example;

public class Node<T> {
    // Значение, хранящееся в узле
    T value;

    // Ссылка на следующий узел
    Node<T> next;

    // Конструктор MyLinkedList инициализирует узел с заданным значением
    public Node(T value) {
        this.value = value;
        this.next = null; // По умолчанию следующий узел отсутствует
    }
}