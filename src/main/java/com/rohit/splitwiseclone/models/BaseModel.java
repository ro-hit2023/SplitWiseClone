package com.rohit.splitwiseclone.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
@MappedSuperclass
@Data
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date CreatedDate;

    @LastModifiedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date UpdatedDate;
}
