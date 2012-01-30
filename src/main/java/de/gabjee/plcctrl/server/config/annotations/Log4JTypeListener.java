package de.gabjee.plcctrl.server.config.annotations;

import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import java.lang.reflect.Field;
import org.apache.log4j.Logger;

public class Log4JTypeListener implements TypeListener {

    @Override
    public <T> void hear(TypeLiteral<T> typeLiteral, TypeEncounter<T> typeEncounter) {
        for (Field field : typeLiteral.getRawType().getDeclaredFields()) {
            if (field.getType() == Logger.class && field.isAnnotationPresent(InjectLogger.class)) {
                typeEncounter.register(new Log4JMembersInjector<T>(field));
            }
        }
    }
}
