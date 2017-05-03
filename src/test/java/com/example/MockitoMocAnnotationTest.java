package com.example;

import com.example.api.CameraSecurityService;
import com.example.enums.SecurityStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Mocking example using @Mock annotation.
 * This should be runned using MockitoJUnitRunner or by specifying a JUnit rule
 * to trigger the mocks creation by @Mock annotations.
 * @author David.Shahbazyan
 * @since May 03, 2017
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoMocAnnotationTest {
    @Mock private CameraSecurityService service;

//    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void test1() {
        // define return value for method getUniqueId()
        when(service.check()).thenReturn(SecurityStatus.OK);

        // use mock in test....
        assertEquals(service.check(), SecurityStatus.OK);
    }
}
