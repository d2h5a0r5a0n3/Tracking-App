package com.tracking.app.auth.core.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Custom entry point for authentication failures.
 *
 * <p>If a user tries to access a protected API without being logged in,
 * this class sends back a JSON response with HTTP 401 (Unauthorized).</p>
 *
 * <p>Example response:
 * <pre>
 * {
 *   "status": 401,
 *   "error": "Unauthorized",
 *   "message": "Bad credentials",
 *   "path": "/api/secure"
 * }
 * </pre>
 * </p>
 *
 * Author: Dharaneshwar
 */
@Component
@RequiredArgsConstructor
public class AuthEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Called when authentication fails.
     *
     * @param request  incoming HTTP request
     * @param response HTTP response we send back
     * @param authException the authentication error
     */
    @Override
    @SneakyThrows
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException
    ) {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
        body.put("error", "Unauthorized");
        body.put("message", authException.getMessage());
        body.put("path", request.getRequestURI());

        response.getWriter().write(mapper.writeValueAsString(body));
    }
}
