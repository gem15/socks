package com.example.socks.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class Mov {
    @Id
    private int ID;
    @Version
    private int ver;
    @CreatedDate
    private Date createdDate;

    @Min(1)
    private int quantity;

    @MappedCollection(idColumn = "sock_id")
    private Sock sock;

}
