package com.thoughtworks.acit;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by machira on Jul/21/15.
 */
public class CarTest extends TestCase {

    @Test
    public void shouldGoReallyFast(){
        Car car = new Car();
        assertThat(car.vroomVroom(), is("meh"));
    }



}