package javaapplication10;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VoitureUtile{
    private Connection con;
    public VoitureUtile() throws SQLException{
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/agence?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
       
    }
    public boolean AjouterVoiture(Voiture d) throws SQLException {
    String query = "INSERT INTO voiture (marque, modele, reference, couleur) VALUES (?, ?, ?, ?)";
    
    try (PreparedStatement stmt = con.prepareStatement(query)) {
        stmt.setString(1, d.getMarque());
        stmt.setString(2, d.getModele());
        stmt.setString(3, d.getRef());
        stmt.setString(4, d.getCouleur());

        int nbUpdated = stmt.executeUpdate();
        return nbUpdated > 0;
    }
}}