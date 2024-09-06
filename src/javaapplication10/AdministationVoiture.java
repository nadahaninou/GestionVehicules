
package javaapplication10;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;


public class AdministationVoiture implements Administration<Voiture> {
    java.util.Scanner s=new java.util.Scanner(System.in);
    private Connection con;
    public AdministationVoiture() throws SQLException{
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/agence?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
       
    }

    public boolean AjouterVehicule(String ref,String marque,String modele,String couleur) {
        Voiture v=new Voiture(ref,marque,modele,couleur);
        //Agence.list.add(v);
        String query = "INSERT INTO voiture (marque, modele, reference, couleur) VALUES (?, ?, ?, ?)";
        
    try (PreparedStatement stmt = con.prepareStatement(query)) {
        stmt.setString(1, v.getMarque());
        stmt.setString(2, v.getModele());
        stmt.setString(3, v.getRef());
        stmt.setString(4, v.getCouleur());
        

        int nbUpdated = stmt.executeUpdate();
        return nbUpdated > 0;
    }   catch (SQLException ex) {
            Logger.getLogger(AdministationVoiture.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
}
        

    @Override
        
        public boolean SupprimerVehicule() {
        // Référence prédéfinie à supprimer
        System.out.println("donnez la reference de la voiture a supprimer");
        String ref=s.next();

        String requeteSuppression = "DELETE FROM voiture WHERE reference = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteSuppression)) {
            preparedStatement.setString(1, ref);

            // Exécution de la requête de suppression
            int nombreLignesSupprimees = preparedStatement.executeUpdate();

            // Vérification du nombre de lignes supprimées
            if (nombreLignesSupprimees > 0) {
                System.out.println("La voiture a été supprimée avec succès !");
            } else {
                System.out.println("Aucune voiture n'a été supprimée.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la voiture : " + e.getMessage());
        }
        return true;
    }


     
    @Override
    public LinkedList<Voiture> RecherchParModele(String modele) {
        
        LinkedList<Voiture> listeVoitures = new LinkedList<>();

        String requeteRecherche = "SELECT * FROM voiture WHERE modele = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteRecherche)) {
            preparedStatement.setString(1, modele);

            // Exécution de la requête de recherche
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Voiture voiture = new Voiture(resultSet.getString("reference"),resultSet.getString("marque"),resultSet.getString("modele"),resultSet.getString("couleur"));
                    
                    
                    listeVoitures.add(voiture);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des voitures : " + e.getMessage());
        }

        return listeVoitures;
    }


    @Override
   
   public LinkedList<Voiture> RecherchParCouleur(String couleur) {
       
        LinkedList<Voiture> listeVoitures = new LinkedList<>();

        String requeteRecherche = "SELECT * FROM voiture WHERE couleur = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteRecherche)) {
            preparedStatement.setString(1, couleur);

            // Exécution de la requête de recherche
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Voiture voiture = new Voiture(resultSet.getString("reference"),resultSet.getString("marque"),resultSet.getString("modele"),resultSet.getString("couleur"));
                    listeVoitures.add(voiture);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des voitures : " + e.getMessage());
        }

        return listeVoitures;
    }


    @Override
    public LinkedList<Voiture> RecherchParMarque(String marque){
        
        LinkedList<Voiture> listeVoitures = new LinkedList<>();

        String requeteRecherche = "SELECT * FROM voiture WHERE marque = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteRecherche)) {
            preparedStatement.setString(1, marque);

            // Exécution de la requête de recherche
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Voiture voiture = new Voiture(resultSet.getString("reference"),resultSet.getString("marque"),resultSet.getString("modele"),resultSet.getString("couleur"));
                    listeVoitures.add(voiture);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des voitures : " + e.getMessage());
        }

        return listeVoitures;
    }


    @Override
    public Voiture RecherchParReference(String reference) {
        Voiture voiture = null;
        String requeteRecherche = "SELECT * FROM voiture WHERE reference = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteRecherche)) {
            preparedStatement.setString(1, reference);

            // Exécution de la requête de recherche
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    voiture = new Voiture(resultSet.getString("reference"),resultSet.getString("marque"),resultSet.getString("modele"),resultSet.getString("couleur"));
                   
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche de la voiture : " + e.getMessage());
        }

        return voiture;
    }


    @Override
    public LinkedList<Voiture> GetAll() {
        LinkedList<Voiture> listeVoitures = new LinkedList<>();

        String requeteGetAll = "SELECT * FROM voiture";

        try (PreparedStatement preparedStatement = con.prepareStatement(requeteGetAll);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Voiture voiture = new Voiture(resultSet.getString("reference"),resultSet.getString("marque"),resultSet.getString("modele"),resultSet.getString("couleur"));
                listeVoitures.add(voiture);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des voitures : " + e.getMessage());
        }

        return listeVoitures;
    }
}

