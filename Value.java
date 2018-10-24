import java.util.List;
import java.util.ArrayList;

public abstract class Value{

    private RuleParser ruleParser = new RuleParser();
    private RuleRepository ruleRepository = ruleParser.getRuleRepository();
    public List<String> singleValueList = ruleRepository.getSingleValueList();
    public List<String> multipleValueList = ruleRepository.getMultipleValueList();

    public List<String> getSingleValueList(){
        return this.singleValueList;
    }

    public List<String> getMultipleValueList(){
        return this.multipleValueList;
    }
}