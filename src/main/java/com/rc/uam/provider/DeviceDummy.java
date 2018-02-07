package com.rc.uam.provider;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DevicePlatform;

public class DeviceDummy implements Device {

	private boolean normal;
    private boolean mobile;
    private boolean tablet;
	
	@Override
	public DevicePlatform getDevicePlatform() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMobile() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNormal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTablet() {
		// TODO Auto-generated method stub
		return false;
	}

	 public void setNormal(boolean normal) {
        this.normal = normal;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public void setTablet(boolean tablet) {
        this.tablet = tablet;
    }
	
}
