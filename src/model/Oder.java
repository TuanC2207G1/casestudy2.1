package model;

import manager.ManagerSelectItems;

public class Oder{
    private int numberTable;
    private ManagerSelectItems managerSelectItems;

    public Oder() {
    }

    public Oder(int numberTable, ManagerSelectItems managerSelectItems) {
        this.numberTable = numberTable;
        this.managerSelectItems = managerSelectItems;
    }

    public int getNumberTable() {
        return this.numberTable;
    }

    public void setNumberTable(int numberTable) {
        this.numberTable = numberTable;
    }

    public ManagerSelectItems getManagerSelectItems() {
        return this.managerSelectItems;
    }

    public void setManagerSelectItems(ManagerSelectItems managerSelectItems) {
        this.managerSelectItems = managerSelectItems;
    }

    @Override
    public String toString() {
        return "Oder{" +
                "numberTable=" + numberTable +
                ", managerSelectItems=" + managerSelectItems +
                '}';
    }
}
