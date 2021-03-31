package com.ag.WineShop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bought_history")
public class BoughtHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "bought_quantity", nullable = false)
    private Integer boughtQuantity;

    @ManyToOne()
    @JoinColumn(name = "wine_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Wine wine;

    @ManyToOne()
    @JoinColumn(name = "client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;
}
