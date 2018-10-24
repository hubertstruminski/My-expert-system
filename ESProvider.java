import java.util.List;
import java.util.Scanner;
import javax.swing.text.DefaultStyledDocument.ElementSpec;
import java.util.ArrayList;

public class ESProvider{

    public List<String> getAnswerByQuestion(){
        Scanner scanner = new Scanner(System.in);
        RuleParser ruleParser = new RuleParser();
        SingleValue singleValue = new SingleValue();
        MultipleValue multipleValue = new MultipleValue();
        RuleRepository ruleRepository = ruleParser.getRuleRepository();
        List<String> singleValueList = singleValue.getSingleValueAnswer();
        List<String> multipleValueList = multipleValue.getMultipleValueAnswer();
        List<String> questionList = ruleRepository.getQuestionList();
        String input;
        List<String> answersList = new ArrayList<>();

        for(int i=0; i<questionList.size(); i++){
            System.out.println(questionList.get(i));
            if(i == 0){
                System.out.println(singleValueList.get(0) + " OR " + singleValueList.get(1));
                System.out.print("Enter answer: ");
                input = scanner.next();
                answersList.add(input);
            }else if(i == 1){
                System.out.println(singleValueList.get(2) + " OR " + singleValueList.get(3));
                System.out.print("Enter answer: ");
                input = scanner.next();
                answersList.add(input);
                if(input.equals("comfort")){
                    answersList.add("true");
                }else{
                    answersList.add("false");
                }
            }else if(i == 2){
                System.out.println(multipleValueList.get(0) + " OR " + multipleValueList.get(1));
                System.out.print("Enter answer: ");
                input = scanner.next();
                answersList.add(input);
            }
        }
        return answersList;
    }

    public List<Boolean> evaluate(){
        ESProvider esProvider = new ESProvider();
        Answer answer = new Answer();
        List<String> answerList = esProvider.getAnswerByQuestion();

        List<Boolean> collectAnswerList = new ArrayList<>();

        collectAnswerList.add(answer.evaluateAnswerByInput(answerList.get(0)));
        collectAnswerList.add(answer.evaluateAnswerByInput(answerList.get(1)));
        collectAnswerList.add(answer.evaluateAnswerByInput(answerList.get(2)));
        collectAnswerList.add(answer.evaluateAnswerByInput(answerList.get(3)));
        
        return collectAnswerList;
    }

    public String assignAnswerToCar(){
        ESProvider esProvider = new ESProvider();
        FactRepository factRepository = new FactRepository();
        FactParser factParser = new FactParser();
        FactRepository factRepository2 = factParser.getFactRepository();

        List<String> descriptionList = factRepository2.getDescriptionList();

        List<Boolean> booleanValuesList = esProvider.evaluate();
        List<String> teslaList = factRepository.factTesla();
        List<String> mokkaList = factRepository.factMokka();
        List<String> ladaList = factRepository.factLada();

        if(booleanValuesList.get(0).toString().equals(teslaList.get(0).toString()) && 
           booleanValuesList.get(1).toString().equals(teslaList.get(1).toString()) && 
           booleanValuesList.get(2).toString().equals(teslaList.get(2).toString()) &&
           booleanValuesList.get(3).toString().equals(teslaList.get(3).toString())){
            return descriptionList.get(0);
        }else if(booleanValuesList.get(0).toString().equals(mokkaList.get(0).toString()) && 
                 booleanValuesList.get(1).toString().equals(mokkaList.get(1).toString()) && 
                 booleanValuesList.get(2).toString().equals(mokkaList.get(2).toString()) &&
                 booleanValuesList.get(3).toString().equals(mokkaList.get(3).toString())){
            return descriptionList.get(1);
        }else if(booleanValuesList.get(0).toString().equals(ladaList.get(0).toString()) && 
                 booleanValuesList.get(1).toString().equals(ladaList.get(1).toString()) &&
                 booleanValuesList.get(2).toString().equals(ladaList.get(2).toString()) &&  
                 booleanValuesList.get(3).toString().equals(ladaList.get(3).toString())){
            return descriptionList.get(2);
        }
        return "I didn't found any cars";
    }
}