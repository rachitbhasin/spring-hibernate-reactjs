package com.rc.uam.provider;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Component;

/**
 * @author Rachit Bhasin
 *
 */
@Component
public class DeviceProvider {
	
    public Device getCurrentDevice(HttpServletRequest request) {
    	Device device = DeviceUtils.getCurrentDevice(request);
    	DeviceDummy dummy = null;
    	if(device == null) {
    		dummy = new DeviceDummy();
			dummy.setNormal(true);
			device = dummy;
    	}
        return device;
    }
}
