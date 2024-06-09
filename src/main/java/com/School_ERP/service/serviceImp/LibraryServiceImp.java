package com.School_ERP.service.serviceImp;
import com.School_ERP.dto.LibraryDto;
import com.School_ERP.entity.Library;
import com.School_ERP.repository.LibraryRepository;
import com.School_ERP.service.LibraryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryServiceImp implements LibraryService {


    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public List<LibraryDto> findAllBook() {
        List<Library> listLibrary = libraryRepository.findAll();
        List<LibraryDto> list = listLibrary.stream().map(library -> {
            LibraryDto dto = null;
            try {
                dto = new ObjectMapper().readValue(library.toString(), LibraryDto.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return dto;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public LibraryDto findByIdLibrary(long bookId) throws JsonProcessingException {
        Library library = libraryRepository.findByBookId(bookId);
        LibraryDto lDto = new ObjectMapper().readValue(library.toString(), LibraryDto.class);
        return lDto;
    }


    @Override
    public ResponseEntity<?> addBook(LibraryDto libraryDto) throws JsonProcessingException {
        if(libraryDto.getBooks() != null){
            Library library = new ObjectMapper().readValue(libraryDto.toString(), Library.class);
            libraryRepository.save(library);
            return ResponseEntity.ok(library);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
    }

    @Override
    public ResponseEntity<?> assingeeBook(String studentId, String bookId) throws JsonProcessingException {
        // get student from studentId
        return ResponseEntity.ok("assignee Book to student");
    }


    @Override
    public LibraryDto searchByBookName(String bookName) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteBook(long bookId) throws JsonProcessingException {
        Library library = libraryRepository.findByBookId(bookId);
        if(library == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found");
        }
        libraryRepository.delete(library);
        LibraryDto libraryDto = new ObjectMapper().readValue(library.toString(), LibraryDto.class);
        return ResponseEntity.ok(libraryDto);
    }

    @Override
    public ResponseEntity<?> updateBook(long bookId, LibraryDto libraryDto) throws JsonProcessingException {
        Library library = libraryRepository.findByBookId(bookId);
        LibraryDto convertDto = new ObjectMapper().readValue(library.toString(),LibraryDto.class);
        if(library == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found");
        }
        if(libraryDto.getBooks() !=null){
            convertDto.setBooks(libraryDto.getBooks());
        }
        Library updatedLibrary = new ObjectMapper().readValue(convertDto.toString(),Library.class);
        libraryRepository.save(updatedLibrary);
        return ResponseEntity.ok(convertDto);
    }


}
