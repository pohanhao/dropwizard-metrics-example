package idv.hank.dropwizard.metrics.example.module;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import idv.hank.dropwizard.metrics.example.aop.DurationLog;
import idv.hank.dropwizard.metrics.example.aop.DurationLogInterceptor;
import idv.hank.dropwizard.metrics.example.service.DomainService;
import idv.hank.dropwizard.metrics.example.service.impl.DomainServiceImpl;

public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DomainService.class).to(DomainServiceImpl.class);

        bindInterceptor(Matchers.any(), Matchers.annotatedWith(DurationLog.class),
                new DurationLogInterceptor());
    }
}
