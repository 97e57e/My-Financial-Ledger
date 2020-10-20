package lee.garden.FinancialLedger.module;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import lee.garden.FinancialLedger.domain.account.CustomUser;
import lee.garden.FinancialLedger.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Component
public class JwtProvider {
    @Value("${jwt-secret}")
    private String secretKey;

    private final AccountService accountService;

    public String generateToken(CustomUser user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String getUsername(String token) {
        return Jwts.parser()
                .setSigningKey(this.secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String resolveToken(HttpServletRequest req) {
        return req.getHeader("mfl-token");
    }

    public UsernamePasswordAuthenticationToken getAuthentication(String token) {
        UserDetails userDetails = accountService.loadUserByUsername(this.getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
}

