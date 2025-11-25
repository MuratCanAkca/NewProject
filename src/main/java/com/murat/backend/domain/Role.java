package com.murat.backend.domain;

import com.murat.backend.domain.enums.RoleType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleType name;

}
