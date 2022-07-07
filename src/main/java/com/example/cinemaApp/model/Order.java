package com.example.cinemaApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float finalPrice;

    @ManyToOne()
    @JoinColumn(name = "client_id", referencedColumnName = "Id")
    private Client client;
    @ManyToOne()
    @JoinColumn(name = "ticket_id", referencedColumnName = "Id")
    private Ticket ticket;
}
