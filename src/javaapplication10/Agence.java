/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication10;
import java.sql.SQLException;
import java.util.LinkedList;
/**
 *
 * @author nada haninou
 */
public class Agence {
   
    public static LinkedList<Vehicule> list=new LinkedList<Vehicule>();
    public static void main(String[] args) throws SQLException {
        java.util.Scanner s=new java.util.Scanner(System.in);
        String rep;
        VoitureUtile voitureUtile = new VoitureUtile();
           do{
          System.out.println("Menu:");
          System.out.println("1-afficher toutes les vehicules");
          System.out.println("2-Gestion de voitures");
          System.out.println("3-Gestion de Camionnettes");
          System.out.println("4-Gestion de Minibus");
          System.out.println("Donnez le numero de votre choix");
          int choix=s.nextInt();
          
          switch(choix){
              case 1:
                  connex b=new connex();
                  System.out.println(b.afficherTousLesVehicules());
                  break;
              case 2:
                  AdministationVoiture admin= new AdministationVoiture();
                  System.out.println("Menu");
                  System.out.println("1-Ajouter une voiture");
                  System.out.println("2-Supprimer une voiture");
                  System.out.println("3-Recherche par model de voitures");
                  System.out.println("4-Recherche par couleur");
                  System.out.println("5-Recherche par marque");
                  System.out.println("6-Recherche par reference");
                  System.out.println("7-Afficher toutes les voitures");
                  System.out.println("Donnez votre choix");
                  int choie=s.nextInt();
                  switch(choie){
                      case 1:
                          System.out.println("Donnez la reference de la voiture");
                          String ref=s.next();
                          System.out.println("Donnez la marque de la voiture");
                          String marque=s.next();
                          System.out.println("Donnez la modele de la voiture");
                          String modele=s.next();
                          System.out.println("Donnez la couleur de la voiture");
                          String couleur=s.next();
                          admin.AjouterVehicule(ref,marque,modele,couleur);
                          //Voiture v= new Voiture("3","7","8","8");
                          //voitureUtile.AjouterVoiture(v);
                          break;
                      case 2:
                          admin.SupprimerVehicule();
                          break;
                      case 3:
                          System.out.println("donnez votre modele");
                          String modeler=s.next();
                          System.out.println(admin.RecherchParModele(modeler));
                          break;
                      case 4:
                          System.out.println("donnez votre couleur");
                          String couleurr=s.next();
                          System.out.println(admin.RecherchParCouleur(couleurr));
                          break;
                      case 5:
                          System.out.println("donnez votre marque");
                          String marquet=s.next();
                          System.out.println(admin.RecherchParMarque(marquet));
                          break;
                      case 6:
                          System.out.println("donnez votre reference");
                          String reference=s.next();
                          System.out.println(admin.RecherchParReference(reference));
                          break;
                      case 7:
                          System.out.println(admin.GetAll());
                          break;
                      default:
                          System.out.println("erreur");
                          break;
                  }
                break;
              case 3:
                  AdministrationCamionette admine= new AdministrationCamionette();
                  System.out.println("Menu");
                  System.out.println("1-Ajouter une camionette");
                  System.out.println("2-Supprimer une camionette");
                  System.out.println("3-Recherche par model de camionette");
                  System.out.println("4-Recherche par couleur de camionette");
                  System.out.println("5-Recherche par marque de camionette");
                  System.out.println("6-Recherche par  refernce de camionette");
                  System.out.println("7-Afficher toutes les camionettes");
                  System.out.println("8-Recherche par charge maximale");
                  System.out.println("Donnez votre choix");
                  int choiee=s.nextInt();
                  switch(choiee){
                      case 1:
                          System.out.println("Donnez la reference de la camionnette");
                          String ref=s.next();
                          System.out.println("Donnez la marque de la camionnette");
                          String marque=s.next();
                          System.out.println("Donnez la modele de la camionnette");
                          String modele=s.next();
                          System.out.println("Donnez la couleur de la camionnette");
                          String couleur=s.next();
                          System.out.println("Donnez la chargeMax de la camionnette");
                          double chargemax=s.nextDouble();
                          admine.AjouterVehicule(ref,marque,modele,couleur,chargemax);
                          break;
                      case 2:
                          admine.SupprimerVehicule();
                          break;
                      case 3:
                          System.out.println("donnez votre modele");
                          String modelee=s.next();
                          System.out.println(admine.RecherchParModele(modelee));
                          break;
                      case 4:
                          System.out.println("donnez votre couleur");
                          String couleure=s.next();
                          System.out.println(admine.RecherchParCouleur(couleure));
                          break;
                      case 5:
                          System.out.println("donnez votre marque");
                          String marquee=s.next();
                          System.out.println(admine.RecherchParMarque(marquee));
                          break;
                      case 6:
                          System.out.println("donnez votre reference");
                          String reference=s.next();
                          System.out.println(admine.RecherchParReference(reference));
                          break;
                      case 7:
                          System.out.println(admine.GetAll());
                          break;
                      case 8:
                          System.out.println("donnez votre chargemax");
                          double charge=s.nextDouble();
                          System.out.println(admine.RecherchParChargeMax(charge));
                          break;
                      default:
                          System.out.println("erreur");
                          break;
                  }
                 break;
                  case 4:
                  AdministrationiMiniBus adminee= new AdministrationiMiniBus();
                  System.out.println("Menu");
                  System.out.println("1-Ajouter une minibus");
                  System.out.println("2-Supprimer une minibus");
                  System.out.println("3-Recherche par model de minibus");
                  System.out.println("4-Recherche par couleur de minibus");
                  System.out.println("5-Recherche par marque de minibus");
                  System.out.println("6-Recherche par reference de minibus");
                  System.out.println("7-Afficher toutes les minibus");
                  System.out.println("8-Recherche par nombres de places de  minibus");
                  System.out.println("Donnez votre choix");
                  int choieee=s.nextInt();
                  switch(choieee){
                      case 1:
                          System.out.println("Donnez la reference de la minibus");
                          String ref=s.next();
                          System.out.println("Donnez la marque de la minibus");
                          String marque=s.next();
                          System.out.println("Donnez la modele de la minibus");
                          String modele=s.next();
                          System.out.println("Donnez la couleur de la minibus");
                          String couleur=s.next();
                          System.out.println("Donnez la nombre de places de minibus");
                          int nbplaces=s.nextInt();
                          adminee.AjouterVehicule(ref,marque,modele,couleur,nbplaces);
                          break;
                      case 2:
                          adminee.SupprimerVehicule();
                          break;
                      case 3:
                          System.out.println("donnez votre modele");
                          String modeleq=s.next();
                          System.out.println(adminee.RecherchParModele(modeleq));
                          break;
                      case 4:
                          System.out.println("donnez votre couleur");
                          String couleurq=s.next();
                          System.out.println(adminee.RecherchParCouleur(couleurq));
                          break;
                      case 5:
                          System.out.println("donnez votre marque");
                          String marqueq=s.next();
                          System.out.println(adminee.RecherchParMarque(marqueq));
                          break;
                      case 6:
                          System.out.println("donnez votre reference");
                          String reference=s.next();
                          System.out.println(adminee.RecherchParReference(reference));
                          break;
                      case 7:
                          System.out.println(adminee.GetAll());
                          break;
                      case 8:
                          System.out.println("Donnez le nombre de places de la minibus");
                          int nbreplace=s.nextInt();
                          System.out.println(adminee.RecherchParnombredeplace(nbreplace));
                          break;
                      default:
                          System.out.println("erreur");
                  }
                  break;
                  default:
                      System.out.println("erreur");
                  
             
          }
          System.out.println("est ce que vous voulez entrer un autre choix si oui tapez :o sinon tapez :n");
          rep=s.next(); 
          
          
    }while(rep.equals("o"));
    
    
    
}}
