package com.lyg.bookstore.model.basic;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by weida on 2017/4/9.
 */
@Entity
@Table(name="L_BOOKSTORE_BASIC_USER")
public class User implements Serializable{

    @Id
    @Column(name = "ID")
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
//    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Integer id;

    public Integer getId() {
        return id;
    }
}
