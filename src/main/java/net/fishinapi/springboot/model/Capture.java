package net.fishinapi.springboot.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table (name ="Capture")
public class Capture {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private int id_capture;
	
	@Column (name="type")
	private TypeCapture type;
	
	@Column (name="nom")
	private String nom;
	
	@Column (name="technique")
	private String technique;
	
	@Column (name="quantite")
	private int quantite;
	
	@Column (name="poids")
	private double poids;
	
	@Column (name="longueur")
	private double longueur;
	
	@Column (name="date_peche")
	private Date date_peche;
	
	@Column (name="maree")
	private String maree;
	
	@Column (name="coef")
	private long coef;
	
	@Column (name="commentaires")
	private String commentaires;
	
	@Column (name="photo")
	private String photo;
	
	@Column (name="spot_id")
	private int spot_id;
	
	@Column (name="user_id")
	private int user_id;
	
	public Capture() {}
	
	public Capture(TypeCapture type,String nom, String technique, int quantite, double poids, double longueur, Date date_peche,
			String maree, long coef, String commentaires, String photo, int spot_id, int user_id) {
		super();
		this.type=type;
		this.nom = nom;
		this.technique = technique;
		this.quantite = quantite;
		this.poids = poids;
		this.longueur = longueur;
		this.date_peche = date_peche;
		this.maree = maree;
		this.coef = coef;
		this.commentaires = commentaires;
		this.photo = photo;
		this.spot_id = spot_id;
		this.user_id = user_id;
		
				
	}

	public int getId_capture() {
		return id_capture;
	}

	public void setId_capture(int id_capture) {
		this.id_capture = id_capture;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public TypeCapture getType() {
		return type;
	}

	public void setType(TypeCapture type) {
		this.type = type;
	}

	public String getTechnique() {
		return technique;
	}

	public void setTechnique(String technique) {
		this.technique = technique;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public Date getDate_peche() {
		return date_peche;
	}

	public void setDate_peche(Date date_peche) {
		this.date_peche = date_peche;
	}

	public String getMaree() {
		return maree;
	}

	public void setMaree(String maree) {
		this.maree = maree;
	}

	public long getCoef() {
		return coef;
	}

	public void setCoef(long coef) {
		this.coef = coef;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getSpot_id() {
		return spot_id;
	}

	public void setSpot_id(int spot_id) {
		this.spot_id = spot_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	
}
	