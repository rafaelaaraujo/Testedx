package br.com.testedx.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rafaela on 28/06/2017.
 * Describes ingredients present in snacks
 */

public class Ingredient implements Parcelable, Cloneable{

    private int id;
    private String name;
    private double price;
    private String image;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeDouble(this.price);
        dest.writeString(this.image);
        dest.writeInt(this.quantity);
    }

    public Ingredient() {
    }

    protected Ingredient(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.price = in.readDouble();
        this.image = in.readString();
        this.quantity = in.readInt();
    }

    public static final Parcelable.Creator<Ingredient> CREATOR = new Parcelable.Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel source) {
            return new Ingredient(source);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    protected Ingredient clone() throws CloneNotSupportedException {
        Ingredient i = (Ingredient) super.clone();
        i.setId(id);
        i.setName(name);
        i.setPrice(price);
        i.setImage(image);
        i.setQuantity(quantity);
        return i;
    }
}
