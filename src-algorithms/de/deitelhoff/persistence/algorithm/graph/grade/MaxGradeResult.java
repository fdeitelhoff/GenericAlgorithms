package de.deitelhoff.persistence.algorithm.graph.grade;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 01.06.12
 * Time: 00:06
 */
public class MaxGradeResult
{
    private final int maxGrade;

    public MaxGradeResult(int maxGrade)
    {
        this.maxGrade = maxGrade;
    }

    public int getMaxGrade()
    {
        return maxGrade;
    }
}
