package builder;

import java.util.ArrayList;

import enums.UnitEnum;
import models.UnitModel;

public class UnitModelBuilder {
    public static ArrayList<UnitModel> buildList() {
        ArrayList<UnitModel> unitModels = new ArrayList<>();
        unitModels.add(new UnitModel("BIT", UnitEnum.BIT));
        unitModels.add(new UnitModel("BYTE", UnitEnum.BYTE));
        unitModels.add(new UnitModel("KIBIBYTE", UnitEnum.KIBIBYTE));
        unitModels.add(new UnitModel("KILOBYTE", UnitEnum.KILOBYTE));

        return unitModels;
    }
}
