package aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	Logger logger = Logger.getLogger(getClass().getName());
	
	@Before("aspect.PointcutDeclarations.forAppFlow()")
	private void beforeLogginAdvice(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		logger.info("<--------- inside @Before calling method with signature : " + signature + "----------->");
		
		//displaying the args
		Object[] args = joinPoint.getArgs();
		for(Object arg : args) {
			logger.info("Argument: " + arg);
		}
	}
	
	@AfterReturning(pointcut="aspect.PointcutDeclarations.forAppFlow()", returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, Object result) {
	    // print out which method we are advising on
	    String method = theJoinPoint. getSignature().toShortString();
	    logger.info("\n=====>>> Executing @AfterReturning on method: " + method);
	    // print out the results of the method call
	    logger.info("\n=====>>> result is: " + result);
	}
	
}
