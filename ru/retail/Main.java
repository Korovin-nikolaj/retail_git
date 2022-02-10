package ru.retail;

import ru.retail.product.Eatable;
import ru.retail.product.Product;
import ru.retail.product.Uneatable;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Product> lisfOfStoreProducts;
    public static void main(String[] args) {
        lisfOfStoreProducts = new ArrayList<Product>();
        Storage storage = new Storage("Склад");

        Eatable.buildEatable("Молоко", "260123435", 20.5f, "10.12.21", storage, lisfOfStoreProducts);
        Eatable milk = Eatable.getRandomEatable("Молоко", "260123435", 20.5f, "10.12.21");
        if (lisfOfStoreProducts.contains(milk)) {
            milk.setState("В наличии");
            for (int i = 0; i < 1000; i++) {
                if (lisfOfStoreProducts.get(i).equals(milk)) {
                    System.out.println("Индекс товара " + i);
                    break;
                }
            }
        }
        //milk.getBarCode().changePriceToPercent((byte)10);
        Uneatable toy = Uneatable.buildUneatable("Кукла Барби", "263123312", 600, "Китай", storage);
        toy.getBarCode().changePrice(100f);
        Client vasy = new Client("Вася");
        BankAccount bankAccount = new BankAccount("Основной счет", 0);
        vasy.attachBankAccount(new BankAccount("Банковский счет Васи", 500));

        vasy.putInBasket(milk);
        vasy.putInBasket(toy);
        vasy.payOrder("Безналичная оплата", "Оплата при получении", bankAccount);
        Order order = vasy.getOrder();
        order.setDeliveryAdress("Удмуртская республика, г.Ижевск, Ленина 1");
        order.setDeliveryDate("31.12.2021");
        order.setState("Заказ в обработке");
        order.sortOrderBySum();
        order.createPackingTask(storage);
        if (storage.isTaskExists()) { // пока очень примитивно
            order.packProducts(storage);
            Delivery delivery = order.sendToDelivery();
            delivery.deliver(vasy);
            Payment payment = order.getPayment();
            payment.giveDiscount(100);
            if (payment.getState() != "Оплачено") {
                delivery.getPay(order, vasy);// курьер получает оплату
                payment.setState("Оплачено");
            }
            payment.printCheck("Полный расчет");
            if (delivery.getMoney() != 0) {
                bankAccount.putMoney(delivery.getMoney());// перевести деньги на расчетный счет
            }
            order.sendToClient();
            order.setState("Доставлено");
            System.out.println("Заказу выставлен статус " + order.getState());
            System.out.println("Заказ доставлен по адресу " + order.getDeliveryAdress() + " " + order.getDeliveryDate());
        }
    }




}
