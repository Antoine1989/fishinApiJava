package net.fishinapi.springboot.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name ="user")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private int user_id;
	
	@Column (name="nom")
	private String nom;
	
	@Column (name="password")
	private String password;
	
	@OneToMany( targetEntity=Spot.class, mappedBy="user" )
    private List<Spot> spot = new ArrayList<>();
	
	@OneToMany( targetEntity=Capture.class, mappedBy="user" )
    private List<Capture> capture = new ArrayList<>();
	
	public User() {}

	public User(String nom, String password, List<Spot> spot, List<Capture> capture) {
		super();
		this.nom = nom;
		this.password = password;
		this.spot = spot;
		this.capture = capture;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Spot> getSpot() {
		return spot;
	}

	public void setSpot(List<Spot> spot) {
		this.spot = spot;
	}

	public List<Capture> getCapture() {
		return capture;
	}

	public void setCapture(List<Capture> capture) {
		this.capture = capture;
	}
	
	
	
	
}
