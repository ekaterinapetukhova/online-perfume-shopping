package com.perfumeOnlineStore.service;

import com.perfumeOnlineStore.entity.RefreshToken;
import com.perfumeOnlineStore.entity.Session;
import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionRepository sessionRepository;

    @Value("${security.session.expiration-ms}")
    private Long expirationMs;

    @Value("${security.session.remembered-expiration-ms}")
    private Long rememberedExpirationMs;

    public Session createNewSession(
            User user,
            RefreshToken token,
            boolean isRemembered
    ) {
        Session session = Session.builder()
                .user(user)
                .startTime(Instant.now())
                .isActive(true)
                .build();

        if (isRemembered) session.setExpiredTime(session.getStartTime().plusMillis(rememberedExpirationMs));
        else session.setExpiredTime(Instant.now().plusMillis(expirationMs));

        session.addRefreshToken(token);

        return sessionRepository.save(session);
    }
}
