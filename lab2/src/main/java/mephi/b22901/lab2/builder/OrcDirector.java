/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2.builder;

/**
 *
 * @author ivis2
 */


public class OrcDirector {
    public Ork createBasicOrk(OrkBuilder builder) {
        Ork ork = new Ork(null, null, 0, 0, 0, 0, null, null, null);
        builder.setOrk(ork);
        builder.setAttributes();
        builder.equip(false);
        return builder.getOrk();
    }

    public Ork createCommanderOrk(OrkBuilder builder) {
        Ork ork = new Ork(null, null, 0, 0, 0, 0, null, null, null);
        builder.setOrk(ork);
        builder.setAttributes();
        builder.equip(false);
        builder.giveBanner(true);
        return builder.getOrk();
    }

    public Ork createScoutOrk(OrkBuilder builder) {
        Ork ork = new Ork(null, null, 0, 0, 0, 0, null, null, null);
        builder.setOrk(ork);
        builder.setAttributes();
        builder.equip(true);
        return builder.getOrk();
    }
}
