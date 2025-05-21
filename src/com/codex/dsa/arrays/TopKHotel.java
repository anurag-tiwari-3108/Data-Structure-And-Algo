package com.codex.dsa.arrays;

/**
 * https://pragmaticdeveloper.info/award-top-k-hotels/
	Booking.com OA
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKHotel {
	public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords,
			List<Integer> hotelIds, List<String> reviews, int k) {
		List<String> positiveReviewsToken = Arrays.asList(positiveKeywords.split(" "));
		List<String> negativeReviewsToken = Arrays.asList(negativeKeywords.split(" "));
		Map<Integer, Integer> positiveReview = new HashMap<>();
		for (int i = 0; i < reviews.size(); i++) {
			int hotelId = hotelIds.get(i);
			List<String> review = Arrays.asList(reviews.get(i).split(" "));
			int currentPositive = (int) review.stream().filter(token -> positiveReviewsToken.contains(token)).count();
			int currentNegative = (int) review.stream().filter(token -> negativeReviewsToken.contains(token)).count();
			int total = currentPositive * 3 + currentNegative * -1;
			int previous = positiveReview.getOrDefault(hotelId, 0);
			positiveReview.put(hotelId, previous + total);
		}
		List<Integer> topHotel = positiveReview.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(k).map(Map.Entry::getKey)
				.collect(Collectors.toList());
		return topHotel;
	}
}
