package com.TP_ESEO_MAVEN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class BDD {
	
	/* Connexion à la base de données */
	String url = "jdbc:mysql://127.0.0.1:8889/maven";
	String driver = "com.mysql.cj.jdbc.Driver";
	String utilisateur = "jack";
	String motDePasse = "jack";
	Connection connexion = null;
    Statement statement = null;
    ResultSet resultat = null;
	


	public void connection() throws SQLException {
		
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( driver );
		} catch ( ClassNotFoundException e ) {
		    /* Gérer les éventuelles erreurs ici. */
		}
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		    statement = connexion.createStatement();
		    resultat = statement.executeQuery( "SELECT * FROM ville_france;" );
		    System.out.println("Résultat");
		    System.out.println(resultat);
		    
		    while ( resultat.next() ) {
		        int codeCommune = resultat.getInt( "Code_commune_INSEE" );
		        String nomCommune = resultat.getString( "Nom_commune" );
		        String codePostal = resultat.getString( "code_postal" );
		        String LibelleAcheminement = resultat.getString( "Libelle_acheminement" );
		        String ligne5 = resultat.getString( "Ligne_5" );
		        String latitude = resultat.getString( "Latitude" );
		        String longitude = resultat.getString( "Longitude" );
		        
		        System.out.println(codeCommune+" "+nomCommune+" "+codePostal+" "+LibelleAcheminement+" "+ligne5+" "+latitude+" "+longitude);

		        /* Traiter ici les valeurs récupérées. */
		    }

		    /* Ici, nous placerons nos requêtes vers la BDD */
		    /* ... */		
		
	}//fin class connection
	

	    
	
	
	
	public static void main(String[] args) throws SQLException {
		BDD main = new BDD();
		main.connection();

	}

}
