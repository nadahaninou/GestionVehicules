/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication10;

/**
 *
 * @author nada haninou
 */
public class Camionnette extends Voiture {
    private double chargeMax;

    public Camionnette(double chargeMax, String ref, String marque, String modele, String couleur) {
        super(ref, marque, modele, couleur);
        this.chargeMax = chargeMax;
    }

    public double getChargeMax() {
        return chargeMax;
    }

    public void setChargeMax(double chargeMax) {
        this.chargeMax = chargeMax;
    }
    public String toString(){
        return "Camionnette{" + "ref=" + this.getRef() + ", marque=" + this.getMarque() + ", modele=" + this.getModele() + ", couleur=" + this.getCouleur() +" ,chargemax:"+this.getChargeMax()+"}";
    }
}
