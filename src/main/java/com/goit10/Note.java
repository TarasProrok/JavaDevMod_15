package com.goit10;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Note {
    @Id
    private long id;

    private String title;

    private String content;
}
