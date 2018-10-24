import java.util.List;

public class FactIterator{

    private FactParser factParser = new FactParser();
    private FactRepository factRepository = factParser.getFactRepository();
    private List<String> factList = factRepository.getDescriptionList();
    private String[] factArray = factList.toArray(new String[factList.size()]);
    private int currentIndex = 0;
    private int currentSize = factList.size();

    public boolean hasNext(){
        return currentIndex < currentSize && factArray[currentIndex] != null;
    }

    public String next(){
        return factArray[currentIndex++];
    }
}