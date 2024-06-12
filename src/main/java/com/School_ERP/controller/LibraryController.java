package com.School_ERP.controller;

import com.School_ERP.dto.LibraryDto;
import com.School_ERP.entity.Library;
import com.School_ERP.links.LibraryLinks;
import com.School_ERP.service.LibraryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(LibraryLinks.LIBRARY)
@Tag(name = "Library", description = "API for Library")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @Operation(summary = "Getting all the books")
    @GetMapping(path = LibraryLinks.GET_ALL_BOOKS)
    public List<LibraryDto> getAllBookList(){
        return libraryService.findAllBook();
    }

    @GetMapping("/getrequest/{bookId}")
    @Operation(summary = "Get book by Id")
    public LibraryDto getRequestById(@PathVariable String bookId)  {
        return libraryService.findByIdLibrary(Long.parseLong(bookId));
    }

    @DeleteMapping(path = LibraryLinks.DELETE_BOOK)
    @Operation(summary = "Delete  book")
    public ResponseEntity<?> deleteBookByBookId(@PathVariable String bookID){
        return libraryService.deleteBook(Long.parseLong(bookID));
    }

    @PostMapping(path = LibraryLinks.ADD_BOOK)
    @Operation(summary = "Adding  book")
    public ResponseEntity<?> addBooks(@RequestBody LibraryDto libraryDto) {
        return libraryService.addBook(libraryDto);
    }

    @PostMapping(path = LibraryLinks.ASSIGNEDBOOK_TO_STUDENT)
    @Operation(summary = "Assigned book")
    public ResponseEntity<?> assigneeBook(@PathVariable String adm_no,@PathVariable String bookId) {

        return libraryService.assingeeBook(Integer.parseInt(adm_no),Long.parseLong(bookId));
    }
    @PostMapping(path = LibraryLinks.RETURNED_BOOK)
    public ResponseEntity<?> returnBook(@PathVariable String bookId){
        return libraryService.returnBook(Long.parseLong(bookId));
    }
    @PostMapping(path = LibraryLinks.SEARCH_BY_BOOK_NAME)
    public List<LibraryDto> searchByBookName(@PathVariable String books){
        return libraryService.searchByBookName(books);
    }

    @PutMapping(path = LibraryLinks.UPDATE_BOOK)
    @Operation(summary = "Update book")
    public ResponseEntity<?> updateBook(@PathVariable String bookId, @RequestBody LibraryDto libraryDto){
        return libraryService.updateBook(Long.parseLong(bookId),libraryDto);
    }
}
