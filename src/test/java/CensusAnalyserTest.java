

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


// UC1-Ability for the analyser to load the Indian States Census Information from a csv file

public class CensusAnalyserTest {

    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndianStatesCensus.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndianStatesCensusData.csv";

    @Test
    public void givenIndianCensusCSVFile_WhenCorrectPath_ShouldReturnCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assertions.assertEquals(33, numOfRecords);
        }
        catch (CensusAnalyserException e) {
        }
    }
//  testing for the sad case
    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        }
        catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
            e.printStackTrace();
        }
    }

}