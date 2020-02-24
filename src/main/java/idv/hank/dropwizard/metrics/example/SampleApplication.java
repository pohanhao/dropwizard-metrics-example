package idv.hank.dropwizard.metrics.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import idv.hank.dropwizard.metrics.example.managed.MetricReporter;
import idv.hank.dropwizard.metrics.example.module.ServiceModule;
import idv.hank.dropwizard.metrics.example.resources.DomainResource;
import idv.hank.dropwizard.metrics.example.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class SampleApplication extends Application<SampleConfig> {

    @Override
    public void run(SampleConfig sampleConfig, Environment environment) {
        Injector injector = Guice.createInjector(new ServiceModule());

        environment.lifecycle().manage(injector.getInstance(MetricReporter.class));
        
        environment.jersey().register(injector.getInstance(HelloResource.class));
        environment.jersey().register(injector.getInstance(DomainResource.class));
    }

    public static void main(String[] args) throws Exception {
        new SampleApplication().run(args);
    }
}
