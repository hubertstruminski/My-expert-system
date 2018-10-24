import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Controller{

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
            }else if(i == 2){
                System.out.println(singleValueList.get(4) + " OR " + singleValueList.get(5));
                System.out.print("Enter answer: ");
                input = scanner.next();
                answersList.add(input);
            }else if(i == 3){
                System.out.println(multipleValueList.get(0) + " OR " + multipleValueList.get(1));
                System.out.print("Enter answer: ");
                input = scanner.next();
                answersList.add(input);
            }
        }
        return answersList;
    }

    public List<Boolean> evaluate(){
        Controller controller = new Controller();
        Answer answer = new Answer();
        List<String> answersList = controller.getAnswerByQuestion();

        List<Boolean> collectAnswerList = new ArrayList<>();

        collectAnswerList.add(answer.evaluateAnswerByInput(answersList.get(0)));
        collectAnswerList.add(answer.evaluateAnswerByInput(answersList.get(1)));
        collectAnswerList.add(answer.evaluateAnswerByInput(answersList.get(2)));
        collectAnswerList.add(answer.evaluateAnswerByInput(answersList.get(3)));
        
        return collectAnswerList;
    }

    public Iterator<String> getEvaluateIterator(){
        Controller controller = new Controller();
        List<String> evaluatedList = controller.evaluate();

        Iterator<String> itr = evaluatedList.iterator();

        return itr;
    }

    public String assignAnswerToCar(){
        Controller controller = new Controller();
        FactRepository factRepository = new FactRepository();
        FactParser factParser = new FactParser();
        FactRepository factRepository2 = factParser.getFactRepository();

        List<String> descriptionList = factRepository2.getDescriptionList();

        Iterator<String> iteratorEvaluatedAnswer = controller.getEvaluateIterator();
        Iterator<String> iteratorFacts = factRepository.getIteratorFact();
        Iterator<String> iteratorDescriptions = factRepository.getIteratorDescription();

        while(iteratorFacts.hasNext()){
            String fact = iteratorFacts.next();
            String evaluatedAnswer = iteratorEvaluatedAnswer.next();

            if(fact.equals(evaluatedAnswer)){
                
            }
        }
       
    }
}