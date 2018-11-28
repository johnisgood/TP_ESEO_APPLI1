package com.TP_ESEO_MAVEN;

import com.mysql.jdbc.PreparedStatement;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class OpenCSV {

    /*public static void main(String[] args) throws IOException {

        String fileName = "src/main/java/laposte_hexasmal.csv";

        try (FileInputStream fis = new FileInputStream(fileName);
                InputStreamReader isr = new InputStreamReader(fis, 
                        StandardCharsets.UTF_8);
                CSVReader reader = new CSVReader(isr)) {
            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {

                for (String e : nextLine) {
                    System.out.format("%s ", e);
                }
            }//fin while next line
        }//fin CSV reader
    }//fin main*/
    
    

        public static void main(String[] args) throws IOException, SQLException {
        	
        	//BDD
        	String url = "jdbc:mysql://127.0.0.1:8889/maven";
        	String driver = "com.mysql.cj.jdbc.Driver";
        	String utilisateur = "jack";
        	String motDePasse = "jack";
        	Connection connexion = null;
            Statement statement = null;
            ResultSet resultat = null;
            
    		/* Chargement du driver JDBC pour MySQL */
    		try {
    		    Class.forName( driver );
    		} catch ( ClassNotFoundException e ) {
    		    /* Gérer les éventuelles erreurs ici. */
    		}
            
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		    statement = connexion.createStatement();

            String fileName = "src/main/java/laposte_hexasmal.csv";
            Path myPath = Paths.get(fileName);

            try (BufferedReader br = Files.newBufferedReader(myPath,StandardCharsets.UTF_8)) {
                HeaderColumnNameMappingStrategy<LaPoste> strategy = new HeaderColumnNameMappingStrategy<LaPoste>();
                strategy.setType(LaPoste.class);

                CsvToBean<LaPoste> csvToBean = new CsvToBeanBuilder<LaPoste>(br)
                        .withType(LaPoste.class)
                        .withMappingStrategy(strategy)
                        .withSeparator(';')
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                List<LaPoste> laposte = csvToBean.parse();
                
                String sql = "INSERT INTO ville_france(Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude) VALUES (?,?,?,?,?,?,?)"; 
                
                
                for(int i=0; i < laposte.size(); i++) {
                	PreparedStatement ps = (PreparedStatement) connexion.prepareStatement(sql);
                	ps.setString(1, laposte.get(i).getCode_commune_INSEE());
                	ps.setString(2, laposte.get(i).getNom_commune());
                	ps.setString(3, laposte.get(i).getCode_postal());
                	ps.setString(4, laposte.get(i).getLibelle_acheminement());
                	ps.setString(5, laposte.get(i).getLigne_5());
                	ps.setString(6, "1555");
                	ps.setString(7, "1558");
                	ps.executeUpdate();
                	}
             
                
                connexion.close();
                
                //System.out.println(laposte.get(0));
                
               
                
                //insert dans la BDD
                //
                
            }
        }
    
    
    
}



