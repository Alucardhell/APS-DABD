/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apsdabd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCCountryDAO implements CountryDAO {

    private Conexao conexao;
    private PreparedStatement pstmt;

    public JDBCCountryDAO() throws SQLException, ClassNotFoundException {
        conexao = new Conexao();
        /*try {
            pstmt = (PreparedStatement) conexao.getConn().createStatement();
        } catch (SQLException ex) {
            throw ex;
        }*/
    }

    @Override
    public List<Country> listar(String nome) throws SQLException {
        List<Country> countrys = new ArrayList<Country>();
        try {
            String queryStr = "select C.Code, C.Code2, C.LocalName, C.Name, C.Continent, C.HeadOfState, C.LifeExpectancy, C.Capital, CL.Language, CL.isOfficial from country as C join countrylanguage as CL on C.Code = CL.CountryCode where C.Code like ? or C.Name like ? order by CL.Percentage desc";
            pstmt = conexao.getConn().prepareStatement(queryStr);
            pstmt.setString(1, nome);
            pstmt.setString(2, nome);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Country client = new Country();
                client.setCode(rs.getString("Code"));
                client.setCode2(rs.getString("Code2"));
                client.setLocalName(rs.getString("LocalName"));
                client.setName(rs.getString("Name"));
                client.setContinent(rs.getString("Continent"));
                client.setHeadOfState(rs.getString("HeadOfState"));
                client.setLifeExpectancy(rs.getFloat("LifeExpectancy"));
                client.setCapital(rs.getInt("Capital"));
                client.setLanguage(rs.getString("Language"));
                client.setIsOfficial(rs.getString("IsOfficial"));
                countrys.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return countrys;
    }

    @Override
    public int alterarLocalName(Country country) throws SQLException {
        try {
            String queryStr = "UPDATE Country SET LocalName = ? where Code = ? or Name = ?";
            pstmt = conexao.getConn().prepareStatement(queryStr);
            pstmt.setString(1, country.getLocalName());
            pstmt.setString(2, country.getCode());
            pstmt.setString(3, country.getName());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexao.fecharConexao();
        }
    }

    @Override
    public int alterarName(Country country, String UPDATE) throws SQLException {
        try {
            String queryStr = "UPDATE Country SET Name = ? where Code = ? or Name = ?";
            pstmt = conexao.getConn().prepareStatement(queryStr);
            pstmt.setString(1, UPDATE);
            pstmt.setString(2, country.getCode());
            pstmt.setString(3, country.getName());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexao.fecharConexao();
        }
    }

    @Override
    public int alterarLifeExpectancy(Country country, String UPDATE) throws SQLException {
        try {
            String queryStr = "UPDATE Country SET LifeExpectancy = ? where Code = ? or Name = ?";
            pstmt = conexao.getConn().prepareStatement(queryStr);
            System.out.println("Valor da pesquisa: " + UPDATE);
            pstmt.setString(1, UPDATE);
            pstmt.setString(2, country.getCode());
            pstmt.setString(3, country.getName());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexao.fecharConexao();
        }
    }

    @Override
    public int alterarCode2(Country country) throws SQLException {
        try {
            String queryStr = "UPDATE Country SET Code2 = ? where Code = ? or Name = ?";
            pstmt = conexao.getConn().prepareStatement(queryStr);
            pstmt.setString(1, country.getCode2());
            pstmt.setString(2, country.getCode());
            pstmt.setString(3, country.getName());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexao.fecharConexao();
        }
    }

    @Override
    public String verificarNull(String Code, String Name) throws SQLException {
        String Resultado = "";
        try {
            String queryStr = "select Code2 from country where code like ? or Name like ?;";
            pstmt = conexao.getConn().prepareStatement(queryStr);
            pstmt.setString(1, Code);
            pstmt.setString(2, Name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Resultado = rs.getString("Code2");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return Resultado;
    }

    @Override
    public String buscaCode(String Code, String Name) throws SQLException {
        String Resultado = "";
        try {
            String queryStr = "select Code from country where code like ? or Name like ?";
            pstmt = conexao.getConn().prepareStatement(queryStr);
            pstmt.setString(1, Code);
            pstmt.setString(2, Name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Resultado = rs.getString("Code");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Resultado;
    }

    @Override
    public int deleteCity(String code) throws SQLException {
        try {
            String queryStr = "DELETE from city where CountryCode like ?";
            pstmt = conexao.getConn().prepareStatement(queryStr);
            pstmt.setString(1, code);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO");
            throw e;
        }
    }

    @Override
    public int deleteCountryLanguage(String code) throws SQLException {
        try {
            String queryStr = "DELETE from countrylanguage where CountryCode like ?";
            pstmt = conexao.getConn().prepareStatement(queryStr);
            pstmt.setString(1, code);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public int deleteCountry(String code) throws SQLException {
        try {
            String queryStr = "DELETE from country where Code = ?";
            pstmt = conexao.getConn().prepareStatement(queryStr);
            pstmt.setString(1, code);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexao.fecharConexao();
        }
    }

    @Override
    public int alterarContinent(Country country, String UPDATE) throws SQLException {
        try {
            String queryStr = "UPDATE Country SET Continent = ? where code = ? or Name = ?";
            pstmt = conexao.getConn().prepareStatement(queryStr);
            pstmt.setString(1, UPDATE);
            pstmt.setString(2, country.getCode());
            pstmt.setString(3, country.getName());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexao.fecharConexao();
        }
    }

    @Override
    public int alterarGovernmentForm(Country country, String UPDATE) throws SQLException {
        try {
            String queryStr = "UPDATE Country SET GovernmentForm = ? where code = ? or Name = ?";
            pstmt = conexao.getConn().prepareStatement(queryStr);
            pstmt.setString(1, UPDATE);
            pstmt.setString(2, country.getCode());
            pstmt.setString(3, country.getName());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexao.fecharConexao();
        }
    }

}
