package com.stl.account.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customers")
@Entity
public class Account {

	@Id
	@GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "user_sequence"),
        @Parameter(name = "initial_value", value = "10000000"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private int customerId;
	private int accountId;
	private String type;
	private String ifscCode;
	private long amount;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private int zip;
	private String phone;
	private String email;
	private String password;
	
	
}
