package ru.retail;

import ru.retail.product.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Order {

    private List<Product> productList;
    private String state;
    private Client client;
    private Payment payment;
    private String deliveryDate;
    private String deliveryAdress;

    public Order() {
        productList = new ArrayList<Product>();
    }

    public void addToOrder(Product product) {
        productList.add(product);
    }

    public float getOrderSum() {
        float sum = 0;
        for (Product currentProduct : productList) {
            if (currentProduct != null) {
                sum += currentProduct.getPrice();
            }
        }
        return sum;
    }

    public void sortOrderBySum(){
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                if (product1.getBarCode().getPrice() == product1.getBarCode().getPrice()) return 0;
                else if (product1.getBarCode().getPrice()> product1.getBarCode().getPrice()) return 1;
                else return -1;
            }
        });
    }

    public void createPackingTask(Storage storage) {
        System.out.println("Создано задание на упаковку заказа для клиента " + client.getName());
        storage.setTaskExists(true);
    }

    public void packProducts(Storage storage){
        setProductsState("Упакован для доставки на месте хранения " + storage.getName());
        state = "Заказ собран";
        for (Product product:productList) {
            if (storage.getSetOfProducts().contains(product)){
                storage.getSetOfProducts().remove(product);
            }
        }
    }

    public Delivery sendToDelivery() {
        System.out.println("Заказ передан в службу доставки");
        setProductsState("Передан в службу доставки");
        state = "В службе доставки";
        return new Delivery("Доставка № 1", deliveryAdress, deliveryDate); //TODO: подумать над формированием ид доставки
    }

    public void sendToClient() {
        System.out.println("Заказ передан клиенту " + client.getName());
        setProductsState("Передан клиенту ");
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setProductsState(String state) {
        for (Product product: productList){
            product.setState(state);
        }
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryAdress() {
        return deliveryAdress;
    }

    public void setDeliveryAdress(String deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }

    public String getState() {
        return state;
    }
}
