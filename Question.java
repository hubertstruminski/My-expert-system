import java.util.List;
import java.util.ArrayList;

public class Question{

    private String id;
    private String question;
    private Answer answer;
    private RuleParser ruleParser = new RuleParser();
    private RuleRepository ruleRepository = ruleParser.getRuleRepository();
    public List<String> questionList = ruleRepository.getQuestionList();

    public Question(String id, String question, Answer answer){
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getId(){
        return this.id;
    }

    public String getQuestion(){
        return this.question;
    }

    public Answer getAnswer(){
        return this.answer;
    }

    public List<String> getQuestionList(){
        return this.questionList;
    }

    public boolean getEvaluateAnswer(String input){
        if(input.equals("yes")){
            return true;
        }else if(input.equals("no")){
            return false;
        }else if(input.equals("comfort")){
            return true;
        }else if(input.equals("speed")){
            return false;
        }else if(input.equals("gps") || input.equals("bluetooth") || input.equals("dvd") || input.equals("automatic transmission") || input.equals("self-driving")){
            return true;
        }else if(input.equals("nothing") || input.equals("abs") || input.equals("fog lights") || input.equals("central lock")){
            return false;
        }else{
            return false;
        }
    }
}