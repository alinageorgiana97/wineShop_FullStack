package com.ag.WineShop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@Table(name = "review")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "review", nullable = false)
    private String review;

    @Column(name = "approved")
    private Boolean approved = false;

    @Column(name = "rating", nullable = false)
    @Max(value = 5, message = "Rating should not be greater than 5")
    private Integer rating;

    @ManyToOne()
    @JoinColumn(name = "wine_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Wine wine;

    @ManyToOne()
    @JoinColumn(name = "client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Client client;
}
