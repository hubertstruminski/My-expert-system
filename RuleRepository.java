import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class RuleRepository{

    public List<String> ruleList = new ArrayList<>();
    public List<String> questionList = new ArrayList<>();
    public List<String> singleValueList = new ArrayList<>();
    public List<String> multipleValueList = new ArrayList<>();

    private List<String> addQuestionList = new ArrayList<>();

    public List<String> getRuleList(){
        return this.ruleList;
    }

    public List<String> getQuestionList(){
        return this.questionList;
    }

    public List<String> getSingleValueList(){
        return this.singleValueList;
    }

    public List<String> getMultipleValueList(){
        return this.multipleValueList;
    }

    public void addQuestion(Question question){
        List<String> questionList = question.getQuestionList();

        for(int i=0; i<questionList.size(); i++){
            this.addQuestionList.add(questionList.get(i));
        }
    }

    public Iterator<String> getIteratorQuestion(){
        RuleParser ruleParser = new RuleParser();
        RuleRepository ruleRepository = ruleParser.getRuleRepository();
        List<String> questionList = ruleRepository.getQuestionList();

        List<String> resultList = new ArrayList<>();

        for(String item: questionList){
            resultList.add(item.substring(10));
        }

        Iterator<String> itr = resultList.iterator();

        return itr;
    }

    public static void main(String[] args){
        RuleRepository ruleRepository = new RuleRepository();

        Iterator<String> itr = ruleRepository.getIterator();

        while(itr.hasNext()){
            String temp = itr.next();
            System.out.println(temp);
        }
    }
}