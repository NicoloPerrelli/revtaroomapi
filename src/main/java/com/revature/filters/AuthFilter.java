package com.revature.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.revature.dtos.Principal;
import com.revature.security.JwtConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

@Component
@WebFilter("/*")
public class AuthFilter extends OncePerRequestFilter {

	private static Logger log = LogManager.getLogger(AuthFilter.class);
	
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {


    	//log.info("Request intercepted by TokenAuthFilter.doFilter");
    		extractPrincipal(req);
    		attachCorsResponseHeaders(resp);
    		chain.doFilter(req, resp);
    		return;
    	}
    	
    	/**
    	 * Obtains the token from the Authorization header of the request object,
    	 * validates and parses it to extract the payload (a Principal object) - 
    	 * which is attached to the request object as an attribute called "principal".
    	 * 
    	 * If no token is present, no action is taken. The request object is not manipulated
    	 * in any way. 
    	 * 
    	 * @param req
    	 * @throws IOException
    	 * @throws ServletException
    	 */
    	public void extractPrincipal(HttpServletRequest req) throws IOException, ServletException {
    		//log.info("Attempting to extract principal object from JWT...");
    		String header = req.getHeader(JwtConfig.HEADER);
    		
    		if(header == null || !header.startsWith(JwtConfig.PREFIX)) {
    			//log.info("No token found with required prefix");
    			return;
    		}
    		
    		String token = header.replaceAll(JwtConfig.PREFIX, "");
    		
    		try {
    			
    			Claims claims = Jwts.parser()
    					.setSigningKey(JwtConfig.SECRET.getBytes())
    					.parseClaimsJws(token)
    					.getBody();
    			
    			Principal principal = new Principal();
    			principal.setId(Integer.parseInt(claims.getId()));
    			principal.setEmail(claims.getSubject());
    			principal.setRole(claims.get("role", String.class));
    			
    			req.setAttribute("principal", principal);
    			
    		} catch (ExpiredJwtException eje) {
    			//log.info("JWT expired. Reauthentication required.");
    		} catch (Exception e) {
    			//log.error("Error parsing JWT");
    			e.printStackTrace();
    		}
    	}
    	
    	/**
    	 * Attaches the required appropriate response headers to satisfy 
    	 * the CORS pre-flight request requirements. 
    	 * 
    	 * @param resp
    	 * @throws IOException
    	 * @throws ServletException
    	 */
    	public void attachCorsResponseHeaders(HttpServletResponse resp) throws IOException, ServletException {
    		//log.info("Attaching CORS headers to HTTP response");
    		resp.setHeader("Access-Control-Allow-Origin", "*");
    		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, PATCH, DELETE");
    		resp.setHeader("Access-Control-Allow-Headers", "Content-type, Authorization");
    		resp.setHeader("Access-Control-Expose-Headers", "Authorization");
    	}
  }
