package ru.retail;

import ru.retail.product.Product;

import java.io.*;
import java.util.Scanner;

public class DataInputOutputStreamApp {

    private static String CATALOG_NAME = "file/";
    private static String EXTENSION = ".txt";

    public static void main(String[] args) {
        File catalog = new File(CATALOG_NAME);
        if (catalog.exists() == false) {
            catalog.mkdir();
        }
        System.out.println("Выберите режим:");
        System.out.println("1. Загрузить товары");
        System.out.println("2. Выгрузить и отобразить товары");

        Scanner sc = new Scanner(System.in);
        int choise = sc.nextInt();

        if (choise == 1 ) {
            System.out.println("Заполните товар для сохранения.");
            dbWrite(sc);
        } else if( choise == 2) {
            dbRead(sc);
        }
    }

    private static void dbWrite(Scanner sc) {
        System.out.println("Введите имя товара:");
        String productName = sc.next();
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(CATALOG_NAME+productName+EXTENSION, true))) {
            dos.writeUTF(productName);
            System.out.println("Введите штрих-код");
            dos.writeUTF(sc.next());
            System.out.println("Введите цену");
            dos.writeFloat(sc.nextFloat());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dbRead(Scanner sc) {
        System.out.println("Введите имя товара");
        String productName = sc.next();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(CATALOG_NAME+productName+EXTENSION))) {
            Product p = new Product(dis.readUTF(), dis.readUTF(), dis.readFloat());
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Данный товар не найдена," + productName + " введи ее повторно: ");
            dbRead(sc);
        }
    }

}
