package com.octoperf;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
final class NoopRegistrationService implements UserRegistrationService {
  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public User register(final String username, final Optional<String> password) {
    final String token = UUID.randomUUID().toString();
    return User
      .builder()
      .id(token)
      .username(username)
      .password(password.orElse("12345")) // Unsecure
      .build();
  }
}
