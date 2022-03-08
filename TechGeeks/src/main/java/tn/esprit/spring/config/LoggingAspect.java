package tn.esprit.spring.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
	
	private static final Logger l = LogManager.getLogger(LoggingAspect.class);
	private long t1, t2;
	
	
	@Before("execution(* tn.esprit.spring.Service.*.*(..))")
	public void avant(JoinPoint thisJoinPoint){
		t1= System.currentTimeMillis();
		log.info("in the method "+thisJoinPoint.getSignature().getName());
	}
	
	@After("execution(* tn.esprit.spring.Service.*.*(..))")
	public void apres(JoinPoint thisJoinPoint){
		t2 = System.currentTimeMillis();
		log.info("Exception time of method " +thisJoinPoint.getSignature() + "is "+(t2-t1) + "ms");
		log.info("Out of the method (after) "+thisJoinPoint.getSignature().getName());
	}
	
	@AfterReturning("execution(* tn.esprit.spring.Service.*.*(..))")
	public void apres1(JoinPoint thisJoinPoint){
		log.info("Out of the method (After returning) " +thisJoinPoint.getSignature().getName());
	}
	
	
	public void profile(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.currentTimeMillis();
		pjp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		log.info("Method execution time: "+ elapsedTime);
	}

}
