package com.example;

import com.example.api.CameraSecurityService;
import com.example.enums.SecurityStatus;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author David.Shahbazyan
 * @since May 03, 2017
 */
public class MockitoStaticMocTest {
    @Test
    public void test1() {
        //  create mock
        CameraSecurityService service = mock(CameraSecurityService.class);

        // define return value for method getUniqueId()
        when(service.check()).thenReturn(SecurityStatus.OK);

        // use mock in test....
        assertEquals(service.check(), SecurityStatus.OK);
    }
}
