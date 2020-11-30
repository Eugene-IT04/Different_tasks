import java.util.*;

public class GraphAlgorithms {

    public static void main(String[] args){
        HashMap<String, String[]> graph = new HashMap<>();
        graph.put("you", new String[] {"alice", "bob", "claire"});
        graph.put("bob", new String[] {"anuj", "peggy"});
        graph.put("alice", new String[] {"peggy"});
        graph.put("claire", new String[] {"thom", "jonny"});
        graph.put("anuj", new String[] {});
        graph.put("peggy", new String[] {});
        graph.put("thom", new String[] {});
        graph.put("jonny", new String[] {});

        //breadth first search
        System.out.println("BFS:");
        Queue<String> queue = new LinkedList<>();
        List<String> searched = new Vector<>();
        queue.add("you");
        while(queue.size() != 0){
            String queuePoll = queue.poll();
            if(!searched.contains(queuePoll)) {
                searched.add(queuePoll);
                System.out.println(queuePoll);
                Collections.addAll(queue, graph.get(queuePoll));
            }
        }

        //depth first search
        System.out.println("\nDFS:");
        Stack<String> stack = new Stack<>();
        List<String> searched2 = new Vector<>();
        stack.add("you");
        while(!stack.empty()){
            String stackPop = stack.pop();
            if(!searched2.contains(stackPop)) {
                searched2.add(stackPop);
                System.out.println(stackPop);
                Collections.addAll(stack, graph.get(stackPop));
            }
        }

    }
}

