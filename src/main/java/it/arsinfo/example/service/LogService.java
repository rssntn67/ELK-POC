/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.arsinfo.example.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.arsinfo.example.logger.debug.LogDebug;
import it.arsinfo.example.logger.error.LogError;
import it.arsinfo.example.logger.info.LogInfo;
import it.arsinfo.example.logger.trace.LogTrace;
import it.arsinfo.example.logger.warn.LogWarm;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 0.1-SNAPSHOT
 */
@Path("/log")
public class LogService {

	private static final Logger LOG = LogManager.getLogger(LogService.class);

    @GET
    @Path("/{name}")
    public String hello(@PathParam("name") String name) { 
        return "Hello " + name;
    }
    
    @GET
    @Path("/trace/{name}")
    public String trace(@PathParam("name") String name) { 
        LogTrace.log(name);
        return log("Log Trace " + name);
    }
    
    @GET
    @Path("/debug/{name}")
    public String debug(@PathParam("name") String name) { 
        LogDebug.log(name);
        return log("Log Debug " + name);
    }

    @GET
    @Path("/info/{name}")
    public String info(@PathParam("name") String name) { 
        LogInfo.log(name);
        return log("Log Info " + name);
    }
    
    @GET
    @Path("/warn/{name}")
    public String warn(@PathParam("name") String name) { 
        LogWarm.log(name);
        return log("Log Warn " + name);
    }

    @GET
    @Path("/error/{name}")
    public String error(@PathParam("name") String name) { 
        LogError.log(name);
        return log("Log Error " + name);
    }

    @GET
    @Path("/fatal/{name}")
    public String fatal(@PathParam("name") String name) { 
        LogError.log(name);
        return log("Log Fatal " + name);
    }

    private String log(String msg) {
        LOG.trace("Log demo Appending string: {}.", msg);       
        LOG.debug("Log demo Appending string: {}.", msg);       
        LOG.info("Log demo Appending string: {}.", msg);       
        LOG.warn("Log demo Appending string: {}.", msg);       
        LOG.error("Log demo Appending string: {}.", msg);       
        LOG.fatal("Log demo Appending string: {}.", msg);       
        return msg;
    	
    }

}
