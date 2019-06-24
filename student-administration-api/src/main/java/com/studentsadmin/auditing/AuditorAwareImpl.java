package com.studentsadmin.auditing;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        //currently keeping this as single user application. Spring security can be implemented to make this user specific.
        return Optional.of("AdminUser");
    }
}
