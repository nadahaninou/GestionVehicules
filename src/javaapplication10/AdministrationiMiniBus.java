/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;


public class AdministrationiMiniBus  implements Administration<MiniBus> {
    java.util.Scanner s=new java.util.Scanner(System.in);
    private Connection con;
    public AdministrationiMiniBus() throws SQLException{
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/agence?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");}

    public boolean AjouterVehicule(String ref,String marque,String modele,String couleur,int nbreplace) {
        
        
        MiniBus v=new MiniBus(nbreplace,ref,marque,modele,couleur);
        String query = "INSERT INTO minibus (marque, modele, reference, couleur,nbplaces) VALUES (?, ?, ?, ?,?)";
    
    try (PreparedStatement stmt = con.prepareStatement(query)) {
        stmt.setString(1, v.getMarque());
        stmt.setString(2, v.getModele());
        stmt.setString(3, v.getRef());
        stmt.setString(4, v.getCouleur());
        stmt.setDouble(5, v.getNombrePlaces());

        int nbUpdated = stmt.executeUpdate();
        return nbUpdated > 0;
    }   catch (SQLException ex) {
            Logger.getLogger(AdministationVoiture.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean SupprimerVehicule() {
        System.out.println("Donnez la reference du minibus a supprimer");
        String ref=s.next();
        String requeteSuppression = "DELETE FROM minibus WHERE reference = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(requeteSuppression)) {
            preparedStatement.setString(1, ref);

            // Exécution de la requête de suppression
            int nombreLignesSupprimees = preparedStatement.executeUpdate();

            // Vérification du nombre de lignes supprimées
            if (nombreLignesSupprimees > 0) {
                System.out.println("Le minibus a été supprimée avec succès !");
            } else {
                System.out.println("Aucune minibus n'a été supprimée.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du minibus : " + e.getMessage());
        }
        return true;
    }

    @Override
    public LinkedList<MiniBus> RecherchParModele(String model) {
       LinkedList<MiniBus> listv=new LinkedList<MiniBus>();
        //System.out.println("Donnez le model de minibus a chercher");
        //String model=s.next();
        String requeteRecherche = "SELECT * FROM minibus WHERE modele = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteRecherche)) {
            preparedStatement.setString(1, model);

            // Exécution de la requête de recherche
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    MiniBus cami = new MiniBus(resultSet.getInt("nbplaces"),resultSet.getString("reference"),resultSet.getString("marque"),resultSet.getString("modele"),resultSet.getString("couleur"));
                    listv.add(cami);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des voitures : " + e.getMessage());
        }

        return listv;
        
    }

    @Override
    public LinkedList<MiniBus> RecherchParCouleur(String couleur) {
        LinkedList<MiniBus> listv=new LinkedList<MiniBus>();
        //System.out.println("Donnez la couleur de minibus a chercher");
        //String couleur=s.next();
        String requeteRecherche = "SELECT * FROM minibus WHERE couleur = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteRecherche)) {
            preparedStatement.setString(1, couleur);

            // Exécution de la requête de recherche
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    MiniBus cami = new MiniBus(resultSet.getInt("nbplaces"),resultSet.getString("reference"),resultSet.getString("marque"),resultSet.getString("modele"),resultSet.getString("couleur"));
                    listv.add(cami);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des voitures : " + e.getMessage());
        }

        return listv;
    }

    @Override
    public LinkedList<MiniBus> RecherchParMarque(String marque) {
        LinkedList<MiniBus> listv=new LinkedList<MiniBus>();
        //System.out.println("Donnez la marque de minibus a chercher");
        //String marque=s.next();
        String requeteRecherche = "SELECT * FROM minibus WHERE marque = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteRecherche)) {
            preparedStatement.setString(1, marque);

            // Exécution de la requête de recherche
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                   MiniBus cami = new MiniBus(resultSet.getInt("nbplaces"),resultSet.getString("reference"),resultSet.getString("marque"),resultSet.getString("modele"),resultSet.getString("couleur"));
                    listv.add(cami);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des voitures : " + e.getMessage());
        }

        return listv;
    }

    @Override
    public MiniBus RecherchParReference(String ref) {
        //System.out.println("Donnez la reference de la minibus a chercher");
        //String ref=s.next();
        MiniBus v=null;
        String requeteRecherche = "SELECT * FROM minibus WHERE reference = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteRecherche)) {
            preparedStatement.setString(1, ref);

            // Exécution de la requête de recherche
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                  v = new MiniBus(resultSet.getInt("nbplaces"),resultSet.getString("reference"),resultSet.getString("marque"),resultSet.getString("modele"),resultSet.getString("couleur"));
                   
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche de la voiture : " + e.getMessage());
        }

        return v;
    }

    @Override
    public LinkedList<MiniBus> GetAll() {
       LinkedList<MiniBus> listv=new LinkedList<MiniBus>();
       String requeteGetAll = "SELECT * FROM minibus";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteGetAll);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                MiniBus cami = new MiniBus(resultSet.getInt("nbplaces"),resultSet.getString("reference"),resultSet.getString("marque"),resultSet.getString("modele"),resultSet.getString("couleur"));
                listv.add(cami);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des voitures : " + e.getMessage());
        }

        return listv;
    }
    public LinkedList<MiniBus> RecherchParnombredeplace(int nbreplace) {
        
        LinkedList<MiniBus> listeMinibus = new LinkedList<>();
        String requeteRecherche = "SELECT * FROM minibus WHERE nbplaces = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteRecherche)) {
            preparedStatement.setInt(1, nbreplace);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    MiniBus cami = new MiniBus(resultSet.getInt("nbplaces"),resultSet.getString("reference"),resultSet.getString("marque"),resultSet.getString("modele"),resultSet.getString("couleur"));
                listeMinibus.add(cami);

                        
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des minibus par nombre de places : " + e.getMessage());
        }

        return listeMinibus;
    }
    
}
