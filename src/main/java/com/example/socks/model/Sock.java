/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Gennady
 * License Type: Purchased
 */
package com.example.socks.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.MappedCollection;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Data
public class Sock {

	@Id private int ID;
	@Version private int ver;
	@CreatedDate private Date createdDate;

	@NotEmpty
	@NotBlank
	private String color;
	
	private int cottonPart;

	@Min(1)
	private int quantity;

	@MappedCollection(idColumn = "sock_id")
	private Set<Mov> movs;

}
