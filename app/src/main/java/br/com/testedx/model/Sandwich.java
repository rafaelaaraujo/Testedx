package br.com.testedx.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.testedx.enums.PromotionEnum;

/**
 * Created by rafaela on 28/06/2017.
 * this class describe snacks present in the menu
 */

public class Sandwich implements Parcelable {

    private int id;
    private String name = "";
    private List<Integer> ingredients = new ArrayList<>();
    private HashMap<Integer,Ingredient> ingredientsObj = new HashMap<>();
    private String ingredientsName = "";
    private String image ="";
    private double total;
    private double totalWithDiscounts;
    private PromotionEnum promotionEnum = PromotionEnum.NONE;


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

    public List<Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getIngredientsName() {
        return ingredientsName;
    }

    public void setIngredientsName(String ingredientsName) {
        this.ingredientsName = ingredientsName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public HashMap<Integer, Ingredient> getIngredientsObj() {
        return ingredientsObj;
    }

    public void setIngredientsObj(HashMap<Integer, Ingredient> ingredientsObj) {
        this.ingredientsObj = ingredientsObj;
    }


    public PromotionEnum getPromotionEnum() {
        return promotionEnum;
    }

    public void setPromotionEnum(PromotionEnum promotionEnum) {
        this.promotionEnum = promotionEnum;
    }

    public void addItemListIngredientsObj(Ingredient i) {
        i.setQuantity(1);
        total += i.getPrice();
        ingredientsName += i.getName()+", ";
        ingredientsObj.put(i.getId(),i);
    }

    public double getTotalWithDiscounts() {
        return totalWithDiscounts;
    }

    public void setTotalWithDiscounts(double totalWithDiscounts) {
        this.totalWithDiscounts = totalWithDiscounts;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeList(this.ingredients);
        dest.writeSerializable(this.ingredientsObj);
        dest.writeString(this.ingredientsName);
        dest.writeString(this.image);
        dest.writeDouble(this.total);
        dest.writeDouble(this.totalWithDiscounts);
        dest.writeInt(this.promotionEnum == null ? -1 : this.promotionEnum.ordinal());
    }

    public Sandwich() {
    }

    protected Sandwich(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.ingredients = new ArrayList<>();
        in.readList(this.ingredients, Integer.class.getClassLoader());
        this.ingredientsObj = (HashMap<Integer, Ingredient>) in.readSerializable();
        this.ingredientsName = in.readString();
        this.image = in.readString();
        this.total = in.readDouble();
        this.totalWithDiscounts = in.readDouble();
        int tmpPromotionEnum = in.readInt();
        this.promotionEnum = tmpPromotionEnum == -1 ? null : PromotionEnum.values()[tmpPromotionEnum];
    }

    public static final Creator<Sandwich> CREATOR = new Creator<Sandwich>() {
        @Override
        public Sandwich createFromParcel(Parcel source) {
            return new Sandwich(source);
        }

        @Override
        public Sandwich[] newArray(int size) {
            return new Sandwich[size];
        }
    };
}
