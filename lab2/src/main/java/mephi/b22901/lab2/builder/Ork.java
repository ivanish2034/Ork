/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2.builder;

import mephi.b22901.lab2.weapon.*;

/**
 *
 * @author ivis2
 */

public class Ork {
    public String name;
    public String tribe;
    public int strength;
    public int agility;
    public int intelligence;
    public int health;
    public Weapon weapon;
    public Armor armor;
    public Banner banner;

    public Ork(String name, String tribe, int strength, int agility, int intelligence, int health, Weapon weapon, Armor armor, Banner banner) {
        this.name = name;
        this.tribe = tribe;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = health;
        this.weapon = weapon;
        this.armor = armor;
        this.banner = banner;
    }

    public String getName() {
        return name;
    }

    public String getTribe() {
        return tribe;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public Banner getBanner() {
        return banner;
    }
}

