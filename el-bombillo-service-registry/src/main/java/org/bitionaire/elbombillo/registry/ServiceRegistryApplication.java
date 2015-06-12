package org.bitionaire.elbombillo.registry;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.bitionaire.elbombillo.registry.core.ServiceRegistry;
import org.bitionaire.elbombillo.registry.resources.ServiceResource;

public class ServiceRegistryApplication extends Application<ServiceRegistryConfiguration> {

    public static void main(final String... args) throws Exception {
        new ServiceRegistryApplication().run(args);
    }

    @Override
    public void run(final ServiceRegistryConfiguration configuration, final Environment environment) throws Exception {
        final ServiceRegistry serviceRegistry = new ServiceRegistry();
        environment.jersey().register(new ServiceResource(serviceRegistry));
    }
}
