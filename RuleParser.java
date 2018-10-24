import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class RuleParser extends XMLParser{

    protected List<String> xmlList = new ArrayList<>();

    public List<String> getXmlList(){
        return this.xmlList;
    }

    public void loadXmlDOcument(String xmlPath){
        try{
            File inputFile = new File("/home/hubert/Pulpit/expert-system-hubert/" + xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Rule");

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);

                Element eElement = (Element) nNode;
                xmlList.add("Rule id: " + eElement.getAttribute("id"));
                xmlList.add("Question: " + eElement.getElementsByTagName("Question").item(0).getTextContent());

                Element nListAnswer = (Element)eElement.getElementsByTagName("Answer").item(0);

                Element nListSelection = (Element)nListAnswer.getElementsByTagName("Selection").item(0);
                Element nListSelection2 = (Element)nListAnswer.getElementsByTagName("Selection").item(1);
                xmlList.add("Selection first: " + nListSelection.getAttribute("value"));
                xmlList.add("Selection second: " + nListSelection2.getAttribute("value"));


                Element nListSingleValue = (Element)nListSelection.getElementsByTagName("SingleValue").item(0);
                Element nListSingleValue2 = (Element)nListSelection2.getElementsByTagName("SingleValue").item(0);

                if((Element)nListSelection.getElementsByTagName("SingleValue").item(0) != null ||
                   (Element)nListSelection.getElementsByTagName("SingleValue").item(1) != null){
                    xmlList.add("SingleValue: " + nListSingleValue.getAttribute("value"));
                    xmlList.add("SingleValue: " + nListSingleValue2.getAttribute("value"));
                }else{
                    Element nListMultipleValue = (Element)nListSelection.getElementsByTagName("MultipleValue").item(0);
                    Element nListMultipleValue2 = (Element)nListSelection2.getElementsByTagName("MultipleValue").item(0);
                    xmlList.add("MultipleValue: " + nListMultipleValue.getAttribute("value"));
                    xmlList.add("MultipleValue: " + nListMultipleValue2.getAttribute("value"));
                }  
            }
            this.xmlList.add("----------FACTS.XML---------------");

            NodeList nListFacts = doc.getElementsByTagName("Fact");

            for(int i=0; i<nListFacts.getLength(); i++){
                Node nNode = nListFacts.item(i);

                Element eElement = (Element) nNode;
                xmlList.add("Fact id: " + eElement.getAttribute("id"));
                Element nListDescription = (Element)eElement.getElementsByTagName("Description").item(0);
                xmlList.add("Description: " + nListDescription.getAttribute("value"));

                Element nListEvals = (Element)eElement.getElementsByTagName("Evals").item(0);

                xmlList.add("family: " + nListEvals.getElementsByTagName("Eval").item(0).getTextContent());
                xmlList.add("money: " + nListEvals.getElementsByTagName("Eval").item(1).getTextContent());
                xmlList.add("comfort: " + nListEvals.getElementsByTagName("Eval").item(2).getTextContent());
                xmlList.add("luxury: " + nListEvals.getElementsByTagName("Eval").item(3).getTextContent());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public RuleRepository getRuleRepository(){ 
        RuleParser ruleParser = new RuleParser();
        RuleRepository ruleRepository = new RuleRepository();
        ruleParser.loadXmlDOcument("Rules.xml");
        List<String> parsedList = ruleParser.getXmlList();

        for(int i=0; i<parsedList.size(); i++){
            if(parsedList.get(i).contains("Rule id:")){
                ruleRepository.ruleList.add(parsedList.get(i));
            }else if(parsedList.get(i).contains("Question:")){
                ruleRepository.questionList.add(parsedList.get(i));
            }else if(parsedList.get(i).contains("SingleValue:")){
                ruleRepository.singleValueList.add(parsedList.get(i));
            }else if(parsedList.get(i).contains("MultipleValue:")){
                ruleRepository.multipleValueList.add(parsedList.get(i));
            }
        }
        return ruleRepository;
    }
}