package application.mappers;

import application.viewModels.UnitVM;
import domain.model.entities.UnitModel;

import java.util.ArrayList;
import java.util.List;

public class UnitMap {
    public static UnitModel getUnit(UnitVM unitVM){
        return new UnitModel(unitVM.id, unitVM.name, unitVM.symbol);
    }

    public static UnitVM getUnitVM(UnitModel model){
        return new UnitVM(
                model.getId(),
                model.getName(),
                model.getSymbol()
        );
    }

    public static List<UnitVM> getUnitsVM(List<UnitModel> models){
        List<UnitVM> units = new ArrayList<>();
        for(UnitModel model : models){
            units.add(getUnitVM(model));
        }
        return units;
    }
}
