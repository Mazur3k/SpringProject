package org.edu.mazurek.edu.configuration;

import lombok.SneakyThrows;
import org.h2.tools.Server;
import org.springframework.context.annotation.Configuration;

/*@Configuration*/
public class H2WebConsole {

    @SneakyThrows
    public H2WebConsole() {
        Server server = Server.createWebServer().start();
    }
}
