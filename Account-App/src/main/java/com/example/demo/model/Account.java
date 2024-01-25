package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Account")
public class Account {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_number")
	private String accountNumber;
	
	@Column(name = "account_holder_name")
	private String accountHolderName;
	
	@Column(name = "account_holder_address")
	private String accountHolderAddress;
	
	@Column(name = "account_holder_email")
	private String email;
	
}
