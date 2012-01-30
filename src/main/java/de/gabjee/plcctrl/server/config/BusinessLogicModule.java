package de.gabjee.plcctrl.server.config;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import de.gabjee.plcctrl.server.config.annotations.Log4JTypeListener;

public class BusinessLogicModule extends AbstractModule {

    @Override
    protected void configure() {
        bindListener(Matchers.any(), new Log4JTypeListener());
    }
}
