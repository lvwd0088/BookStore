package com.lyg.bookstore.model.basic;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "L_BOOKSTORE_BOOK_BOOKLABEL")
public class BookLabel {

    private Long bookId;

    private Long labelId;

}
