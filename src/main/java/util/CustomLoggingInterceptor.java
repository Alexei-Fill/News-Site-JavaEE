package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class CustomLoggingInterceptor {

    private final Logger logger = LogManager.getRootLogger();

    @AroundInvoke
    public Object logging(InvocationContext context) throws Exception{
        logger.info(context.getMethod().getName() + " success");
        return context.proceed();
    }
}
