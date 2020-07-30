package entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Pays implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column(unique = true, length = 3, nullable = false)
	private int code;
	
	@Column(unique = true, length = 2, nullable = false)
	private String alpha2;
	
	@Column(unique = true, length = 3, nullable = false)
	private String alpha3;
	
	@Column(length = 45, nullable = false)
	private String nomEnGb;
	
	@Column(length = 45, nullable = false)
	private String nomFrFr;

	public Pays() {
	}

	public Pays(Long id, int code, String alpha2, String alpha3, String nomEnGb, String nomFrFr) {
		this.id = id;
		this.code = code;
		this.alpha2 = alpha2;
		this.alpha3 = alpha3;
		this.nomEnGb = nomEnGb;
		this.nomFrFr = nomFrFr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getAlpha2() {
		return alpha2;
	}

	public void setAlpha2(String alpha2) {
		this.alpha2 = alpha2;
	}

	public String getAlpha3() {
		return alpha3;
	}

	public void setAlpha3(String alpha3) {
		this.alpha3 = alpha3;
	}

	public String getNomEnGb() {
		return nomEnGb;
	}

	public void setNomEnGb(String nomEnGb) {
		this.nomEnGb = nomEnGb;
	}

	public String getNomFrFr() {
		return nomFrFr;
	}

	public void setNomFrFr(String nomFrFr) {
		this.nomFrFr = nomFrFr;
	}

	@Override
	public String toString() {
		return "Pays [id=" + id + ", code=" + code + ", alpha2=" + alpha2 + ", alpha3=" + alpha3 + ", nomEnGb="
				+ nomEnGb + ", nomFrFr=" + nomFrFr  + "]";
	}

	
}

