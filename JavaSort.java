import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
 
public class JavaSort 
{
    public static void main(String[] args) 
    {
        ArrayList<Question> list = new ArrayList<>();
          
          list.add(new Question(1,4,"abcd"));
          list.add(new Question(2,2,"xyz"));
          list.add(new Question(3,1,"pqr"));
          list.add(new Question(4,3,"asd"));
      
		 
         for(Question q: list){
             System.out.print(q.getPriority()+ " ");
			 System.out.println(q.getName());
			
         }

		System.out.println("After sorting by priority");
		Collections.sort(list, (Question q1, Question q2) -> q1.getPriority()-q2.getPriority());		
		
         for(Question q: list){
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