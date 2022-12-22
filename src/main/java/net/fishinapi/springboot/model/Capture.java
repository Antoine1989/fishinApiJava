package net.fishinapi.springboot.model;

import java.sql.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;




@Entity
@Table (name ="capture")
public class Capture {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private int capture_id;
	
	@Column (name="type")
	private String type;
	
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
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="spot_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	//@JsonIgnoreProperties("spot")
    private Spot spot;
	
	
	
	public Capture() {}

	
	public Capture(String type, String nom, String technique, int quantite, double poids, double longueur,
			Date date_peche, String maree, long coef, String commentaires, String photo, Spot spot) {
		super();
		this.type = type;
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
		this.spot = spot;
	
	}


	public int getCapture_id() {
		return capture_id;
	}

	public void setCapture_id(int capture_id) {
		this.capture_id = capture_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}


	@Override
	public String toString() {
		return "Capture [capture_id=" + capture_id + ", type=" + type + ", nom=" + nom + ", technique=" + technique
				+ ", quantite=" + quantite + ", poids=" + poids + ", longueur=" + longueur + ", date_peche="
				+ date_peche + ", maree=" + maree + ", coef=" + coef + ", commentaires=" + commentaires + ", photo="
				+ photo + ", spot=" + spot + "]";
	}

				
}
	