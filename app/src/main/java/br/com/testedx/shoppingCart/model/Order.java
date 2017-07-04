package br.com.testedx.shoppingCart.model;

import java.util.List;

/**
 * Created by rafaela on 01/07/2017.
 */

public class Order {

    private int id;
    private int id_sandwich;
    private List<Integer> extras;
    private long date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_sandwich() {
        return id_sandwich;
    }

    public void setId_sandwich(int id_sandwich) {
        this.id_sandwich = id_sandwich;
    }

    public List<Integer> getExtras() {
        return extras;
    }

    public void setExtras(List<Integer> extras) {
        this.extras = extras;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
