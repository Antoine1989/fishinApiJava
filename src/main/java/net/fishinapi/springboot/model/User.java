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
    private List<Spot> listspot = new ArrayList<>();
	
	
	
	public User() {}
	
	public User(String nom, String password) {
		this.nom = nom;
		this.password = password;
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

	/*public List<Spot> getSpot() {
		return spot;
	}

	public void setSpot(List<Spot> spot) {
		this.spot = spot;
	}*/

	public void addSpot(Spot spot) {
		listspot.add(spot);
		spot.setUser(this);
	
	}
	
}
