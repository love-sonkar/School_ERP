package com.School_ERP.entity;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull()
    private String title;

    @Column
    @NotNull()
    private String description;

    private String picture;

    private long createTimeStamp;
    private long modifiedTimeStamp;
}
