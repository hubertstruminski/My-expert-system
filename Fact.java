import java.util.List;

public class Fact{

    private String id;
    private String description;
    private FactParser factParser = new FactParser();
    private FactRepository factRepository = factParser.getFactRepository();
    public List<String> factList = factRepository.getDescriptionList();

    public Fact(String id, String description){
        this.id = id;
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public List<String> getFactList(){
        return this.factList;
    }
}