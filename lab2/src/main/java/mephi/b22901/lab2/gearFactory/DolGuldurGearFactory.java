/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2.gearFactory;

import mephi.b22901.lab2.weapon.*;
import mephi.b22901.lab2.weapon.dolguldur.*;

/**
 *
 * @author ivis2
 */
public class DolGuldurGearFactory implements OrcGearFactory {
    @Override
    public Weapon createWeapon() { 
        return new Spear(); 
    }
    
    @Override
    public Armor createArmor() { 
        return new Chainmail(); 
    }
    
    @Override
    public Banner createBanner() { 
        return new SpiderBanner(); 
    }
}

