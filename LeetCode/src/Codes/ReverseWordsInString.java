package Codes;

public class ReverseWordsInString {
	public static void main(String[] args) {
		ReverseWordsInString r = new ReverseWordsInString();
		System.out.println(r.reverseWords(r.trimString("      ")));
	}

	public String reverseWords(String s) {

		int length = s.length();
		int space = 0;
		int stop = length - 1;
		int hasCharacter = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = length - 1; i >= 0; i--) {
			if (Character.isWhitespace(s.charAt(i))) {
				space = i;
				append(sb, s, i + 1, stop, true);
				stop = space - 1;
			} else {
				hasCharacter++;
			}

		}
		append(sb, s, 0, space - 1, false);
		if (hasCharacter == 0) {
			return "";
		} else if (space == 0) {
			return s;

		} else {
			return sb.toString();
		}
	}

	public void append(StringBuffer sb, String s, int start, int stop, boolean b) {
		if (start > stop) {
			return;
		}
		sb.append(s.substring(start, stop + 1));
		if (b) {
			sb.append(" ");
		}
	}

	public String trimString(String s) {
		int length = s.length();
		int start = 0;
		while (s.charAt(start) == ' ' && start < length) {
			start++;
		}
		int last = s.length() - 1;
		while (s.charAt(last) == ' ' && last < length) {
			last--;
		}

		String trimmed;
		if (start == 0 && last == 0) {
			trimmed = s;
		} else {
			trimmed = s.substring(start, last + 1);
		}
		return trimmed;
	}
}