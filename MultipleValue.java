import java.util.List;
import java.util.ArrayList;

public class MultipleValue extends Value{

    private RuleParser ruleParser = new RuleParser();
    private RuleRepository ruleRepository = ruleParser.getRuleRepository();
    private List<String> multipleValueList = ruleRepository.getMultipleValueList();

    public List<String> getMultipleValueAnswer(){
        List<String> multipleValueAnswerList = new ArrayList<>();
 
        for(String element: this.multipleValueList){
            multipleValueAnswerList.add(element.substring(15));
        }
        return multipleValueAnswerList;
    }
}