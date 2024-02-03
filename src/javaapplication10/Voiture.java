package javaapplication10;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nada haninou
 */
public class Voiture extends Vehicule {

    public Voiture(String ref, String marque, String modele, String couleur) {
        super(ref, marque, modele, couleur);
    }
    public String toString(){
        return "Voiture{" + "ref=" + this.getRef() + ", marque=" + this.getMarque() + ", modele=" + this.getModele() + ", couleur=" + this.getCouleur() + "}";
    }
    
}
