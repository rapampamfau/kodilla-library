package com.crud.library.controller;

import com.crud.library.domain.*;
import com.crud.library.exceptions.CopyNotFoundException;
import com.crud.library.mapper.CopyMapper;
import com.crud.library.mapper.HireMapper;
import com.crud.library.mapper.TitleMapper;
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
    private final TitleMapper titleMapper;
    private final UserMapper userMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "addUser")
    public ResponseEntity<Void> addUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        service.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "addTitle")
    public ResponseEntity<Void> addTitle(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        service.saveTitle(title);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "addCopy")
    public ResponseEntity<Void> addCopy(@RequestBody CopyDto copyDto) {
        Copy copy = copyMapper.mapToCopy(copyDto);
        service.saveCopy(copy);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Copy> updateStatusOfCopy(Long copyId) throws CopyNotFoundException {
        return ResponseEntity.ok(service.changeStatus(copyId));
    }

    @GetMapping
    public ResponseEntity<Integer> getQuantityOfAvailableCopies(Long titleId) {
        return ResponseEntity.ok(service.checkAmountOfCopies(titleId));
    }

    @PostMapping
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
