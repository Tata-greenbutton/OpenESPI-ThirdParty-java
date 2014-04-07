package org.energyos.espi.thirdparty.web.filter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import javax.servlet.FilterChain;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class CORSFilterTests {
    @Test
    @Ignore
    public void testDoFilterInternal() throws Exception {
        CORSFilter corsFilter = new CORSFilter();
        FilterChain filterChain = mock(FilterChain.class);
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        corsFilter.doFilter(request, response, filterChain);

        verify(filterChain).doFilter(request, response);
    }
}
