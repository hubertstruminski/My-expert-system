import java.util.List;
import java.util.ArrayList;

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
}