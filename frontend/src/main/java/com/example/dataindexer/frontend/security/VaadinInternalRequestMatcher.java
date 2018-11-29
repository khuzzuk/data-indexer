package com.example.dataindexer.frontend.security;

import com.vaadin.flow.server.ServletHelper;
import com.vaadin.flow.shared.ApplicationConstants;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

public class VaadinInternalRequestMatcher implements RequestMatcher {
    private static final Set<String> ALLOWED_TYPES = EnumSet.allOf(ServletHelper.RequestType.class)
            .stream()
            .map(ServletHelper.RequestType::getIdentifier)
            .collect(Collectors.toSet());
    @Override
    public boolean matches(HttpServletRequest request) {
        return ALLOWED_TYPES.contains(request.getParameter(ApplicationConstants.REQUEST_TYPE_PARAMETER));
    }
}
