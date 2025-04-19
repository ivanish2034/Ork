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


public class DolGuldurOrkBuilder extends OrkBuilder {
    public DolGuldurOrkBuilder(OrcGearFactory gearFactory) {
        this.gearFactory = gearFactory;
    }

    @Override
    public void setAttributes() {
        ork.tribe = "Дол Гулдур";
        ork.strength = (int)(Math.random() * 60 + 40); 
        ork.agility = (int)(Math.random() * 60 + 20);  
        ork.intelligence = (int)(Math.random() * 50);  
        ork.health = (int)(Math.random() * 150 + 50);
    }

    @Override
    public void equip(boolean isScout) {
        if (isScout) {
            ork.weapon = new Bow();
        } else {
            ork.weapon = gearFactory.createWeapon();
        }
        ork.armor = gearFactory.createArmor();
    }
}