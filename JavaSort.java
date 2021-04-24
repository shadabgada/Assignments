import java.util.ArrayList;
import java.util.Collections;

public class JavaSort 
{
    public static void main(String[] args) 
    {
        ArrayList<Question> list = new ArrayList<>();
          
        list.add(new Question(2,2,"xyz"));
        list.add(new Question(3,3,"pqr"));
        list.add(new Question(4,3,"asd"));
		list.add(new Question(4,3,"asd"));
		list.add(new Question(2,2,"xyz"));
        list.add(new Question(3,1,"pqr"));
        list.add(new Question(2,2,"xyz"));
        list.add(new Question(3,3,"pqr"));
        list.add(new Question(2,1,"xyz"));
        list.add(new Question(3,1,"pqr"));
        list.add(new Question(2,2,"xyz"));
        list.add(new Question(3,3,"pqr"));
        list.add(new Question(3,1,"pqr"));
        list.add(new Question(2,1,"xyz"));
        list.add(new Question(3,2,"pqr"));

        for(Question q: list){
             System.out.print(q.getPriority()+ " ");
			 System.out.println(q.getName());			
        }

        //Sort the list on the basis of priority
		Collections.sort(list, (Question q1, Question q2) -> q1.getPriority()-q2.getPriority());

		//Get the start index of each priority
        int p1Index = 0;
        int p2Index = list.indexOf(list.stream()
                        .filter(p -> p.getPriority()==2)
                        .findFirst().orElse(null));
        int p3Index = list.indexOf(list.stream()
                .filter(p -> p.getPriority()==3)
                .findFirst().orElse(null));

        //Get the end index of each priority
        int p1End = p2Index - 1;
        int p2End = p3Index - 1;
        int p3End = list.size() - 1 ;

        ArrayList<Question> outputList = new ArrayList<>();

        //All the uniform sets are created here
        for(Question q: list){

            outputList.add(list.get(p1Index));
            outputList.add(list.get(p2Index));
            outputList.add(list.get(p3Index));

            p1Index++;
            p2Index++;
            p3Index++;

            //If any of the index exceeds its total size, then stop.
            if(p1Index > p1End || p2Index > p2End || p3Index > p3End){
                break;
            }
        }

        //Now add the leftover questions
        while(p1Index <= p1End){
            outputList.add(list.get(p1Index));
            p1Index++;
        }
        while (p2Index <= p2End){
            outputList.add(list.get(p2Index));
            p2Index++;
        }
        while (p3Index <= p3End){
            outputList.add(list.get(p3Index));
            p3Index++;
        }

        //Print the list with all sets
        System.out.println("Output List");
        for(Question q: outputList){
            System.out.print(q.getPriority()+ " ");
			System.out.println(q.getName());
        }
    }
}

class Question{
    int id;
    int priority;
    String name;
    
    Question(int id, int priority, String name){
        this.id =id;
        this.priority =priority;
        this.name=name;
    }

    int getPriority(){
        return priority;
    }
	String getName(){
		return name;
	}
}