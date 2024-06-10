package com.School_ERP.service;

import com.School_ERP.dto.LibraryDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LibraryService {

    ResponseEntity<?> addBook(LibraryDto libraryDto) throws JsonProcessingException;

    ResponseEntity<?> assingeeBook(String studentId, String bookId) throws JsonProcessingException;

    LibraryDto searchByBookName(String bookName);

    ResponseEntity<?> deleteBook(long bookId) throws JsonProcessingException;

    List<LibraryDto> findAllBook();

    LibraryDto findByIdLibrary(long bookId) throws JsonProcessingException;

    ResponseEntity<?> updateBook(long bookId, LibraryDto libraryDto) throws JsonProcessingException;

}
