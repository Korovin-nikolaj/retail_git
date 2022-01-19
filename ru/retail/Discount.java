package ru.retail;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
public class Discount {
    private int idProduct;
    private int dateOfStart;
    private int dateOfTheEnd;
    private String kindOfDiscount;

    public void Discounts (int idProduct, int dateOfStart, int dateOfTheEnd, String kindOfDiscount){
        this.idProduct = idProduct;
        this.dateOfStart = dateOfStart;
        this.dateOfTheEnd = dateOfTheEnd;
        this.kindOfDiscount = kindOfDiscount;
    }
    public String setKindOfDiscount(String kindOfDiscount) {
        this.kindOfDiscount = kindOfDiscount;
        return kindOfDiscount;
    }
}