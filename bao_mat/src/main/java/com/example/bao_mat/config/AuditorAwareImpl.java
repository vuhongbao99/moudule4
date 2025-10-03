package com.example.bao_mat.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        String usename = SecurityContextHolder.getContext().getAuthentication().getName();
        return usename != null ? Optional.of(usename) : Optional.empty();
    }

}
