package com.School_ERP.service.serviceImp;
import com.School_ERP.dto.LibraryDto;
import com.School_ERP.dto.StudentDto;
import com.School_ERP.entity.Library;
import com.School_ERP.entity.Student;
import com.School_ERP.repository.LibraryRepository;
import com.School_ERP.repository.StudentRepo;
import com.School_ERP.service.LibraryService;
import org.modelmapper.ModelMapper;
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

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<LibraryDto> findAllBook() {
        List<Library> listLibrary = libraryRepository.findAll();
        List<LibraryDto> list = listLibrary.stream().map(library -> {
            LibraryDto dto = null;
                dto = this.modelMapper.map(library, LibraryDto.class);
            return dto;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public LibraryDto findByIdLibrary(long bookId)  {
        Library library = libraryRepository.findByBookId(bookId);
        LibraryDto lDto = this.modelMapper.map(library, LibraryDto.class);;
        return lDto;
    }


    @Override
    public ResponseEntity<?> addBook(LibraryDto libraryDto)  {
        if(libraryDto.getBooks() != null){
            Library library =this.modelMapper.map(libraryDto, Library.class);
            library.setStatus("available");
            libraryRepository.save(library);
            return ResponseEntity.ok(library);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
    }

    @Override
    public ResponseEntity<?> assingeeBook(int admNo, Long bookId)  {
        Library library = libraryRepository.findByBookId(bookId);
        if(admNo==0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
        }
        library.setStatus("assigned");
        library.setAdmNo(admNo);
        libraryRepository.save(library);
        return ResponseEntity.ok("assignee Book to student");
    }

    @Override
    public ResponseEntity<?> getStudentOfAssignedBook(long bookId){
        Library library = libraryRepository.findByBookId(bookId);
        if(library != null){
            if(library.getStatus().equals("assigned")) {
                Student stu = studentRepo.findByAdmNo(library.getAdmNo());
                if(stu == null){
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student Not found");
                }
                StudentDto studentDto = modelMapper.map(stu,StudentDto.class);
                return ResponseEntity.ok(studentDto);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This book is not Assigned");
        }
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book not found");
    }


    @Override
    public List<LibraryDto> searchByBookName(String books) {
   List<Library> librarylist = libraryRepository.findByBooks(books);

       List<LibraryDto> list = librarylist.stream().map(library -> {
           LibraryDto dto = null;
           dto = this.modelMapper.map(library, LibraryDto.class);
           return dto;
       }).collect(Collectors.toList());
       return list;
    }

    @Override
    public ResponseEntity<?> deleteBook(long bookId)  {
        Library library = libraryRepository.findByBookId(bookId);
        if(library == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found");
        }
        libraryRepository.delete(library);
        LibraryDto libraryDto = this.modelMapper.map(library, LibraryDto.class);
        return ResponseEntity.ok(libraryDto);
    }

    @Override
    public ResponseEntity<?> updateBook(long bookId, LibraryDto libraryDto)  {
        Library library = libraryRepository.findByBookId(bookId);
        LibraryDto convertDto = this.modelMapper.map(library, LibraryDto.class);;
        if(library == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found");
        }
        if(libraryDto.getBooks() !=null){
            convertDto.setBooks(libraryDto.getBooks());
        }
        Library updatedLibrary = this.modelMapper.map(convertDto,Library.class);
        libraryRepository.save(updatedLibrary);
        return ResponseEntity.ok(convertDto);
    }

    @Override
    public ResponseEntity<?> returnBook(long bookId) {
        Library library = libraryRepository.findByBookId(bookId);
        library.setStatus("available");
        library.setAdmNo(0);
        libraryRepository.save(library);
        return ResponseEntity.ok("Book return successfully");
    }



}
