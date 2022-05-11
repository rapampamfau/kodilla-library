package com.crud.library.domain;

import com.crud.library.controller.StatusOfCopy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedNativeQuery(
        name = "Copy.getAvailableCopiesOfTitle",
        query = "SELECT * FROM COPIES_OF_TITLE WHERE (TITLE_ID = :titleId AND STATUS = 'AVAILABLE'"
)

@Getter
@Setter
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
    private StatusOfCopy status;
}
