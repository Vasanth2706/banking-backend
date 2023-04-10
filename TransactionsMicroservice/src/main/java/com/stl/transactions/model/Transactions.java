package com.stl.transactions.model;

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
@Table(name="transactions")
@Entity
public class Transactions {
	
	@Id
	@GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "transaction_sequence"),
        @Parameter(name = "initial_value", value = "777777"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private int transactionId;
	private int customerId;
	private int payerAccountId;
	private String payerIfsc;
	private int receiveAccountId;
	private String receiveIfsc;
	private String receiveType;
	private int amount;
	LocalDateTime timeStamp;
	
		
}
