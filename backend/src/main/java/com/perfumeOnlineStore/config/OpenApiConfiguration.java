package com.perfumeOnlineStore.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.*;

import java.util.List;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI defineOpenAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:8088");
        server.setDescription("Development");

        Contact contact = new Contact();
        contact.setName("Ekaterina Petukhova");
        contact.setEmail("katepthv12@gmail.com");

        Info info = new Info();
        info.setTitle("Online perfume store API");
        info.setVersion("1.0");
        info.setContact(contact);

        return new OpenAPI().info(info).servers(List.of(server));
    }
}
