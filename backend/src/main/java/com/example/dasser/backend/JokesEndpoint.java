package com.example.dasser.backend;


import com.example.dasser.backend.data.Jokes;
import com.example.dasser.backend.model.JokesBean;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "jokes.backend.dasser.example.com",
                ownerName = "jokes.backend.dasser.example.com",
                packagePath = ""
        )
)
public class JokesEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "tellJoke")
    public JokesBean tellJoke() {

        JokesBean response = new JokesBean();
        response.setData(Jokes.getJoke());
        return response;
    }
}
