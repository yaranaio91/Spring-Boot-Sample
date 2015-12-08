package sample.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogInterceptor {

	@Around("execution(* sample.controller.*.*(..)) || execution(* sample.dao.*.*(..))|| execution(* sample.service.*.*(..))")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		try {
			return pjp.proceed();
		} finally {
			long end = System.currentTimeMillis();
			String className = pjp.getSignature().getDeclaringType().getName();
			String methodName = pjp.getSignature().getName();
			System.out.println("Method [" + className + "#" + methodName
					+ "] Start [" + start + "] End [" + end + "] Time ["
					+ (end - start) + "]");
		}
	}
}
