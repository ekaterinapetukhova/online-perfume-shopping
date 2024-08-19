package com.perfumeOnlineStore.service;

import com.perfumeOnlineStore.entity.*;
import com.perfumeOnlineStore.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionRepository sessionRepository;
    private final UserService userService;

    @Value("${security.session.expiration-ms}")
    private Long expirationMs;

    @Value("${security.session.remembered-expiration-ms}")
    private Long rememberedExpirationMs;

    public Optional<Session> findSessionById(UUID id) {
        return sessionRepository.findById(id);
    }

    public Session createNewSession(
            User user,
            boolean isRemembered
    ) {
        Session session = Session.builder()
                .user(user)
                .startTime(Instant.now())
                .isActive(true)
                .isRemembered(isRemembered)
                .build();

        if (session.isRemembered()) session.setExpiredTime(session.getStartTime().plusMillis(rememberedExpirationMs));
        else session.setExpiredTime(session.getStartTime().plusMillis(expirationMs));

        return sessionRepository.save(session);
    }

    public Session updateSession(
            Session session,
            boolean isRemembered
    ) {
        session.setActive(true);
        session.setStartTime(Instant.now());
        session.setRemembered(isRemembered);

        if (session.isRemembered()) session.setExpiredTime(session.getStartTime().plusMillis(rememberedExpirationMs));
        else session.setExpiredTime(session.getStartTime().plusMillis(expirationMs));

        return sessionRepository.save(session);
    }

    public void disableSession(Session session) {
        session.setActive(false);
        sessionRepository.save(session);
    }

    public Session verifySessionExpiration(Session session) {
        if (session.getExpiredTime().compareTo(Instant.now()) < 0) {
            disableSession(session);
            throw new RuntimeException("Session with " + session.getId() + " was expired. Start new session.");
        }

        return session;
    }
}
