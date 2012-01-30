package de.gabjee.plcctrl.server.mybatis;

import de.gabjee.plcctrl.client.DatabaseService;
import de.gabjee.plcctrl.client.bean.PlcBean;
import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AppTester {

    private static SqlSessionFactory sessionFac = null;
    private static Reader reader;
    private static String CONFIGURATION_FILE = "mybatis/sqlmap-config.xml";

    static {
        try {
            reader = Resources.getResourceAsReader(CONFIGURATION_FILE);
            sessionFac = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        SqlSession session = sessionFac.openSession();
        try {
            DatabaseService plcServiceObj = session.getMapper(DatabaseService.class);
           
            System.out.println(plcServiceObj.getPlc(1l));
            
//            plcServiceObj.savePlc(plc);
//            session.commit();

        } finally {
            session.close();
        }
    }
}
