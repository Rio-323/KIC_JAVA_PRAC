package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterEx02 implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("FilterEx01 init()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 전처리 구간
		System.out.println("FilterEx02 전처리");
		chain.doFilter(request, response);
		
		// 후처리 구간
		System.out.println("FilterEx02 후처리");
	}

}
