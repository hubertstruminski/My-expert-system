import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Controller{

    public List<String> getAnswerByQuestion(){
        Scanner scanner = new Scanner(System.in);
        RuleParser ruleParser = new RuleParser();
        RuleRepository ruleRepository = ruleParser.getRuleRepository();
        Iterator<String> iteratorQuestion = ruleRepository.getIteratorQuestion();
        String input;
        List<String> answersList = new ArrayList<>();

        while(iteratorQuestion.hasNext()){
            String question = iteratorQuestion.next();
            System.out.println(question);
            System.out.print("Enter answer: ");
            input = scanner.next();
            answersList.add(input);
        }
        return answersList;
    }

    public List<Boolean> evaluate(){
        Controller controller = new Controller();
        Answer answer = new Answer();
        List<String> answersList = controller.getAnswerByQuestion();

        List<Boolean> collectAnswerList = new ArrayList<>();

        for(int i=0; i<answersList.size(); i++){
            collectAnswerList.add(answer.evaluateAnswerByInput(answersList.get(i)));
        }
        // collectAnswerList.add(answer.evaluateAnswerByInput(answersList.get(0)));
        // collectAnswerList.add(answer.evaluateAnswerByInput(answersList.get(1)));
        // collectAnswerList.add(answer.evaluateAnswerByInput(answersList.get(2)));
        // collectAnswerList.add(answer.evaluateAnswerByInput(answersList.get(3)));
        
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

        int count = 0;
        int countFacts = 0;
        while(iteratorFacts.hasNext()){
            String fact = iteratorFacts.next();
            String evaluatedAnswer = iteratorEvaluatedAnswer.next();

            countrFacts++;

            if(fact.equals(evaluatedAnswer)){
                count++;
            }

            if(countFacts > 0 && countFacts < 5){
                if(count == 4){
                    return descriptionList.get(0);
                }
            }else if(countFacts > 4 && countFacts < 10){
                if(count == 4){
                    return descriptionList.get(1);
                }
            }
        }

    }
}