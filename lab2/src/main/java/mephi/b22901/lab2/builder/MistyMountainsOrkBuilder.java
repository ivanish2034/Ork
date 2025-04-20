/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2.builder;

import mephi.b22901.lab2.gearFactory.OrcGearFactory;
import mephi.b22901.lab2.weapon.*;

/**
 *
 * @author ivis2
 */

public class MistyMountainsOrkBuilder extends OrkBuilder {
    public MistyMountainsOrkBuilder(OrcGearFactory gearFactory) {
        this.gearFactory = gearFactory;
    }

    @Override
    public void setAttributes() {
        ork.tribe = "Мглистые Горы";
        ork.strength = (int)(Math.random() * 50 + 50);  // стандартная сила
        ork.agility = (int)(Math.random() * 70 + 30);  // повышенная ловкость
        ork.intelligence = (int)(Math.random() * 30);  // низкий интеллект
        ork.health = (int)(Math.random() * 150 + 50);
    }

    @Override
    public void equip(boolean isScout) {
        if(isScout){
            ork.weapon = new Bow();
        } else{
            ork.weapon = gearFactory.createWeapon();
        }
        ork.armor = gearFactory.createArmor();
    }
}
