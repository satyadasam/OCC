package computelogic;

import entity.ScoreHolder;
import interfaces.ComputeLogic;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComputeLogicWithTrieImpl implements ComputeLogic {

	private static final Logger logger = Logger.getLogger(ComputeLogicWithTrieImpl.class);

	@Override
	public ScoreHolder compute(String namesInFile) {

		logger.debug("::: In compute method");
		ScoreHolder scoreValue = new ScoreHolder();
		try {
			List<String> list = Arrays.stream(namesInFile.split(",")).parallel()
					.map(ss -> ss.substring(1, ss.length() - 1)).collect(Collectors.toList());
			Trie head = new Trie();
			for (String word : list) {
				insert(head, word);
			}
			Result x = new Result();
			x.order = 1;
			x.totalScore = BigDecimal.ZERO;
			preorder(head, x);
			scoreValue = new ScoreHolder(x.totalScore);
		} catch (Exception e) {
			logger.error("Error computing score " + e);
		}
		return scoreValue;
	}

	public static void insert(Trie head, String str) {
		Trie curr = head;
		int total = 0;
		for (char c : str.toCharArray()) {
			if (curr.character[c - 'A'] == null) {
				curr.character[c - 'A'] = new Trie();
			}

			total += c - 'A' + 1;
			curr = curr.character[c - 'A'];
		}
		curr.score = total;
		curr.key = str;
	}

	public static void preorder(Trie curr, Result r) {
		if (curr == null) {
			return;
		}

		for (int i = 0; i < 26; i++) {
			if (curr.character[i] != null && curr.character[i].key != null) {

				r.totalScore = r.totalScore.add(new BigDecimal(curr.character[i].score * r.order));
				r.order++;
			}

			preorder(curr.character[i], r);
		}
	}

	static class Trie {
		String key;
		int score;
		Trie[] character;

		Trie() {
			character = new Trie[26];
		}
	}

	class Result {
		BigDecimal totalScore;
		int order;
	}

}
