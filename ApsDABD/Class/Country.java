/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apsdabd;

/**
 *
 * @author AlucardHell
 */
public class Country {

    private String Code;            // Código Principal
    private String Code2;           // Código Alternativo
    private String LocalName;       // Nome do Pais Local 
    private String Name;            // Nome do País (em Inglês)
    private String Continent;       // Continente
    private String HeadOfState;     // Nome do Governante
    private double LifeExpectancy;   // Expectativa de Vida
    private int Capital;            // Quantidade de Cidades que este país possui
    private String Language;        // Linguas do Pais
    private String IsOfficial;      // Línguas Oficiais e Não Oficiais
    
    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getCode2() {
        return Code2;
    }

    public void setCode2(String Code2) {
        this.Code2 = Code2;
    }

    public String getLocalName() {
        return LocalName;
    }

    public void setLocalName(String LocalName) {
        this.LocalName = LocalName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String Continent) {
        this.Continent = Continent;
    }

    public String getHeadOfState() {
        return HeadOfState;
    }

    public void setHeadOfState(String HeadOfState) {
        this.HeadOfState = HeadOfState;
    }

    public double getLifeExpectancy() {
        return  LifeExpectancy;
    }

    public void setLifeExpectancy(double LifeExpectancy) {
        this.LifeExpectancy = Math.ceil(LifeExpectancy);
    }

    public int getCapital() {
        return Capital;
    }

    public void setCapital(int Capital) {
        this.Capital = Capital;
    }

    public String getIsOfficial() {
        return IsOfficial;
    }

    public void setIsOfficial(String IsOfficial) {
        if ("T".equals(IsOfficial)){
        this.IsOfficial = "Oficial";
    }else{
        this.IsOfficial = "Não Oficial";
    }
    }
    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }
    
}
