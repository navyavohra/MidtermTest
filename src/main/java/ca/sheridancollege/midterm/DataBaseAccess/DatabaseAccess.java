package ca.sheridancollege.midterm.DataBaseAccess;

import ca.sheridancollege.midterm.Country;
import ca.sheridancollege.midterm.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseAccess {

    @Autowired
    protected NamedParameterJdbcTemplate jdbc;
    MapSqlParameterSource namedParameters = new MapSqlParameterSource();


    public void insertCountry(Country country
    ){

        String sql ="INSERT INTO country( name, capitalCity,population, continent) VALUES " +
                "(:name , :capitalCityity, :population, :continent)";
        namedParameters.addValue("Capital City", country.getCapitalCity());
        namedParameters.addValue("Population", country.getPopulation());
        namedParameters.addValue("Continent", country.getContinent());

        jdbc.update(sql,namedParameters);
    }
}
