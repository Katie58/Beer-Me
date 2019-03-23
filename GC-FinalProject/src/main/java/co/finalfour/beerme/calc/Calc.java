package co.finalfour.beerme.calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import co.finalfour.beerme.entity.beer.Beer;

public class Calc {

	final private static Double rating1 = -100.0;
	final private static Double rating2 = -50.0;
	final private static Double rating3 = 0.0;
	final private static Double rating4 = 50.0;
	final private static Double rating5 = 100.0;
	
	public static Double getMultiplier(Integer rating) {
		
		Double multiplier = null;
		
		switch(rating) {
		case 1: multiplier = rating1;
			break;
		case 2: multiplier = rating2;
			break;
		case 3: multiplier = rating3;
			break;
		case 4: multiplier = rating4;
			break;
		case 5: multiplier = rating5;
			break;
		}
		
		return multiplier;
	}
	
	public static Double addToRatio(Integer rating, Integer count, Double ratio) {
		
		Double multiplier = getMultiplier(rating);
		
		if (count != 0 && count != null) {
			ratio = ((ratio * count) + multiplier) / (count + 1);
		} else {
			ratio = multiplier;
		}		
		
		return ratio;
	}
	
	public static Double deleteFromRatio(Integer rating, Integer count, Double ratio) {
		
		if (count == 1) {
			return null;
		}
		
		Double multiplier = getMultiplier(rating);
		
		if (count != 0 && count != null) {
			ratio = ((ratio * count) - multiplier) / (count - 1);
		} else {
			ratio = multiplier;
		}		
		
		return ratio;
	}
	
	public static Map<String,Double> getIbuStats(List<Beer> beers) {
		
		List<List<Double>> lists = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			lists.add(new ArrayList<>());
		}
		
