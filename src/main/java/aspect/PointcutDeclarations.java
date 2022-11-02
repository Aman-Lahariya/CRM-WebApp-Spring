package aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutDeclarations {
	
	@Pointcut("execution(* controllers.*.*(..))")
	public void forControllerPackage() {}
	
	@Pointcut("execution(* dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* service.*.*(..))")
	public void forServicePackage() {}
	
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	public void forAppFlow() {}
	
}
