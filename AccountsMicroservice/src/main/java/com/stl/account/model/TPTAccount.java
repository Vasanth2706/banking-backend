package com.stl.account.model;

import java.time.LocalDateTime;

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
@Table(name="ThirdPartyAccounts")
@Entity
public class TPTAccount {
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
	int bnfId;
	int customerId;
	int bnfAccount;
	String bnfName;
	String bnfIfscCode;
	String accountType;
	LocalDateTime modified;
}
