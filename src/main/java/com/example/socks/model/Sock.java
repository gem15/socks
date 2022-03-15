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
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Sock {

	@Id private int ID;

	@NotEmpty
	@NotBlank
	private String color;
	
	private int cottonPart;

	@Min(1)
	private int quantity;

}
