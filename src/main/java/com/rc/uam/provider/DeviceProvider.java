package com.rc.uam.provider;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Component;

/**
 * @author Rachit Bhasin
 *
 */
@Component
public class DeviceProvider {

	@Autowired
	DeviceDummy dDevice;
	
    public Device getCurrentDevice(HttpServletRequest request) {
    	Device device = DeviceUtils.getCurrentDevice(request);
    	if(device == null) {
    		device = dDevice;
    	}
        return device;
    }
}
