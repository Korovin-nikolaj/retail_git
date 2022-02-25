package ru.retail;

public class MyException extends Exception {

    MyException(String message){
        System.out.println("Вывод исключения: " + message);
    }
}
