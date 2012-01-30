package de.gabjee.plcctrl.server.config;

import de.gabjee.plcctrl.server.ModbusPlcService;
import de.gabjee.plcctrl.server.MyBatisDatabaseService;

public class ServletModule extends com.google.inject.servlet.ServletModule {
	@Override
	protected void configureServlets() {
            serve("/plcctrl/plc").with(ModbusPlcService.class);
            serve("/plcctrl/database").with(MyBatisDatabaseService.class);
	}
}
