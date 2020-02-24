package idv.hank.dropwizard.metrics.example.aop;

import com.codahale.metrics.Histogram;
import com.codahale.metrics.MetricRegistry;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codahale.metrics.MetricRegistry.name;
import static org.eclipse.jetty.http.HttpParser.RequestHandler;

public class DurationLogInterceptor implements MethodInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(DurationLogInterceptor.class);
    private static final Histogram responseTimes = new MetricRegistry().histogram(name(RequestHandler.class, "response-times"));

    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            logger.info("interceptor class {}", invocation.getClass());
        } finally {
            return invocation.proceed();
        }
    }
}