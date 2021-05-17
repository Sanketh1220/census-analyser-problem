import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IndianCensusAnalyserTest {
    private static final String ORIGINAL_FILE_PATH = "/Users/apple/IdeaProjects/IndianStatesCensusAnalyser/src/india-districts-census-2011.csv";
    private static final String WRONG_FILE_PATH = "/Users/apple/IdeaProjects/IndianStatesCensusAnalyser/src/indian-districts-census-2011.csv";

    @Test
    public void givenCorrectFilePathPassTheTest() {
        try {
            IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(ORIGINAL_FILE_PATH);
            Assert.assertEquals(640, numOfRecords);
        } catch (IndianCensusAnalyserException e) {
        }
    }

    @Test
    public void givenWrongPathReturnsCustomException() {
        try {
            IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(IndianCensusAnalyserException.class);
            int numOfRecords = censusAnalyser.loadIndiaCensusData(WRONG_FILE_PATH);
            Assert.assertEquals(640, numOfRecords);
        } catch (IndianCensusAnalyserException e) {
            Assert.assertEquals(IndianCensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
}