/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2.builder;

import mephi.b22901.lab2.gearFactory.*; 

/**
 *
 * @author ivis2
 */

public abstract class OrkBuilder {
    protected Ork ork;
    protected OrcGearFactory gearFactory;

    public void setOrk(Ork ork) {
        this.ork = ork;
    }

    public void setName(String name) {
        ork.name = name;
    }

    public abstract void setAttributes();
    public abstract void equip(boolean isScout);

    public void giveBanner(boolean isLeader) {
        if (isLeader) {
            ork.banner = gearFactory.createBanner();
        }
    }

    public Ork getOrk() {
        if (ork.name == null || ork.name.isEmpty()) {
            ork.name = new com.github.javafaker.Faker().lordOfTheRings().character() + "gash";
        }
        return ork;
    }
}
