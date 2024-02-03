package javaapplication10;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nada haninou
 */
public abstract class Vehicule {
    java.util.Scanner s=new java.util.Scanner(System.in);
    
       
    
    private final String ref;
    private final String marque;
    private final String modele;
    private  String couleur;

    public Vehicule(String ref, String marque, String modele, String couleur) {
        this.ref = ref;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getRef() {
        return ref;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Vehicule{" + "ref=" + ref + ", marque=" + marque + ", modele=" + modele + ", couleur=" + couleur + '}';
    }
    

    
    
}

