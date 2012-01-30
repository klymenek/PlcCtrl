/*
 * Copyright 2012 ares.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.gabjee.plcctrl.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.inject.Singleton;
import de.gabjee.plcctrl.client.DatabaseService;
import de.gabjee.plcctrl.client.bean.BasicBean;
import de.gabjee.plcctrl.client.bean.CategoryBean;
import de.gabjee.plcctrl.client.bean.PlcBean;
import de.gabjee.plcctrl.client.bean.ProcessVarBean;
import de.gabjee.plcctrl.client.bean.ProcessVarBeanSet;
import de.gabjee.plcctrl.server.config.annotations.InjectLogger;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

/**
 *
 * @author ares
 */
@Singleton
public class MyBatisDatabaseService extends RemoteServiceServlet implements DatabaseService {

    @InjectLogger
    Logger logger;
    private static SqlSessionFactory sessionFac = null;
    private static Reader reader;
    private static String CONFIGURATION_FILE = "mybatis/sqlmap-config.xml";

    public MyBatisDatabaseService() {
    }        

    static {
        try {
            reader = Resources.getResourceAsReader(CONFIGURATION_FILE);
            sessionFac = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean savePlc(PlcBean plc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean updatePlc(PlcBean plc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean deletePlc(Long plc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PlcBean getPlc(Long id) {
        PlcBean plc = new PlcBean();
        SqlSession session = sessionFac.openSession();
        try {
            DatabaseService plcServiceObj = session.getMapper(DatabaseService.class);
            plc = plcServiceObj.getPlc(id);
        } finally {
            session.close();
        }
        return plc;
    }

    @Override
    public List<BasicBean> getPlcs() {
        List<BasicBean> plcs = new ArrayList<BasicBean>();
        SqlSession session = sessionFac.openSession();
        try {
            DatabaseService plcServiceObj = session.getMapper(DatabaseService.class);
            plcs = plcServiceObj.getPlcs();
        } finally {
            session.close();
        }
        return plcs;
    }

    @Override
    public Boolean saveCategory(CategoryBean category) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean updateCategory(CategoryBean category) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean deleteCategory(Long category) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CategoryBean getCategory(Long id) {
        CategoryBean category = new CategoryBean();
        SqlSession session = sessionFac.openSession();
        try {
            DatabaseService plcServiceObj = session.getMapper(DatabaseService.class);
            category = plcServiceObj.getCategory(id);
        } finally {
            session.close();
        }
        return category;
    }

    @Override
    public List<BasicBean> getCategorys() {
        List<BasicBean> categories = new ArrayList<BasicBean>();
        SqlSession session = sessionFac.openSession();
        try {
            DatabaseService plcServiceObj = session.getMapper(DatabaseService.class);
            categories = plcServiceObj.getCategorys();
        } finally {
            session.close();
        }
        return categories;
    }

    @Override
    public Boolean saveProcessVar(ProcessVarBean var) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean updateProcessVar(ProcessVarBean var) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean deleteProcessVar(Long var) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ProcessVarBean getProcessVar(Long id) {
        ProcessVarBean var = new ProcessVarBean();
        SqlSession session = sessionFac.openSession();
        try {
            DatabaseService plcServiceObj = session.getMapper(DatabaseService.class);
            var = plcServiceObj.getProcessVar(id);
        } finally {
            session.close();
        }
        return var;
    }

    @Override
    public ProcessVarBeanSet getProcessVarsByCategory(Long category) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ProcessVarBeanSet getProcessVarsByPlc(Long plc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ProcessVarBean> getProcessVarsAll() {
        List<ProcessVarBean> vars = new ArrayList<ProcessVarBean>();
        SqlSession session = sessionFac.openSession();
        try {
            DatabaseService plcServiceObj = session.getMapper(DatabaseService.class);
            vars = plcServiceObj.getProcessVarsAll();
        } finally {
            session.close();
        }
        return vars;
    }

    @Override
    public ProcessVarBeanSet getProcessVars() {
        List<ProcessVarBean> vars = getProcessVarsAll();
        ProcessVarBeanSet varset = new ProcessVarBeanSet();
        varset.setVars(vars);
        
        return varset;
    }
}