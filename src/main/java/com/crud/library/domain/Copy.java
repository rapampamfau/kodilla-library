package com.crud.library.domain;

import com.crud.library.controller.StatusOfCopy;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedNativeQuery(
        name = "Copy.getAvailableCopiesOfBook",
        query = "SELECT * FROM COPIES WHERE (BOOK_ID = :bookId AND STATUS = 'AVAILABLE')"
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BOOK_ID")
    private Book bookId;

    @Column(name = "STATUS")
    private StatusOfCopy status;
}
