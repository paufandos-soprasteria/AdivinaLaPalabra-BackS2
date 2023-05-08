package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.User;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.UserDetailsImpl;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.UserRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class UserDetailsServiceImplTest {

    @InjectMocks
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Mock
    UserRepository userRepository;

    @Mock
    UserDetailsImpl userDetailsImpl;

    @Test
    public void testLoadUserByUsernameMustReturnUserLoaded() {
        final String USERNAME_TO_BE_LOADED = "paufandos";
        final User USER_LOADED = new User(USERNAME_TO_BE_LOADED, "anypassword");
        final UserDetails EXPECTED_USER = UserDetailsImpl.build(USER_LOADED);

        when(userRepository.findByName(USERNAME_TO_BE_LOADED)).thenReturn(Optional.of(USER_LOADED));
        UserDetails user = userDetailsServiceImpl.loadUserByUsername(USERNAME_TO_BE_LOADED);

        assertThat(user).usingRecursiveComparison().isEqualTo(EXPECTED_USER);
    }

    @Test
    public void testLoadUserByUsernameWithNonExistingUserMustThrowUsernameNotFoundException() {
        assertThatThrownBy(() -> userDetailsServiceImpl.loadUserByUsername(null))
                .isInstanceOf(UsernameNotFoundException.class);
    }
}