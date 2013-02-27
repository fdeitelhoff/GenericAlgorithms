package de.deitelhoff.persistence.algorithm.test.executor;

import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutorFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 03.06.12
 * Time: 01:00
 */
public class AlgorithmExecutorFactoryTests
{
    @Test
    public void simpleAlgorithmExecutorFactoryTest()
    {
        // Arrange
        AlgorithmExecutorFactory algorithmExecutorFactory;

        // Act
        algorithmExecutorFactory = new AlgorithmExecutorFactory();

        // Assert
        assertNotNull(algorithmExecutorFactory);
    }
}
