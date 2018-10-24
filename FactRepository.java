import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class FactRepository{

    public List<String> descriptionList = new ArrayList<>();
    public List<String> familyList = new ArrayList<>();
    public List<String> moneyList = new ArrayList<>();
    public List<String> comfortList = new ArrayList<>();
    public List<String> luxuryList = new ArrayList<>();

    private List<String> addFactDescriptionList = new ArrayList<>();

    public List<String> getDescriptionList(){
        return this.descriptionList;
    }

    public List<String> getFamilyList(){
        return this.familyList;
    }

    public List<String> getMoneyList(){
        return this.moneyList;
    }

    public List<String> getComfortList(){
        return this.comfortList;
    }

    public List<String> getLuxuryList(){
        return this.luxuryList;
    }

    public List<String> getAddFactDescriptionList(){
        return this.addFactDescriptionList;
    }

    public void addFactDescription(Fact fact){
        List<String> factList = fact.getFactList();
        for(String element: factList){
            this.addFactDescriptionList.add(element);
        }
    }

    public List<String> factTesla(){
        FactParser factParser = new FactParser();
        FactRepository factRepository = factParser.getFactRepository();

        List<String> factTeslaFamilyList = factRepository.getFamilyList();
        List<String> factTeslaMoneyList = factRepository.getMoneyList();
        List<String> factTeslaComfortList = factRepository.getComfortList();
        List<String> factTeslaLuxuryList = factRepository.getLuxuryList();

        List<String> factTeslaList = new ArrayList<>();

        factTeslaList.add(factTeslaMoneyList.get(0));
        factTeslaList.add(factTeslaComfortList.get(0));
        factTeslaList.add(factTeslaFamilyList.get(0));
        factTeslaList.add(factTeslaLuxuryList.get(0));

        return factTeslaList;
    }

    public List<String> factMokka(){
        FactParser factParser = new FactParser();
        FactRepository factRepository = factParser.getFactRepository();

        List<String> factMokkaFamilyList = factRepository.getFamilyList();
        List<String> factMokkaMoneyList = factRepository.getMoneyList();
        List<String> factMokkaComfortList = factRepository.getComfortList();
        List<String> factMokkaLuxuryList = factRepository.getLuxuryList();

        List<String> factMokkaList = new ArrayList<>();

        factMokkaList.add(factMokkaMoneyList.get(1));
        factMokkaList.add(factMokkaComfortList.get(1));
        factMokkaList.add(factMokkaFamilyList.get(1));
        factMokkaList.add(factMokkaLuxuryList.get(1));

        return factMokkaList;
    }

    public List<String> factLada(){
        FactParser factParser = new FactParser();
        FactRepository factRepository = factParser.getFactRepository();

        List<String> factLadaFamilyList = factRepository.getFamilyList();
        List<String> factLadaMoneyList = factRepository.getMoneyList();
        List<String> factLadaComfortList = factRepository.getComfortList();
        List<String> factLadaLuxuryList = factRepository.getLuxuryList();

        List<String> factLadaList = new ArrayList<>();

        factLadaList.add(factLadaMoneyList.get(2));
        factLadaList.add(factLadaComfortList.get(2));
        factLadaList.add(factLadaFamilyList.get(2));
        factLadaList.add(factLadaLuxuryList.get(2));

        return factLadaList;
    }

    public Iterator<String> getIterator(){
        FactParser factParser = new FactParser();
        FactRepository factRepository = factParser.getFactRepository();
        List<String> factList = factRepository.getDescriptionList();

        Iterator<String> itr = factList.iterator();

        return itr;
    }
}