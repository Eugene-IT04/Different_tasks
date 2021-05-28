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
        LinkedList<String> queue = new LinkedList<>();
        List<String> searched = new LinkedList<>();
        queue.add("you");
        while(!queue.isEmpty()){
            String queuePoll = queue.pollFirst();
            if(!searched.contains(queuePoll)) {
                searched.add(queuePoll);
                System.out.println(queuePoll);
                Collections.addAll(queue, graph.get(queuePoll));
            }
        }

        //depth first search
        System.out.println("\nDFS:");
        LinkedList<String> stack = new LinkedList<>();
        List<String> searched2 = new LinkedList<>();
        stack.add("you");
        while(!stack.isEmpty()){
            String stackPop = stack.pollLast();
            if(!searched2.contains(stackPop)) {
                searched2.add(stackPop);
                System.out.println(stackPop);
                Collections.addAll(stack, graph.get(stackPop));
            }
        }

    }
}

