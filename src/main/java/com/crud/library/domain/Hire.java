package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "HIRES")
public class Hire {

    @Id
    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "COPY_ID")
    private Copy copy;

    @NotNull
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @NotNull
    @Column(name = "HIRE_DATE")
    private Date hireDate = new Date();

    @Column(name = "RETURN_DATE")
    private Date returnDate = new Date();
}
