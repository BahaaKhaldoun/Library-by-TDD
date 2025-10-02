package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class test {
    @Test
    public void addingOneBookToTheLibrary(){
    Library library=new Library();
    library.addBook(1,"engineering","bahaa",bookType.SCINCE, bookStatus.AVAILABLE);
    Assertions.assertTrue(library.containsBook(1));
}
    @Test
    public void deletingOneBookFromTheLibrary(){
    Library library=new Library();
    library.deleteBook(1);
    Assertions.assertFalse(library.containsBook(1));
    }
    @Test
    public void registerMemberToTheMembersListInTheLibrary(){
    Library library=new Library();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
    library.registerMember(1,"bahaa",3,list);
    Assertions.assertTrue(library.containsMember(1));
    }
    @Test
    public void unregisterMemberToTheMembersListInTheLibrary(){
        Library library=new Library();
        library.unregisterMember(1);
        Assertions.assertFalse(library.containsMember(1));
    }
    @Test
    public void lendABookThatIsAvailableInTheLibraryToMember(){
        Library library=new Library();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        int memberId=1;
        library.registerMember(memberId,"bahaa",3,list);
        int bookId=2;
        library.addBook(bookId,"engineering","bahaa",bookType.SCINCE, bookStatus.AVAILABLE);


        library.lendBookTo(memberId,bookId);
        Assertions.assertEquals(memberId,library.memberHavingBook(bookId));
    }
    @Test
    public void lendABookThatIsNotFoundInTheLibraryToMember(){
    Library library=new Library();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        int memberId=1;
       int bookId=2;
    Assertions.assertThrows(bookNotFoundException.class ,()->library.lendBookTo(memberId,bookId));
    }
    @Test
    public void lendABookThatIsFoundInTheLibraryToMemberThatIsNotFound(){
        Library library=new Library();
        int memberId=1;
        int bookId=2;
        library.addBook(bookId,"engineering","bahaa",bookType.SCINCE, bookStatus.AVAILABLE);
        Assertions.assertThrows(memberNotFoundException.class ,()->library.lendBookTo(memberId,bookId));
    }
    @Test
    public void lendABookThatIsFoundInTheLibraryToMemberThatExceededTheLimitOfBorrowedBooks(){
        Library library=new Library();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        int memberId=1;
        library.registerMember(memberId,"bahaa",2,list);
        int bookId=3;
        library.addBook(bookId,"engineering","bahaa",bookType.SCINCE, bookStatus.AVAILABLE);
        Assertions.assertThrows(MaxBorrowingLimitException.class ,()->library.lendBookTo(memberId,bookId));
    }
    @Test
    public void lendABookThatIsNotAvailableInTheLibraryToMember(){
        Library library=new Library();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        int memberId=1;
        library.registerMember(memberId,"bahaa",3,list);
        int bookId=2;
        library.addBook(bookId,"engineering","bahaa",bookType.SCINCE, bookStatus.BORROWED);

        Assertions.assertThrows(BookUnavailableException.class,()-> library.lendBookTo(memberId,bookId));
    }
    @Test
    public void returnBookThatIsBorrowed(){
        Library library=new Library();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(3);
        int memberId=1;
        library.registerMember(memberId,"bahaa",3,list);
        int bookId=2;
        library.addBook(bookId,"engineering","bahaa",bookType.SCINCE, bookStatus.AVAILABLE);
        library.lendBookTo(memberId,bookId);
        Assertions.assertTrue(library.ReturnedBook(bookId));
    }
}
