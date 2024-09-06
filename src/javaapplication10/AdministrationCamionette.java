/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication10;
import java.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.sql;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;

/**
 *
 * @author nada haninou
 */
public class AdministrationCamionette implements Administration<Camionnette> {
    java.util.Scanner s=new java.util.Scanner(System.in);
    private Connection con;
    public AdministrationCamionette() throws SQLException{
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/agence?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");}
    public boolean AjouterVehicule(String ref,String marque,String modele,String couleur,double chargemax) {
        
        
        Camionnette v=new Camionnette(chargemax,ref,marque,modele,couleur);
        String query = "INSERT INTO camionnette (marque, modele, reference, couleur,chargeMax) VALUES (?, ?, ?, ?,?)";
    
    try (PreparedStatement stmt = con.prepareStatement(query)) {
        stmt.setString(1, v.getMarque());
        stmt.setString(2, v.getModele());
        stmt.setString(3, v.getRef());
        stmt.setString(4, v.getCouleur());
        stmt.setDouble(5, v.getChargeMax());

        int nbUpdated = stmt.executeUpdate();
        return nbUpdated > 0;
    }   catch (SQLException ex) {
            Logger.getLogger(AdministationVoiture.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
}
     

    @Override
    public boolean SupprimerVehicule() {
        System.out.println("Donnez la reference de la camionnette a supprimer");
        String ref=s.next();
         String requeteSuppression = "DELETE FROM camionnette WHERE reference = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(requeteSuppression)) {
            preparedStatement.setString(1, ref);

            // Exécution de la requête de suppression
            int nombreLignesSupprimees = preparedStatement.executeUpdate();

            // Vérification du nombre de lignes supprimées
            if (nombreLignesSupprimees > 0) {
                System.out.println("La camionnette a été supprimée avec succès !");
            } else {
                System.out.println("Aucune camionnette n'a été supprimée.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la camionnette : " + e.getMessage());
        }
        return true;
    }

    @Override
    public LinkedList<Camionnette> RecherchParModele(String model) {
       LinkedList<Camionnette> listv=new LinkedList<Camionnette>();
        //System.out.println("Donnez le model de camionnettes a chercher");
        //String model=s.next();
        String requeteRecherche = "SELECT * FROM camionnette WHERE modele = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteRecherche)) {
            preparedStatement.setString(1, model);

            // Exécution de la requête de recherche
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Camionnette cami = new Camionnette(resultSet.getDouble("chargeMax"),resultSet.getString("reference"),resultSet.getString("marque"),resultSet.getString("modele"),resultSet.getString("couleur"));
                    
                    
                    listv.add(cami);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des voitures : " + e.getMessage());
        }

        return listv;
        
    }

    @Override
    public LinkedList<Camionnette> RecherchParCouleur(String couleur) {
        LinkedList<Camionnette> listv=new LinkedList<Camionnette>();
        //System.out.println("Donnez la couleur de camionnettes a chercher");
        //String couleur=s.next();
        String requeteRecherche = "SELECT * FROM camionnette WHERE couleur = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteRecherche)) {
            preparedStatement.setString(1, couleur);

            // Exécution de la requête de recherche
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Camionnette cami = new Camionnette(resultSet.getDouble("chargeMax"),resultSet.getString("reference"),resultSet.getString("marque"),resultSet.getString("modele"),resultSet.getString("couleur"));
                    listv.add(cami);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des voitures : " + e.getMessage());
        }

        return listv;
    }

    @Override
    public LinkedList<Camionnette> RecherchParMarque(String marque) {
        LinkedList<Camionnette> listv=new LinkedList<Camionnette>();
        //System.out.println("Donnez la marque de camionnettes a chercher");
        //String marque=s.next();
        String requeteRecherche = "SELECT * FROM camionnette WHERE marque = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteRecherche)) {
            preparedStatement.setString(1, marque);

            // Exécution de la requête de recherche
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Camionnette cami = new Camionnette(resultSet.getDouble("chargeMax"),resultSet.getString("reference"),resultSet.getString("marque"),resultSet.getString("modele"),resultSet.getString("couleur"));
                    listv.add(cami);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des voitures : " + e.getMessage());
        }

        return listv;
    }

    @Override
    public Camionnette RecherchParReference(String ref) {
        //System.out.println("Donnez la reference de la camionnette a chercher");
        //String ref=s.next();
        Camionnette v=null;
        String requeteRecherche = "SELECT * FROM camionnette WHERE reference = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteRecherche)) {
            preparedStatement.setString(1, ref);

            // Exécution de la requête de recherche
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                  v = new Camionnette(resultSet.getDouble("chargeMax"),resultSet.getString("reference"),resultSet.getString("marque"),resultSet.getString("modele"),resultSet.getString("couleur"));
                   
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche de la voiture : " + e.getMessage());
        }

        return v;
    }

    @Override
    public LinkedList<Camionnette> GetAll() {
       LinkedList<Camionnette> listv=new LinkedList<Camionnette>();
       String requeteGetAll = "SELECT * FROM camionnette";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteGetAll);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Camionnette cami = new Camionnette(resultSet.getDouble("chargeMax"),resultSet.getString("reference"),resultSet.getString("marque"),resultSet.getString("modele"),resultSet.getString("couleur"));
                    listv.add(cami);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des voitures : " + e.getMessage());
        }

        return listv;
    }
    public LinkedList<Camionnette> RecherchParChargeMax(double chargeMax) throws SQLException {
        
        LinkedList<Camionnette> listeCamionnettes = new LinkedList<>();
        String requeteRecherche = "SELECT * FROM camionnette WHERE chargeMax >= ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteRecherche)) {
            preparedStatement.setDouble(1, chargeMax);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Camionnette cami = new Camionnette(resultSet.getDouble("chargeMax"),resultSet.getString("reference"),resultSet.getString("marque"),resultSet.getString("modele"),resultSet.getString("couleur"));
                    listeCamionnettes.add(cami);
                }
                

}
            return listeCamionnettes;
        }
    }}
            