/****************************************************************************************
 * Purpose : This is an exception class written to overcome exceptions caused in program
 *
 * @author Sanketh Chigurupalli
 * @since 07-05-2021
 *
 *****************************************************************************************/

public class IndianCensusAnalyserException extends Exception {
    /**
     * Created an enum to store different exception could be caused
     */
    enum ExceptionType {
        CENSUS_FILE_PROBLEM, UNABLE_TO_PARSE;
    }

    ExceptionType type;

    public IndianCensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public IndianCensusAnalyserException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}