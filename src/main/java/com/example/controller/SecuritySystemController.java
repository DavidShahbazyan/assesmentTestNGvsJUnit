package com.example.controller;

import com.example.api.CameraSecurityService;
import com.example.api.PerimeterSecurityService;
import com.example.api.SecurityService;
import com.example.enums.SecurityStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author David.Shahbazyan
 * @since Mar 09, 2017
 */
public class SecuritySystemController {
    private final Map<SecurityService, SecurityStatus> securityServiceMap = new HashMap();

    public SecuritySystemController(CameraSecurityService cameraSecurityService, PerimeterSecurityService perimeterSecurityService) {
        this.securityServiceMap.put(cameraSecurityService, SecurityStatus.OK);
        this.securityServiceMap.put(perimeterSecurityService, SecurityStatus.OK);
    }

    public SecurityStatus checkSecurityStatus() {
        for (SecurityService service : securityServiceMap.keySet()) {
            securityServiceMap.put(service, service.check());
            if (!securityServiceMap.get(service).equals(SecurityStatus.OK)) {
                return securityServiceMap.get(service);
            }
        }
        return SecurityStatus.OK;
    }
}
