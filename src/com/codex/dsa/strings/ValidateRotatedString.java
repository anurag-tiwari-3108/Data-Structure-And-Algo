package com.codex.dsa.string;

public class ValidateRotatedString {

	public static void main(String[] args) {

//		System.out.println("Does String 1 derived from String 2 via rotation " + isRotatedVersion("ABCD", "DABC"));
		System.out.println("Does String 1 derived from String 2 via rotation " + isRotated("ABCD", "DABC"));
	}

	// Method-1 with extra space. Space Complexity O(n)
	public static boolean isRotatedVersion(String str, String rotated) {
		if ((str == null || rotated == null) || (str.length() != rotated.length())) {
			return false;
		} else {
			return (str + str).contains(rotated);
		}
	}
	// Method-1 with extra space. Space Complexity O(1)
	public static boolean isRotated(String input, String rotated) {
		if ((input == null || rotated == null) || (input.length() != rotated.length())) {
			return false;
		}
        int index = rotated.indexOf(input.charAt(0));
        if (index > -1) {
            if (input.equalsIgnoreCase(rotated)) {
                return true;
            }
            int finalPos = rotated.length() - index;
            System.out.println("Index - "+index + " Rotated "+rotated+" finalPos "+finalPos+ "  1 "+rotated.charAt(0) +" 2 "+input.charAt(finalPos));

            return rotated.charAt(0) == input.charAt(finalPos)
                    && input.substring(finalPos).equals(
                            rotated.substring(0, index));
        }
        return false;

    }
}