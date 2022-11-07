package model;

public class FoodAndDrinkOder {
    private FoodAndDrink foodAndDrink;
    private int quantity;

    public FoodAndDrinkOder(FoodAndDrink foodAndDrink, int quantity) {
        this.foodAndDrink = foodAndDrink;
        this.quantity = quantity;
    }

    public FoodAndDrinkOder() {
    }

    public FoodAndDrink getFoodAndDrink() {
        return this.foodAndDrink;
    }

    public void setFoodAndDrink(FoodAndDrink foodAndDrink) {
        this.foodAndDrink = foodAndDrink;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "FoodAndDrinkOder{foodAndDrink=" + this.foodAndDrink + ", quantity=" + this.quantity + '}';
    }
}
