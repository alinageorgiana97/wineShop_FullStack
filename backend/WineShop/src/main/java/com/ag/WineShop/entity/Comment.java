package com.ag.WineShop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(name = "approved")
    private Boolean approved = false;

    @ManyToOne()
    @JoinColumn(name = "wine_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Wine wine;

    @ManyToOne()
    @JoinColumn(name = "client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Client client;
}
