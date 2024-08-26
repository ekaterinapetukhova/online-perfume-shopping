package com.perfumeOnlineStore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String recipient;
    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private String controller;
    @Column(nullable = false)
    private String action;
    @Column(nullable = false)
    private boolean isSentSuccessfully = false;
}
