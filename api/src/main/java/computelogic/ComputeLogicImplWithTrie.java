package computelogic;

import entity.ScoreHolder;
import interfaces.ComputeLogic;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComputeLogicImplWithTrie implements ComputeLogic {

    private static final Logger logger = Logger.getLogger(ComputeLogicImplWithTrie.class);

    @Override
    public ScoreHolder compute(String namesInFile) {

        logger.debug("::: In compute method");
        ScoreHolder scoreValue = new ScoreHolder();

        try {
            List<String> list = Arrays.stream(namesInFile.split(","))
                    .parallel().map(ss -> ss.substring(1, ss.length() - 1))
                    .collect(Collectors.toList());

            Trie head = new Trie();

            // insert all keys of a dictionary into a Trie
            for (String word : list) {
                insert(head, word);
            }

            // print keys in lexicographic order
            Result x = new Result();
            x.order = 1;
            x.totalScore = BigDecimal.ZERO;
            preorder(head, x);
            scoreValue = new ScoreHolder(x.totalScore);
        }
        catch (Exception e){
            logger.error("Error computing score " + e);
        }
        return scoreValue;
    }


    public static void insert(Trie head, String str)
    {
        // start from the root node
        Trie curr = head;
        int total=0;
        for (char c: str.toCharArray())
        {
            // create a new node if the path doesn't exist
            if (curr.character[c - 'A'] == null) {
                curr.character[c - 'A'] = new Trie();
            }

            total += c-'A' + 1;
            // go to the next node
            curr = curr.character[c - 'A'];
        }

        // store key in the leaf node
        curr.score =total;
        curr.key = str;
    }

    public static void preorder(Trie curr, Result r)
    {
        // return if Trie is empty
        if (curr == null) {
            return;
        }

        for (int i = 0; i < 26; i++)
        {
            if (curr.character[i] != null && curr.character[i].key != null) {

                r.totalScore = r.totalScore.add(new BigDecimal(curr.character[i].score * r.order));
                r.order++;
            }

            preorder(curr.character[i], r);
        }
    }

    static class Trie
    {
        String key;        // non-empty when node is a leaf node
        int score;
        Trie[] character;

        // Constructor
        Trie()
        {
            // Trie supports uppercase English characters `A – Z`.
            // So, the character size is 26.
            character = new Trie[26];
        }
    }

    class Result{
        BigDecimal totalScore;
        int order;
    }


}
