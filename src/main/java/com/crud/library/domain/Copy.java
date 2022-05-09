package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "COPIES_OF_TITLE")
public class Copy {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TITLE_ID")
    private Title titleId;

    @NotNull
    @Column(name = "STATUS")
    private String status;
}
