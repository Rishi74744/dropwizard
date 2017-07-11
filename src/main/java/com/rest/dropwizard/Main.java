package com.rest.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

public class Main extends Application<Configuration> {

	@Override
	public void run(Configuration c, Environment e) throws Exception {
		e.jersey().register(new RestController());
	}

	public static void main(String[] args) throws Exception {
		new Main().run(args);

	}

}
