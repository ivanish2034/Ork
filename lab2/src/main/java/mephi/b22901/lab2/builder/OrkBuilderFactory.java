/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2.builder;

import mephi.b22901.lab2.gearFactory.*;
import mephi.b22901.lab2.gearFactory.OrcGearFactory;

/**
 *
 * @author ivis2
 */

public class OrkBuilderFactory {

    public OrkBuilder createBuilder(String tribe) {
        OrcGearFactory gearFactory = createGearFactoryForTribe(tribe);
        
        switch (tribe) {
            case "Мордор":
                return new MordorOrkBuilder(gearFactory);
            case "Дол Гулдур":
                return new DolGuldurOrkBuilder(gearFactory);
            case "Мглистые Горы":
                return new MistyMountainsOrkBuilder(gearFactory);
            default:
                throw new IllegalArgumentException("Неизвестное племя: " + tribe);
        }
    }

    private OrcGearFactory createGearFactoryForTribe(String tribe) {
        switch (tribe) {
            case "Мордор":
                return new MordorGearFactory();
            case "Дол Гулдур":
                return new DolGuldurGearFactory();
            case "Мглистые Горы":
                return new MistyMountainsGearFactory();
            default:
                throw new IllegalArgumentException("Неизвестное племя: " + tribe);
        }
    }
}


