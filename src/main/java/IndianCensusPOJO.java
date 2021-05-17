/*************************************************************************
 * Purpose : This code is written to create POJO to get data from indian census
 *
 * @author Sanketh Chigurupalli
 * @since 07-05-2021
 *
 *************************************************************************/

import com.opencsv.bean.CsvBindByName;

/**
 * created a POJO
 */
public class IndianCensusPOJO {
    @CsvBindByName(column = "State name")
    private String stateName;
    @CsvBindByName(column = "Population")
    private String population;
    @CsvBindByName(column = "Male_Literate")
    private double maleLiterate;
    @CsvBindByName(column = "Female_Literate")
    private double femaleLiterate;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public double getMaleLiterate() {
        return maleLiterate;
    }

    public void setMaleLiterate(double maleLiterate) {
        this.maleLiterate = maleLiterate;
    }

    public double getFemaleLiterate() {
        return femaleLiterate;
    }

    public void setFemaleLiterate(double femaleLiterate) {
        this.femaleLiterate = femaleLiterate;
    }

    /**
     * String formatted return method for data
     * @return
     */
    @Override
    public String toString() {
        return "IndiaCensusGettingPOJO{" +
                "stateName='" + stateName + '\'' +
                ", population='" + population + '\'' +
                ", maleLiterate=" + maleLiterate +
                ", femaleLiterate=" + femaleLiterate +
                '}';
    }
}