//package com.revature.security;
//
//import java.util.Arrays;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.aspectj.apache.bcel.classfile.Method;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//
//import com.revature.dtos.Principal;
//
//@Aspect
//@Component
//public class SecurityIntercepter {
//
//	@Pointcut("@annotation(com.revature.security.Secured)")
//	public void securedControllerEndpoints() {
//		
//	}
//	
//	@Around(value="secureControllerEndpoints()")
//	public Object secureEndpoint(ProceedingJoinPoint pjp) throws Throwable {
//		jMethod method = ((MethodSignature)) pjp.getSignature()).getMethod();
//		Secured controllersAnnotation = method.getAnnotations(Secured.class);
//		
//		List<String> allowedRoles = Arrays.asList(controllerAnnotation.allowed);
//		HttpServletRequest req = (HttpServletRequest) pjp.getArgs()[0];
//		Principal principal = (Principal) req.getAttribute("principal");
//		
//		if(principal == null) {
//			throw new SecurityException("An unauthorized request allowed");
//		}
//			
//		if(!allowedRoles.contains(principal.getRole())) {
//			throw new SecurityException("An forbidden request made");
//		}
//		
//		return pjp.proceed();
//	}
//}
