package com.crud.library.controller;

import com.crud.library.domain.*;
import com.crud.library.exceptions.BookNotFoundException;
import com.crud.library.exceptions.CopyNotFoundException;
import com.crud.library.mapper.CopyMapper;
import com.crud.library.mapper.HireMapper;
import com.crud.library.mapper.BookMapper;
import com.crud.library.mapper.UserMapper;
import com.crud.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/library")
@RequiredArgsConstructor
public class LibraryController {

    private final DbService service;
    private final CopyMapper copyMapper;
    private final HireMapper hireMapper;
    private final BookMapper bookMapper;
    private final UserMapper userMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "addUser")
    public ResponseEntity<Void> addUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        service.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "addBook")
    public ResponseEntity<Void> addBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        service.saveBook(book);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "addCopy")
    public ResponseEntity<Void> addCopy(@RequestBody CopyDto copyDto) {
        Copy copy = copyMapper.mapToCopy(copyDto);
        service.saveCopy(copy);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<CopyDto> updateStatusOfCopy(@RequestBody CopyDto copyDto) {
        Copy copy = copyMapper.mapToCopy(copyDto);
        Copy modifiedStatusCopy = service.changeStatus(copy);
        return ResponseEntity.ok(copyMapper.mapToCopyDto(modifiedStatusCopy));
    }

    @GetMapping(value = "{bookId}")
    public ResponseEntity<Integer> getQuantityOfAvailableCopies(@PathVariable Long bookId) {
        return ResponseEntity.ok(service.checkAmountOfCopies(bookId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "hireABook")
    public ResponseEntity<Void> hireABook(@RequestBody HireDto hireDto) {
        Hire hire = hireMapper.mapToHire(hireDto);
        service.saveHire(hire);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{hireId}")
    public ResponseEntity<Void> returnABook(@PathVariable Long hireId) {
        service.deleteHire(hireId);
        return ResponseEntity.ok().build();
    }
}
