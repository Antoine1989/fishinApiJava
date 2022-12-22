package net.fishinapi.springboot.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table (name ="spot")
public class Spot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spot_generator")//@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private long spot_id;
	
	@Column (name="nom")
	private String nomSpot;
	
	@Column (name="ville")
	private String ville;
	
	@ManyToOne @JoinColumn(name="user_id", nullable=false)
    private User user;
	
	/*@OneToMany( targetEntity=Capture.class, mappedBy="spot")
	@JsonIgnoreProperties("capture")
    private List<Capture> listcapture = new ArrayList<>();*/
	
	public Spot() {}

	public Spot(String nomSpot, String ville, User user /*, List<Capture> listcapture*/) {
		super();
		this.nomSpot = nomSpot;
		this.ville = ville;
		this.user = user;
		//this.listcapture = listcapture;
	}

	public long getSpot_id() {
		return spot_id;
	}

	/*public void setSpot_id(int spot_id) {
		this.spot_id = spot_id;
	}*/

	public String getNomSpot() {
		return nomSpot;
	}

	public void setNomSpot(String nomSpot) {
		this.nomSpot = nomSpot;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*public List<Capture> getCapture() {
		return listcapture;
	}

	public void setCapture(List<Capture> listcapture) {
		this.listcapture = listcapture;
	}
	
	
	public void addCapture(Capture capture) {
		listcapture.add(capture);
		capture.setSpot(this);
	
	}*/

	@Override
	public String toString() {
		return "Spot [spot_id=" + spot_id + ", nom=" + nomSpot + ", ville=" + ville + ", user=" + user /*+ ", listcapture="
				+ listcapture */+ "]";
	}
	

	
}
