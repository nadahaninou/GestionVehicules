 
package javaapplication10;

import java.util.LinkedList;

public interface Administration<T extends Vehicule> {
    
    public boolean SupprimerVehicule();
    public LinkedList<T> RecherchParModele(String modele);
    public LinkedList<T> RecherchParCouleur(String couleur);
    public LinkedList<T> RecherchParMarque(String marque);
    public T RecherchParReference(String reference);
    public LinkedList<T> GetAll(); 
}
