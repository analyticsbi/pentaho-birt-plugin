/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smile.pentaho.birtplugin;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.pentaho.di.core.Const;
import org.pentaho.platform.util.logging.Logger;
/**
 *
 * @author gjergj sheldija
 */
public class BIRTContentGeneratorUtils {

    public static final String CONFIG_FILENAME = "../resources/birt.properties";

    public static final String BIRT_REPORTENGINE_DIR = "birt.reportGeneratedTempLocation";
    
    public static final String BIRT_VIEWERURL = "birt.viewerURL";
    

    public Properties getBIRTContentGeneratorConfig() throws Exception {
        String propertiesList = "";

        // Read in config properties
        File pluginFolderFile = new File(BIRTContentGeneratorUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile();

        // If set as a System property, just use that
        Properties props = new Properties(System.getProperties());
        
        // Try the config file
        File configFile = new File(pluginFolderFile, CONFIG_FILENAME);
        if (configFile.exists()) {
            try {
                props.load(new FileInputStream(configFile));
             } catch (Exception e) {
                Logger.error(getClass().getName(), e.getMessage());
            }
        }
        return props;
    }
       
}
