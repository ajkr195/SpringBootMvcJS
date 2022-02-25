package com.spring.boot.rocks.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "salutation")
	private String salutation;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "preference")
	private String preference;

	public AppUser(String salutation, String name, String email, String preference, List<Address> addressList,
			List<Expertise> expertise) {
		super();
		this.salutation = salutation;
		this.name = name;
		this.email = email;
		this.preference = preference;
		this.addressList = addressList;
		this.expertise = expertise;
	}

	@OneToMany(orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "address_id")
	private List<Address> addressList = new ArrayList<>();

	@OneToMany(orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "expertise_id")
	private List<Expertise> expertise = new ArrayList<>();

}
