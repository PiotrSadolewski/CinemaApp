package com.example.cinemaApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

enum TicketType{
    ADULT,
    STUDENT,
    CHILD
}

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate buyDate = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;
    private float ticketPrice;

    @OneToMany(mappedBy = "ticket")
    private List<Order> orders = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_Show_id", referencedColumnName = "Id")
    private FilmShow filmShow;
}
