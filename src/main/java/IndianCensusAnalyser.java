/*************************************************************************
 * Purpose : This code is written to read csv file
 *
 * @author Sanketh Chigurupalli
 * @since 07-05-2021
 *
 *************************************************************************/

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

/**
 * reader for the csv file
 */
public class IndianCensusAnalyser {
    public int loadIndiaCensusData(String csvFilePath) throws IndianCensusAnalyserException {
        try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            CsvToBeanBuilder<IndianCensusPOJO> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndianCensusPOJO.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndianCensusPOJO> csvToBean = csvToBeanBuilder.build();
            Iterator<IndianCensusPOJO> censusCSVIterator = csvToBean.iterator();
            Iterable<IndianCensusPOJO> csvIterable = () -> censusCSVIterator;
            int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(),false).count();
            return numOfEntries;
        } catch (IOException e) {
            throw new IndianCensusAnalyserException(e.getMessage(), IndianCensusAnalyserException
                    .ExceptionType
                    .CENSUS_FILE_PROBLEM);
        } catch (IllegalStateException e) {
            throw new IndianCensusAnalyserException(e.getMessage(), IndianCensusAnalyserException
                    .ExceptionType
                    .UNABLE_TO_PARSE);
        }
    }

    /**
     * main method of the program
     * @param args
     * @throws IndianCensusAnalyserException
     */
    public static void main(String[] args) throws IndianCensusAnalyserException {
        IndianCensusAnalyser indianCensusAnalyser = new IndianCensusAnalyser();
        int number = indianCensusAnalyser.loadIndiaCensusData("/Users/apple/IdeaProjects/IndianStatesCensusAnalyser/src/india-districts-census-2011.csv");
        System.out.println(number);
    }
}