import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class FactRepository{

    public List<String> descriptionList = new ArrayList<>();
    public List<String> factList = new ArrayList<>();

    public List<String> getDescriptionList(){
        return this.descriptionList;
    }

    public List<String> getFactList(){
        return this.factList;
    }

    public Iterator<String> getIteratorDescription(){
        FactParser factParser = new FactParser();
        FactRepository factRepository = factParser.getFactRepository();
        List<String> descriptionList = factRepository.getDescriptionList();

        Iterator<String> itr = descriptionList.iterator();

        return itr;
    }

    public Iterator<String> getIteratorFact(){
        FactParser factParser = new FactParser();
        FactRepository factRepository = factParser.getFactRepository();
        List<String> factList = factRepository.getFactList();

        Iterator<String> itr = factList.iterator();

        return itr;
    }

    // public static void main(String[] args){
    //     FactRepository factRepository = new FactRepository();
    //     Iterator<String> itr = factRepository.getIteratorDescription();
    //     Iterator<String> itrFact = factRepository.getIteratorFact();

    //     while(itr.hasNext()){
    //         String temp = itr.next();
    //         System.out.println(temp);
    //     }
    //     while(itrFact.hasNext()){
    //         String temp = itrFact.next();
    //         System.out.println(temp);
    //     }
        
    // }
}