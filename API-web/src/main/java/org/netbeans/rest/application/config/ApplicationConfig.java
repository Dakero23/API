/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Cometware
 */
@javax.ws.rs.ApplicationPath("v1")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.com.API.aplicacion.class);
        resources.add(co.com.API.empresaApp.class);
        resources.add(co.com.API.informacionBasicaApp.class);
        resources.add(co.com.API.serviciosApp.class);
        resources.add(co.com.API.tarjetaApp.class);
        resources.add(co.com.API.tipoDocumentoApp.class);
        resources.add(co.com.API.tipoUsuarioApp.class);
        resources.add(co.com.API.tipotarjeta.class);
        resources.add(co.com.API.usuarioApp.class);
    }

}
