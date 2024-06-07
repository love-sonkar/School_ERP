package com.School_ERP.model;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long parentId;
    @Column
    @NotNull()
    private String fname;
    @Column
    @NotNull()
    private String lname;
    @Column
    @NotNull()
    private String address;
    @Column
    @NotNull()
    private String email;
    @Column
    @NotNull()
    private long contact;
}
