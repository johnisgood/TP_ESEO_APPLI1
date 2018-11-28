package com.TP_ESEO_MAVEN;

import com.opencsv.bean.CsvBindByPosition;

public class LaPoste { 
	private static final long serialVersionUID = 1L; 

	@CsvBindByPosition(position = 0)
	private String Code_commune_INSEE;
	@CsvBindByPosition(position = 1)
	private String Nom_commune;
	@CsvBindByPosition(position = 2)
	private String Code_postal;
	@CsvBindByPosition(position = 3)
	private String Libelle_acheminement;
	@CsvBindByPosition(position = 4)
	private String Ligne_5;
	@CsvBindByPosition(position = 5)
	private String coordonnees_gps;

	
	//Getter and setter
	public String getCode_commune_INSEE() {
		return Code_commune_INSEE;
	}

	public void setCode_commune_INSEE(String code_commune_INSEE) {
		Code_commune_INSEE = code_commune_INSEE;
	}

	public String getNom_commune() {
		return Nom_commune;
	}
	public void setNom_commune(String nom_commune) {
		Nom_commune = nom_commune;
	}
	public String getCode_postal() {
		return Code_postal;
	}
	public void setCode_postal(String code_postal) {
		Code_postal = code_postal;
	}
	public String getLibelle_acheminement() {
		return Libelle_acheminement;
	}
	public void setLibelle_acheminement(String libelle_acheminement) {
		Libelle_acheminement = libelle_acheminement;
	}
	public String getLigne_5() {
		return Ligne_5;
	}
	public void setLigne_5(String ligne_5) {
		Ligne_5 = ligne_5;
	}
	public String getCoordonnees_gps() {
		return coordonnees_gps;
	}
	public void setCoordonnees_gps(String coordonnees_gps) {
		this.coordonnees_gps = coordonnees_gps;
	}

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("LaPoste{Code_commune_INSEE=").append(Code_commune_INSEE).append(", Nom_commune=")
                .append(Nom_commune).append(", Code_postal=").append(Code_postal).append(", Libelle_acheminement=")
                .append(Libelle_acheminement).append(", Ligne_5=").append(Ligne_5)
                .append(", coordonnees_gps=").append(coordonnees_gps)
                .append("}");
        
        return builder.toString();
    }
	
	
}//fin laPoste 
