import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseQuestions {
	static TestBank banky = new TestBank();
	static FactoryBank factbanky = new FactoryBank();
	/**
	 * @throws JSONException
	 * @throws IOException
	 * @throws ParseException
	 * This method opens a JSON file holding an array of all the questions
	 * It parses the file
	 * It creates question objects which are added to the question bank
	 */
	public static TestBank fillTestBank() throws JSONException, IOException, ParseException {
		//create the textbook variables
		Question question;
		String text;
		String topic;
		int bloom;
		ArrayList<String> answers;
		
		//parse the JSON file into an array
		JSONParser parser = new JSONParser();
		JSONArray arr = (JSONArray) parser.parse(new FileReader("q.json"));
		
		//iterate through the array
		for (Object r: arr) {
			
			//convert each question into a JSON object
			JSONObject q = (JSONObject) r;
			
			//get the question
			text = (String) q.get("text");
			
			//get the answers to the questions
			JSONObject a = (JSONObject) q.get("answers");
			answers = new ArrayList<String>();
			answers.add((String)a.get("0"));
			answers.add((String)a.get("1"));
			answers.add((String)a.get("2"));
			answers.add((String)a.get("3"));
			
			//get the topic
			topic = (String)q.get("topic");
			
			//get the Bloom portion
			bloom = Integer.parseInt((String)q.get("Bloom"));
			
			//create a new question
			question = new Question(text, answers, topic, bloom);
			
			//add the question to the question bank
			banky.addQuest(question);
		}
		return banky;
	}
	
	/**
	 * @throws JSONException
	 * @throws IOException
	 * @throws ParseException
	 * This method opens a JSON file holding an array of all the factory questions
	 * It parses the file
	 * It creates factory question objects which are added to the factory bank
	 */
	public static FactoryBank fillFactoryBank() throws JSONException, IOException, ParseException {
		//create the textbook variables
		FactoryQuestion fq;
		String textA;
		String textB;
		String topic;
		int bloom;
		ArrayList<String> textOps;
		ArrayList<String> rightAns;
		ArrayList<String> answers;
		
		//parse the JSON file into an array
		JSONParser parser = new JSONParser();
		JSONArray arr = (JSONArray) parser.parse(new FileReader("fq.json"));
		
		//iterate through the array
		for (Object r: arr) {
			
			//convert each question into a JSON object
			JSONObject q = (JSONObject) r;
			
			//get the question
			textA = (String) q.get("textA");
			textB = (String) q.get("textB");
			
			//get the text options to the questions
			JSONObject a = (JSONObject) q.get("textOps");
			textOps = new ArrayList<String>();
			textOps.add((String)a.get("0"));
			textOps.add((String)a.get("1"));
			textOps.add((String)a.get("2"));
			textOps.add((String)a.get("3"));
			
			//get the aswer options to the questions
			JSONObject b = (JSONObject) q.get("rightAns");
			rightAns = new ArrayList<String>();
			rightAns.add((String)b.get("0"));
			rightAns.add((String)b.get("1"));
			rightAns.add((String)b.get("2"));
			rightAns.add((String)b.get("3"));
			
			//get the answers to the questions
			JSONObject c = (JSONObject) q.get("answers");
			answers = new ArrayList<String>();
			answers.add((String)c.get("0"));
			answers.add((String)c.get("1"));
			answers.add((String)c.get("2"));
			
			//get the topic
			topic = (String)q.get("topic");
			
			//get the Bloom portion
			bloom = Integer.parseInt((String)q.get("Bloom"));
			
			//create a new question
			fq = new FactoryQuestion(textA, textB, textOps, rightAns, answers, topic, bloom);
			
			//add the question to the question bank
			factbanky.addQuest(fq);
		}
		return factbanky;
	}
}
