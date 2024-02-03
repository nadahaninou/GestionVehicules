/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication10;

/**
 *
 * @author nada haninou
 */
public class MiniBus extends Vehicule {
    private int nombrePlaces;

    public MiniBus(int nombrePlaces, String ref, String marque, String modele, String couleur) {
        super(ref, marque, modele, couleur);
        this.nombrePlaces = nombrePlaces;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }
    public String toString() {
        return "Minibus{" + "ref=" + this.getRef() + ", marque=" + this.getMarque() + ", modele=" + this.getModele() + ", couleur=" + this.getCouleur() + ", nbresde places=" + this.getNombrePlaces();
    }
}
