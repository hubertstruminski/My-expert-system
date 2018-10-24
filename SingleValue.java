import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class SingleValue extends Value{

    private RuleParser ruleParser = new RuleParser();
    private RuleRepository ruleRepository = ruleParser.getRuleRepository();
    private List<String> singleValueList = ruleRepository.getSingleValueList();

    public List<String> getSingleValueAnswer(){
        List<String> singleValueAnswerList = new ArrayList<>();
 
        for(String element: this.singleValueList){
            singleValueAnswerList.add(element.substring(13));
        }
        return singleValueAnswerList;
    }

    public Iterator<String> getIteratorSingleValue(){
        SingleValue singleValue = new SingleValue();
        Iterator<String> itr = singleValue.getSingleValueAnswer().iterator();

        return itr;
    }

    // public static void main(String[] args){
    //     SingleValue singleValue = new SingleValue();
    //     Iterator<String> itr = singleValue.getIteratorSingleValue();

    //     while(itr.hasNext()){
    //         String temp = itr.next();
    //         System.out.println(temp);
    //     }
    // }
}