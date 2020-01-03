package work.lince.commons.authentication;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Value("${lince.userName:lince.user.name}")
    protected String userName;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String user = extractUserName(request);
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, "none");
        SecurityContextHolder.getContext().setAuthentication(auth);
        filterChain.doFilter(request, response);
    }

    protected String extractUserName(HttpServletRequest request){
        log.trace("extractUserName {} {}", userName, request.getParameter(userName));
        String user = request.getParameter(userName);
        if (!StringUtils.isEmpty(user)){
            log.trace("extractUserName from parameter");
            return user;
        }
        user = request.getHeader(userName);
        if (!StringUtils.isEmpty(user)){
            log.trace("extractUserName from header");
            return user;
        }
        return  "anonymous";
    }

}