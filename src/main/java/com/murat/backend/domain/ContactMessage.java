package com.murat.backend.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_cmessage")
public class ContactMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Please provide your name")
    @Size(min = 1, max = 50, message = "Your Name '${validatedValue}' must be between {min} and {max} chars long")
    @Column(length = 50, nullable = false)
    private String name;

    @NotNull(message = "Please provide your subject")
    @Size(min = 5, max = 50, message = "Your Subject '${validatedValue}' must be between {min} and {max} chars long")
    @Column(length = 50, nullable = false)
    private String subject;

    @NotNull(message = "Please provide message body")
    @Size(min = 50, max = 250, message = "Your Body '${validatedValue}' must be between {min} and {max} chars long")
    @Column(length = 250, nullable = false)
    private String body;

    @Email(message = "Please provide your email")
    @Column(length = 50, nullable = false)
    private String email;
}
