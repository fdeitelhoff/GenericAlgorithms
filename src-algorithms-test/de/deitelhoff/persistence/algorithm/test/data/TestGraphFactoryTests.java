package de.deitelhoff.persistence.algorithm.test.data;

import de.deitelhoff.persistence.algorithm.graph.data.TestGraphFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 03.06.12
 * Time: 00:43
 */
public class TestGraphFactoryTests
{
    @Test
    public void simpleTestGraphFactoryTest()
    {
        // Arrange
        TestGraphFactory testGraphFactory;

        // Act
        testGraphFactory = new TestGraphFactory();

        // Assert
        assertNotNull(testGraphFactory);
    }
}
