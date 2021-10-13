package mx.com.syntech.tpe.salesforce.servicedesk.recibir.adjunto.main;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * 
 * @author Jorge Zavala Navarro
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(mx.com.syntech.tpe.salesforce.servicedesk.recibir.adjunto.main.APIRestRecibirAdjuntoIF.class);
    }

}
