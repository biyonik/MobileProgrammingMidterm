package builder;

import java.util.ArrayList;

import models.RadixModel;

public class RadixModelBuilder {
    public static ArrayList<RadixModel> buildList() {
        ArrayList<RadixModel> radixList = new ArrayList<>();
        radixList.add(new RadixModel("İkilik", 2));
        radixList.add(new RadixModel("Sekizlik", 8));
        radixList.add(new RadixModel("Onaltılık", 16));

        return radixList;
    }
}
