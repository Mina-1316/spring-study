package gdsc.edu.springstudy.web;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.mock.env.MockEnvironment;

import static org.assertj.core.api.Assertions.assertThat;

public class TestProfileController {

    @Test @DisplayName("[API] GET '/profile' real_profile 조회")
    public void query_real_profile() {
        // Given
        String expectedProfile = "real";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("real1");
        env.addActiveProfile("real2");

        ProfileController controller = new ProfileController(env);

        // When
        String profile = controller.profile();

        // Then
        assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test @DisplayName("[API] GET '/profile' real_profile이 없을 때 첫 프로필 조회")
    public void query_first_if_real_profile_is_not_exist() {
        // Given
        String expectedProfile = "oauth";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);

        // When
        String profile = controller.profile();

        // Then
        assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test @DisplayName("[API] GET '/profile' active_profile 이 없을 때 default 조회")
    public void query_default_if_active_profile_is_not_exist() {
        // Given
        String expectedProfile = "default";
        MockEnvironment env = new MockEnvironment();
        ProfileController controller = new ProfileController(env);

        // When
        String profile = controller.profile();

        // Then
        assertThat(profile).isEqualTo(expectedProfile);
    }

}
