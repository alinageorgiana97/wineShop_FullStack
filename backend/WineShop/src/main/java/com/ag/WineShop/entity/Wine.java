package com.ag.WineShop.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "wine")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private WineCategory category;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @OneToMany(mappedBy = "wine")
    private List<Comment> comments;

    @OneToMany(mappedBy = "wine")
    private List<Review> reviews;


}
