import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Factory question bank, almost identical to the TestBank class, except that it's
 * getQuest() function returns a question out of a FactoryQuestion for a given
 * topic
 * @author SPRECHERND1
 *
 */
public class FactoryBank {
	Map<String, ArrayList<FactoryQuestion>> bank;
	Random rand;
	int randNo;
	boolean hasQ;
	
	//initializes bank
	FactoryBank(){
		bank = new HashMap<String, ArrayList<FactoryQuestion>>();
		rand = new Random();
	}
	
	//adds question to bank
	void addQuest(FactoryQuestion quest){
		//if the test bank does not contain this topic, create a new one and add question
		if(!bank.containsKey(quest.getTopic())){
			quest.setID(0);
			bank.put(quest.getTopic(), new ArrayList<FactoryQuestion>());
			bank.get(quest.getTopic()).add(quest);
		}else{
			quest.setID(bank.get(quest.getTopic()).size());
			bank.get(quest.getTopic()).add(quest);
		}
	}
	
	//get random factory question 
	Question getQuest(String topic, int pos){
		FactoryQuestion factQ = bank.get(topic).get(pos);
		
		randNo = rand.nextInt(factQ.getNumAns());
		
		String text = factQ.getTextA() + factQ.getTextOp(randNo) + factQ.getTextB();
		ArrayList<String> ans = new ArrayList<String>();
		ans.add(factQ.getRightAns(randNo));
		ans.addAll(factQ.getAnswers());
		Question retQ = new Question(text, ans, factQ.getTopic(), factQ.getBloom());
		
		return retQ;
	}
}
