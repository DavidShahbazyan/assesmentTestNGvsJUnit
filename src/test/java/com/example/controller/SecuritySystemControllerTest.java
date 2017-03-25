package com.example.controller;

import com.example.api.CameraSecurityService;
import com.example.api.PerimeterSecurityService;

import com.example.enums.SecurityStatus;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * @author David.Shahbazyan
 * @since Mar 21, 2017
 */
public class SecuritySystemControllerTest {
    private CameraSecurityService cameraSecurityServiceMoc;
    private PerimeterSecurityService perimeterSecurityServiceMoc;
    private SecuritySystemController controller;

    @BeforeClass
    public void init() {
        cameraSecurityServiceMoc = mock(CameraSecurityService.class);
        perimeterSecurityServiceMoc = mock(PerimeterSecurityService.class);
        controller = new SecuritySystemController(cameraSecurityServiceMoc, perimeterSecurityServiceMoc);
    }

    @Test
    public void testCheckSecurityStatus_OK() throws Exception {
        when(cameraSecurityServiceMoc.check()).thenReturn(SecurityStatus.OK);
        when(perimeterSecurityServiceMoc.check()).thenReturn(SecurityStatus.OK);
        assertEquals(SecurityStatus.OK, controller.checkSecurityStatus());
    }

    @Test
    public void testCheckSecurityStatus_UNAUTHORIZED_PENETRATION() throws Exception {
        when(cameraSecurityServiceMoc.check()).thenReturn(SecurityStatus.OK);
        when(perimeterSecurityServiceMoc.check()).thenReturn(SecurityStatus.UNAUTHORIZED_PENETRATION);
        assertEquals(SecurityStatus.UNAUTHORIZED_PENETRATION, controller.checkSecurityStatus());
    }

    @Test
    public void testCheckSecurityStatus_UNKNOWN_CAR_or_UNKNOWN_PERSON() throws Exception {
        when(cameraSecurityServiceMoc.check()).thenReturn(SecurityStatus.UNKNOWN_CAR);
        when(perimeterSecurityServiceMoc.check()).thenReturn(SecurityStatus.OK);
        assertEquals(SecurityStatus.UNKNOWN_CAR, controller.checkSecurityStatus());

        when(cameraSecurityServiceMoc.check()).thenReturn(SecurityStatus.UNKNOWN_PERSON);
        when(perimeterSecurityServiceMoc.check()).thenReturn(SecurityStatus.OK);
        assertEquals(SecurityStatus.UNKNOWN_PERSON, controller.checkSecurityStatus());
    }

    @AfterClass
    public void finalize() {
        cameraSecurityServiceMoc = null;
        perimeterSecurityServiceMoc = null;
        controller = null;
    }

}