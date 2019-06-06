/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apsdabd;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AlucardHells
 */
public interface CountryDAO {

    public List<Country> listar(String nome) throws SQLException;
    
    public String verificarNull(String Code, String Name) throws SQLException;

    public int alterarLocalName(Country country) throws SQLException;

    public int alterarName(Country country, String UPDATE) throws SQLException;

    public int alterarLifeExpectancy(Country country, String UPDATE) throws SQLException;

    public int alterarCode2(Country country) throws SQLException;
    
    public int alterarContinent (Country country, String UPDATE) throws SQLException;
    
    public int alterarGovernmentForm (Country country, String UPDATE) throws SQLException;
    
    public String buscaCode (String Code, String Name) throws SQLException;
    
    public int deleteCity(String code) throws SQLException;
    
    public int deleteCountryLanguage(String code) throws SQLException;
    
    public int deleteCountry(String code) throws SQLException;
}
