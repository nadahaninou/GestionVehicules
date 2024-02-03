/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author nada haninou
 */
public class connex {
    private Connection con;
    public  connex() throws SQLException{
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/agence?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");}
    public  LinkedList<Vehicule> afficherTousLesVehicules() {
        LinkedList<Vehicule> listeVehicules = new LinkedList<>();
        String requeteRechercheVoiture = "SELECT * FROM voiture"; // Requête pour récupérer les voitures
        String requeteRechercheMiniBus = "SELECT * FROM minibus"; // Requête pour récupérer les minibus
        String requeteRechercheCamionnette = "SELECT * FROM camionnette"; // Requête pour récupérer les camionnettes
        try {
            // Récupération des voitures
            try (PreparedStatement preparedStatementVoiture = con.prepareStatement(requeteRechercheVoiture);
                 ResultSet resultSetVoiture = preparedStatementVoiture.executeQuery()) {
                while (resultSetVoiture.next()) {
                    Voiture voiture = new Voiture(resultSetVoiture.getString("reference"),resultSetVoiture.getString("marque"),resultSetVoiture.getString("modele"),resultSetVoiture.getString("couleur"));
                    
                    
                    

                    listeVehicules.add(voiture);
                }
            }

            // Récupération des minibus
            try (PreparedStatement preparedStatementMiniBus = con.prepareStatement(requeteRechercheMiniBus);
                 ResultSet resultSetMiniBus = preparedStatementMiniBus.executeQuery()) {
                while (resultSetMiniBus.next()) {
                    MiniBus cami = new MiniBus(resultSetMiniBus.getInt("nbplaces"),resultSetMiniBus.getString("reference"),resultSetMiniBus.getString("marque"),resultSetMiniBus.getString("modele"),resultSetMiniBus.getString("couleur"));
                    

                    listeVehicules.add(cami);
                }
            }

            // Récupération des camionnettes
            try (PreparedStatement preparedStatementCamionnette = con.prepareStatement(requeteRechercheCamionnette);
                 ResultSet resultSetCamionnette = preparedStatementCamionnette.executeQuery()) {
                while (resultSetCamionnette.next()) {
                    Camionnette cami = new Camionnette(resultSetCamionnette.getDouble("chargeMax"),resultSetCamionnette.getString("reference"),resultSetCamionnette.getString("marque"),resultSetCamionnette.getString("modele"),resultSetCamionnette.getString("couleur"));
                    

                    listeVehicules.add(cami);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de tous les véhicules : " + e.getMessage());
        }

        return listeVehicules;
    }
}
