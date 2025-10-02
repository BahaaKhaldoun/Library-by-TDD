package org.example;

import javax.print.DocFlavor;
import java.util.List;

public class member {
    int id;
    String name;
    int maxBorrowLimit;
    List<Integer> borrowedBookIds;

    public member(int id, String name , int maxBorrowLimit, List<Integer> borrowedBookIds) {
        this.id = id;
        this.borrowedBookIds = borrowedBookIds;
        this.maxBorrowLimit = maxBorrowLimit;
        this.name = name;
    }
}
