package de.gabjee.plcctrl.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.inject.Singleton;
import de.gabjee.plcctrl.client.PLCService;
import de.gabjee.plcctrl.client.bean.ProcessVarBean;
import de.gabjee.plcctrl.server.config.annotations.InjectLogger;
import java.net.InetAddress;
import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.ModbusRequest;
import net.wimpi.modbus.msg.ReadInputDiscretesRequest;
import net.wimpi.modbus.msg.ReadInputDiscretesResponse;
import net.wimpi.modbus.msg.WriteCoilRequest;
import net.wimpi.modbus.net.TCPMasterConnection;
import org.apache.log4j.Logger;

@Singleton
public class ModbusPlcService extends RemoteServiceServlet implements PLCService {

    @InjectLogger
    Logger logger;

    @Override
    public Integer writeCoil(Boolean state, ProcessVarBean var) {
        InetAddress addr = null;
        TCPMasterConnection con = null;
        WriteCoilRequest req = null;
        ModbusTCPTransaction trans = null;

        try {
            // 1. Set Parameters
            addr = InetAddress.getByName(var.getPlc().getIp());

            // 2. Open the connection
            con = new TCPMasterConnection(addr);
            con.setPort(var.getPlc().getPort());
            con.connect();

            logger.debug("Connected to " + addr.toString() + ":"
                    + con.getPort());

            // 3. Prepare the requests
            req = new WriteCoilRequest();
            req.setReference(var.getModbusaddr());
            req.setUnitID(0);

            // 4. Prepare the transactions
            trans = new ModbusTCPTransaction(con);
            trans.setRequest(req);
            trans.setReconnecting(false);

            // 5. Execute the transaction
            req.setCoil(state);
            trans.execute();

            logger.debug("Updated coil with state: " + state);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 6. Close the connection
            con.close();
        }

        return 1;
    }

    @Override
    public Boolean readCoil(ProcessVarBean var) {
        InetAddress addr;
        TCPMasterConnection con = null;
        ModbusRequest req;
        ModbusTCPTransaction trans;

        boolean in = false;
        try {
            // 1. Setup the parameters
            addr = InetAddress.getByName(var.getPlc().getIp());

            // 2. Open the connection
            con = new TCPMasterConnection(addr);
            con.setPort(var.getPlc().getPort());
            con.connect();
            logger.debug("Connected to " + addr.toString() + ":"
                    + con.getPort());

            // 3. Prepare the requests
            req = new ReadInputDiscretesRequest(var.getModbusaddr(), 1);

            req.setUnitID(0);

            // 4. Prepare the transactions
            trans = new ModbusTCPTransaction(con);
            trans.setRequest(req);
            trans.setReconnecting(false);

            // 6. Execute the transaction
            trans.execute();
            in = ((ReadInputDiscretesResponse) trans.getResponse()).getDiscreteStatus(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 7. Close the connection
            con.close();
        }

        return in;
    }
}
