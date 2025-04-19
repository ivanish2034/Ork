/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2.gearFactory;

import mephi.b22901.lab2.weapon.*;
import mephi.b22901.lab2.weapon.mordor.*;

/**
 *
 * @author ivis2
 */
public class MordorGearFactory implements OrcGearFactory {
    @Override
    public Weapon createWeapon() { 
        return new HeavySword(); 
    }
    
    @Override
    public Armor createArmor() { 
        return new SteelArmor(); 
    }
    
    @Override
    public Banner createBanner() { 
        return new RedEyeBanner(); 
    }
}

