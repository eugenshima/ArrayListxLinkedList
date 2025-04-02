package org.example;


public class Main {
    public static void main(String[] args) {
        System.out.println("РЕАЛИЗАЦИЯ LINKEDLIST ");
        List<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("B");
        myLinkedList.add("A");
        System.out.println("Вставим элемент в середину");
        myLinkedList.add("C", 1); // Вставка в середину
        System.out.println("После добавления: ");
        System.out.println(myLinkedList); // Вывод: [B, C, A]

        myLinkedList.remove("B");
        System.out.println("После удаления B:");
        System.out.println(myLinkedList); // Вывод: [C, A]

        myLinkedList.sort();
        System.out.println("После сортировки:");
        System.out.println(myLinkedList); // Вывод: [А, С]

        myLinkedList.clear();
        System.out.println("После очистки:");
        System.out.println(myLinkedList); // Вывод: []

        System.out.println("\n\n\nРЕАЛИЗАЦИЯ ARRAYLIST ");
        List<String> myArrayList = new MyArrayList<>();
        myArrayList.add("B");
        myArrayList.add("A");
        System.out.println("Вставим элемент в середину");
        myArrayList.add("C", 1); // Вставка в середину
        System.out.println("После добавления: ");
        System.out.println(myArrayList); // Вывод: [B, C, A]

        myArrayList.remove("B");
        System.out.println("После удаления B:");
        System.out.println(myArrayList); // Вывод: [C, A]

        myArrayList.sort();
        System.out.println("После сортировки:");
        System.out.println(myArrayList); // Вывод: [А, С]

        myArrayList.add("forOverflow");
        myArrayList.add("forOverflow");
        myArrayList.add("forOverflow");
        myArrayList.add("forOverflow");
        System.out.println("После переполнения default_capacity:");
        System.out.println(myArrayList); // cap = 20

        myArrayList.clear();
        System.out.println("После очистки:");
        System.out.println(myArrayList); // Вывод: []
    }
}