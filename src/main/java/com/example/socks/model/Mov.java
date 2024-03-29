package com.example.socks.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import javax.validation.constraints.Min;
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

    private  int sockId;


}
