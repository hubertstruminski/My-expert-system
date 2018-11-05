import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Controller {

    public List<String> getAnswerByQuestion() {
        Scanner scanner = new Scanner(System.in);
        RuleParser ruleParser = new RuleParser();
        RuleRepository ruleRepository = ruleParser.getRuleRepository();
        Iterator<String> iteratorQuestion = ruleRepository.getIteratorQuestion();
        String input;
        List<String> answersList = new ArrayList<>();

        while (iteratorQuestion.hasNext()) {
            String question = iteratorQuestion.next();
            System.out.println(question);
            System.out.print("Enter answer: ");
            input = scanner.next();
            answersList.add(input);
        }
        return answersList;
    }

    public List<Boolean> evaluate() {
        Controller controller = new Controller();
        Answer answer = new Answer();
        List<String> answersList = controller.getAnswerByQuestion();

        List<Boolean> collectAnswerList = new ArrayList<>();

        for (int i = 0; i < answersList.size(); i++) {
            collectAnswerList.add(answer.evaluateAnswerByInput(answersList.get(i)));
        }
        return collectAnswerList;
    }

    public Iterator<Boolean> getEvaluateIterator() {
        Controller controller = new Controller();
        List<Boolean> evaluatedList = controller.evaluate();

        Iterator<Boolean> itr = evaluatedList.iterator();

        return itr;
    }

    public String assignAnswerToCar() {
        Controller controller = new Controller();
        FactRepository factRepository = new FactRepository();
        FactParser factParser = new FactParser();
        FactRepository factRepository2 = factParser.getFactRepository();

        List<String> descriptionList = factRepository2.getDescriptionList();

        Iterator<Boolean> iteratorEvaluatedAnswer = controller.getEvaluateIterator();
        Iterator<String> iteratorFacts = factRepository.getIteratorFact();
        Iterator<String> iteratorDescriptions = factRepository.getIteratorDescription();

        List<String> answers = new ArrayList<String>();
        while (iteratorEvaluatedAnswer.hasNext()) {
            String evaluatedAnswer = iteratorEvaluatedAnswer.next().toString();
            answers.add(evaluatedAnswer);
        }

        int countFacts = 0;
        while (iteratorFacts.hasNext()) {
            String fact = iteratorFacts.next();
            int count = 0;
            for (String answer:answers) {
                if (fact.equals(answer)) {
                    count++;
                }
                countFacts++;
            }
            if (count == 4) {
                if (countFacts >= 1 && countFacts <= 4) {
                    return "\n" + descriptionList.get(0);
                } else if (countFacts >= 5 && countFacts <= 8) {
                    return "\n" + descriptionList.get(1);
                } else if (countFacts >= 9 && countFacts <= 12) {
                    return "\n" + descriptionList.get(2);
                } else if (countFacts >= 13 && countFacts <= 16) {
                    return "\n" + descriptionList.get(3);
                }
            }
        }
        return "I didn't find any cars!";
    }

    public static void main(String[] args) {
        Controller controller = new Controller();

        String nameCar = controller.assignAnswerToCar();
        System.out.println(nameCar);
    }
}