package com.perfumeOnlineStore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.*;

@Entity
@Table
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private Instant startTime;
    @Column(nullable = false)
    private Instant expiredTime;
    @Column(nullable = false)
    private boolean isActive = false;
    @Column(nullable = false)
    private boolean isRefreshed = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    @JsonBackReference
    private User user;

    @OneToMany(
            mappedBy = "session",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<RefreshToken> refreshTokens = new HashSet<>();

    public void addRefreshToken(RefreshToken refreshToken) {
        refreshTokens.add(refreshToken);
    }
}
