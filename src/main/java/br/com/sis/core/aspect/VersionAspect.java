package br.com.sis.core.aspect;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import br.com.sis.core.annotation.VersionHandling;



@Component
@Aspect
public class VersionAspect {
	 private Logger logger = Logger.getLogger(getClass().getName());

	@Around("(@annotation(br.com.sis.core.annotation.VersionHandling) && args(.., version))")	
    public Object validaVersion(ProceedingJoinPoint joinPoint,Integer version) throws Throwable {
		logger.info("Eu funciono com o "+version);
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	    Method method = signature.getMethod();

	    VersionHandling versionHandling = method.getAnnotation(VersionHandling.class);
	    
	    logger.info("consigo pegar parametros de anotacoes"+versionHandling.description());
		
		return joinPoint.proceed();
	}	

}
