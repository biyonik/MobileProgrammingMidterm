package models;

import androidx.annotation.NonNull;

import enums.UnitEnum;

public class UnitModel {
    private String name;
    private UnitEnum unitEnum;

    public UnitModel(String name, UnitEnum unitEnum) {
        this.name = name;
        this.unitEnum = unitEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnitEnum getUnitEnum() {
        return unitEnum;
    }

    public void setUnitEnum(UnitEnum unitEnum) {
        this.unitEnum = unitEnum;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
