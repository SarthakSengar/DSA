import java.util.ArrayList;
import java.util.List;

public class _32_mergeOverlapping {
    static List<List<Integer>> Merger(List<List<Integer>> arr) {
    List<List<Integer>> answer = new ArrayList<>();
    if (arr.isEmpty()) return answer;

    // 1. Sort intervals by start
    arr.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));

    // 2. Iterate and merge
    for (List<Integer> curr : arr) {
        if (answer.isEmpty() || answer.get(answer.size()-1).get(1) < curr.get(0)) {
            answer.add(new ArrayList<>(curr));
        } 
        else {
            List<Integer> last = answer.get(answer.size()-1);
            last.set(1, Math.max(last.get(1), curr.get(1))); // merge intervals
        }
    }

    return answer;
}
    public static void main(String[] args) {
        
    }
}
