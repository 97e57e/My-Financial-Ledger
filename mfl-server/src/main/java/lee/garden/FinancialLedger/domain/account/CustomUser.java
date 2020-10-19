package lee.garden.FinancialLedger.domain.account;

import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Builder
@Table(name = "user")
@Entity
public class CustomUser implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String nickName;

    private LocalDateTime createdAt;

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public Long getId() { return this.id; }

    public String getNickname() {
        return this.nickName;
    }


    /**
     * 생성 메서드
     * */
    public static CustomUser createUser(String username, String password, String nickName) {
        return CustomUser.builder()
                .username(username)
                .password(password)
                .nickName(nickName)
                .createdAt(LocalDateTime.now())
                .build();
    }

    /**
     * not used
     * */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
