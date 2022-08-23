package com.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "sub_category")
public class Sub_category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long sub_id;

    private String sub_cate_code;

    private String sub_cate_name;

    @ManyToOne
    @JoinColumn(name = "cate_id",referencedColumnName = "id")
    private Category category;

}