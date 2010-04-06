package org.opennms.features.poller.remote.gwt.client;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;


public class BoundsBuilderTest {
    
    @Test
    public void testAddNoPoints() {
        BoundsBuilder bldr = new BoundsBuilder();
        
        
        assertEquals(new GWTBounds(-90, -180, 90, 180), bldr.getBounds());
    }
    @Test
    public void testAddOnePoint() {
        BoundsBuilder bldr = new BoundsBuilder();
        
        GWTLatLng origin = new GWTLatLng(0.0, 0.0);
        bldr.extend(origin);
        
        assertEquals(new GWTBounds(origin, origin), bldr.getBounds());
    }
    
    @Test
    public void testAddTwoCornerPoints() {
        BoundsBuilder bldr = new BoundsBuilder();
        
        bldr.extend(0.0, 0.0);
        bldr.extend(1.0, 1.0);
        
        assertEquals(new GWTBounds(0.0, 0.0, 1.0, 1.0), bldr.getBounds());
        
    }

    @Test
    public void testAddOppositeCornerPoints() {
        BoundsBuilder bldr = new BoundsBuilder();
        
        bldr.extend(0.0, 1.0);
        bldr.extend(1.0, 0.0);
        
        assertEquals(new GWTBounds(0.0, 0.0, 1.0, 1.0), bldr.getBounds());
        
    }

    @Test
    public void testAddInteriorPoint() {
        BoundsBuilder bldr = new BoundsBuilder();
        
        bldr.extend(0.0, 0.0);
        bldr.extend(2.0, 2.0);
        
        assertEquals(new GWTBounds(0.0, 0.0, 2.0, 2.0), bldr.getBounds());

        bldr.extend(1.0, 1.0);
        
        // nothing happens because its in the interior
        assertEquals(new GWTBounds(0.0, 0.0, 2.0, 2.0), bldr.getBounds());
        
    }

    @Test
    public void testAddManyPoints() {
        BoundsBuilder bldr = new BoundsBuilder();
        
        
        for(int i = 0; i <= 10; i++) {
            bldr.extend(0.0 + i, 0.0);
            bldr.extend(0.0, 0.0 - i);
        }
        
        assertEquals(new GWTBounds(0.0, -10.0, 10.0, 0.0), bldr.getBounds());
        
    }
    
    @Test
    @Ignore
    public void testDatelinePoints() {
        
        BoundsBuilder bldr = new BoundsBuilder();
        
        bldr.extend(40, -170);
        bldr.extend(30, 170);
        
        assertEquals(new GWTBounds(30, 170, 40, -170), bldr.getBounds());
        
        
        // 
    }
    
    @Test
    public void testDistanceFromEasternHemi() {
        
        BoundsBuilder bldr = new BoundsBuilder();
        
        bldr.extend(10, 170);
        bldr.extend(0, 160);
        
        assertEquals(5.0, bldr.distanceEast(175), 0.0);
        assertEquals(5.0, bldr.distanceWest(155), 0.0);
        
        assertEquals(20.0, bldr.distanceEast(-170), 0.0);
        assertEquals(330.0, bldr.distanceWest(-170), 0.0);
        
    }

    @Test
    public void testDistanceFromWesternHemi() {
        
        BoundsBuilder bldr = new BoundsBuilder();
        
        bldr.extend(10, -170);
        bldr.extend(0, -160);
        
        assertEquals(335.0, bldr.distanceEast(175), 0.0);
        assertEquals(35.0, bldr.distanceWest(155), 0.0);
        
        assertEquals(345.0, bldr.distanceEast(-175), 0.0);
        assertEquals(5.0, bldr.distanceWest(-175), 0.0);
        
    }
}
