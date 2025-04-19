/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2.gearFactory;

import mephi.b22901.lab2.weapon.*;

/**
 *
 * @author ivis2
 */
public interface OrcGearFactory {
    Weapon createWeapon();
    Armor createArmor();
    Banner createBanner(); 
}