		for(Beer beer : beers) {
			if (beer.getRating() != null && beer.getRating() != 0) {
				switch(beer.getRating()) {
				case 1: lists.get(0).add(beer.getIbu());
					break;
				case 2: lists.get(1).add(beer.getIbu());
					break;
				case 3: lists.get(2).add(beer.getIbu());
					break;
				case 4: lists.get(3).add(beer.getIbu());
					break;
				case 5: lists.get(4).add(beer.getIbu());
					break;
				}
			}
		}	
		return putStats(lists);		
	}
	
	public static Map<String,Double> getAbvStats(List<Beer> beers) {
		
		List<List<Double>> lists = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			lists.add(new ArrayList<>());
		}
		
		for(Beer beer : beers) {
			if (beer.getRating() != null && beer.getRating() != 0) {
				switch(beer.getRating()) {
				case 1: lists.get(0).add(beer.getAbv());
					break;
				case 2: lists.get(1).add(beer.getAbv());
					break;
				case 3: lists.get(2).add(beer.getAbv());
					break;
				case 4: lists.get(3).add(beer.getAbv());
					break;
				case 5: lists.get(4).add(beer.getAbv());
					break;
				}
			}
		}	
		return putStats(lists);		
	}
	
	public static Map<String,Double> getOriginalGravityStats(List<Beer> beers) {
		
		List<List<Double>> lists = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			lists.add(new ArrayList<>());
		}
		
		for(Beer beer : beers) {
			if (beer.getRating() != null && beer.getRating() != 0) {
				switch(beer.getRating()) {
				case 1: lists.get(0).add(beer.getOriginalGravity());
					break;
				case 2: lists.get(1).add(beer.getOriginalGravity());
					break;
				case 3: lists.get(2).add(beer.getOriginalGravity());
					break;
				case 4: lists.get(3).add(beer.getOriginalGravity());
					break;
				case 5: lists.get(4).add(beer.getOriginalGravity());
					break;
				}
			}
		}	
		return putStats(lists);		
	}
	
	public static Double calcCount(List<Double> list) {
		
		if (!list.isEmpty()) {
			return (double) list.size();
		} else {
			return null;
		}
	}
	
	public static Double calcMin(List<Double> list) {
		
		if (!list.isEmpty()) {
			Double min = list.get(0);
			for(int i = 1; i < list.size(); i++) {
				if (list.get(i) < min) {
					min = list.get(i);
				}
			}
			return min;
		} else {
			return null;
		}
	}
	
	public static Double calcMax(List<Double> list) {
		
		if (!list.isEmpty()) {
			Double max = list.get(0);
			for(int i = 1; i < list.size(); i++) {
				if (list.get(i) > max) {
					max = list.get(i);
				}
			}
			return max;
		} else {
			return null;
		}
	}
	
	public static Integer calcMaxCount(Map<Double,Integer> map) {
		
		if (!map.isEmpty()) {
			int max = 0;
			for (Entry<Double, Integer> m : map.entrySet()) {
				if (m.getValue() > max) {
					max = m.getValue();
				}
			}
			return max;
		} else {
			return null;
		}
	}
	
	public static Double calcMean(List<Double> list) {
		
		if (!list.isEmpty()) {
			Double mean = 0.0;
			for(int i = 0; i < list.size(); i++) {
				mean += list.get(i);
			}
			return mean / list.size();
		} else {
			return null;
		}
	}
	
	public static Double calcMedian(List<Double> list) {
		
		if (!list.isEmpty()) {
			if (list.size() == 1) {
				return list.get(0);
			}
			int half = ((list.size() % 2) == 0) ? (list.size() / 2) : (int) ((list.size() / 2) - 0.5);
			return (list.get(half) + list.get(half + 1)) / 2;
		} else {
			return null;
		}
	}
	
	public static Double calcOverlap(List<Double> one, List<Double> two) {
		
		if (!one.isEmpty() && !two.isEmpty()) {
			return calcMax(one) - calcMin(two);
		} else {
			return null;
		}
	}
	
	public static List<Double> calcMode(List<Double> list) {
		
		Map<Double, Integer> map = new HashMap<>();
		List<Double> returnList = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Double d : list) {
				if (map.containsKey(d)) {
					map.put(d, map.get(d) + 1);
				} else {
					map.put(d, 1);
				}
			}
			int max = calcMaxCount(map);
			for (Entry<Double, Integer> m : map.entrySet()) {
				if (m.getValue() == max) {
					returnList.add(m.getKey());
				}
			}
			return returnList;
		} else {
			return null;
		}
	}
	
	public static Map<String,Double> putStats(List<List<Double>> lists) {
		
		Map<String,Double> stats = new HashMap<>();
		
		for (int i = 1; i <= 5; i++) {
			Double calc;
			calc = calcCount(lists.get(i - 1));
			if (calc != null) {
				System.out.println("calcCount");
				stats.put(i + "Count", calc);
			}
			calc = calcMin(lists.get(i - 1));
			if (calc != null) {
				System.out.println("calcMin");
				stats.put(i + "Min", calc);
			}
			calc = calcMax(lists.get(i - 1));
			if (calc != null) {
				System.out.println("calcMax");
				stats.put(i + "Max", calc);
			}
			calc = calcMean(lists.get(i - 1));
			if (calc != null) {
				stats.put(i + "Mean", calc);
			}
			calc = calcMedian(lists.get(i - 1));
			if (calc != null) {
				System.out.println("calcMedian");
				stats.put(i + "Median", calc);
			}
			List<Double> calcList = calcMode(lists.get(i - 1));
			if (calcList != null) {
				System.out.println("calcList size: " + calcList.size());
				for (int x = 0; x < calcList.size(); x++) {
					stats.put(i + "Mode" + (x + 1), calcList.get(x));
				}				
			}
				
			if (i < 5) {
				calc = calcOverlap(lists.get(i - 1), lists.get(i));
				if (calc != null) {
					stats.put(i + "overlap" + (i + 1), calc);
				}
			}

		}		
		return stats;
	}
	
}
