package jaxrs;

import service.HelloWorld;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/")
@Singleton
public class HelloResource {
    @GET
    @Path("/hello.json")
    @Produces(MediaType.APPLICATION_JSON)
    public Data getJsonMessage() {
        return new Data(helloWord.say());
    }

    public static class Data {
        @JsonCreator
        public Data(@JsonProperty("hoge") String data) {
            this.text = data;
        }

        @JsonProperty("hoge")
        public String getData() {
            return text;
        }

        private final String text;
    }

    @Inject HelloWorld helloWord;
}
