package com.crud.library.domain;

import com.crud.library.controller.StatusOfCopy;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedNativeQuery(
        name = "Copy.getAvailableCopiesOfBook",
        query = "SELECT COUNT(*) BOOK_ID FROM COPIES WHERE (BOOK_ID = :book AND STATUS = 'AVAILABLE')"
)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "COPIES")
public class Copy {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID")
    private Book book;

    @Enumerated(EnumType.STRING)
    private StatusOfCopy status;
}
