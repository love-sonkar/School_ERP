package com.School_ERP.controller;

import com.School_ERP.dto.LibraryDto;
import com.School_ERP.links.LibraryLinks;
import com.School_ERP.repository.LibraryRepository;
import com.School_ERP.service.LibraryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @GetMapping(path = LibraryLinks.GET_ALL_BOOKS)
    public List<LibraryDto> getAllBookList(){
        return libraryService.findAllBook();
    }

    @GetMapping("/getrequest/{bookId}")
    public LibraryDto getRequestById(@PathVariable String bookId) throws JsonProcessingException {
        return libraryService.findByIdLibrary(Long.parseLong(bookId));
    }

    @DeleteMapping(path = LibraryLinks.DELETE_BOOK)
    public ResponseEntity<?> deleteBookByBookId(@PathVariable String bookID) throws JsonProcessingException{
        return libraryService.deleteBook(Long.parseLong(bookID));
    }

    @PostMapping(path = LibraryLinks.ADD_BOOK)
    public ResponseEntity<?> addBooks(@RequestBody LibraryDto libraryDto) throws JsonProcessingException {
        return libraryService.addBook(libraryDto);
    }

    @PostMapping("/assignee-book/{studentId}/{bookId}")
    public ResponseEntity<?> assigneeBook(@PathVariable String studentId,@PathVariable String bookId) throws JsonProcessingException {
        return libraryService.assingeeBook(studentId,bookId);
    }

    @PutMapping(path = LibraryLinks.UPDATE_BOOK)
    public ResponseEntity<?> updateBook(@PathVariable String bookId, @RequestBody LibraryDto libraryDto) throws JsonProcessingException{
        return libraryService.updateBook(Long.parseLong(bookId),libraryDto);
    }
}
