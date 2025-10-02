package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {

List<book> books=new ArrayList<>();
List<member> members=new ArrayList<>();

    public  boolean ReturnedBook(int id) {
        boolean returned=false;
        for (book b:books){
            if (b.id==id){
                b.status=bookStatus.AVAILABLE;
                returned=true;
            }
        }
        return returned;
    }

    public  void lendBookTo(int memberId,int bookId) {

boolean bookFound=false;
for (book b:books){
    if (b.id==bookId)
        bookFound=true;
}
if(!bookFound)
    throw new bookNotFoundException();

        boolean bookAvailable=true;
        for (book b:books){
            if (b.id==bookId && b.status.equals(bookStatus.BORROWED))
                throw new BookUnavailableException();
        }
        boolean memberFound=false;
        for (member m:members){
            if (m.id==memberId)
                memberFound=true;
        }
        if(!memberFound)
            throw new memberNotFoundException();
        for (member m:members){
            if (m.maxBorrowLimit<=m.borrowedBookIds.size()){
                throw new MaxBorrowingLimitException();
            }
            if(m.id==memberId){
                m.borrowedBookIds.add(bookId);
            }
        }
        for (book b:books){
            if(b.id==bookId){
                b.status=bookStatus.BORROWED;
            }
        }
    }

    public void addBook(int id, String title, String author, bookType type, bookStatus status) {
        books.add( new book(id, title, author, type, status));
    }

    public void deleteBook(int id) {
for (book b:books){
    if (b.id==id){
        books.remove(b);
    }
}
    }
    
    public void registerMember(int id, String name , int maxBorrowLimit, List<Integer> borrowedBookIds) {
  members.add(new member(id, name, maxBorrowLimit, borrowedBookIds));
    }

    public void unregisterMember(int id) {
        for (member m:members){
            if (m.id==id){
                members.remove(m);
            }
        }
    }

    public boolean containsBook(int id) {
        boolean contain=false;
 for (book b:books){
     if (b.id==id){
         contain=true;
     }
 }
        return contain;
    }

    public boolean containsMember(int id) {
        boolean contain=false;
        for (member m:members){
            if (m.id==id){
                contain=true;
            }
        }
        return contain;
    }

    public int memberHavingBook(int bookId) {
        for (member m:members){
            if(m.borrowedBookIds.contains(bookId))
                return  m.id;
        }
        return -1;
    }
}
