package co.finalfour.beerme.calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public static Double calcAvg(List<Double> list) {
		
		if (!list.isEmpty()) {
			Double average = 0.0;
			for(int i = 0; i < list.size(); i++) {
				average += list.get(i);
			}
			return average / list.size();
		} else {
			return null;
		}
	}
	
	public static Double calcMean(List<Double> list) {
		
		if (!list.isEmpty()) {
			Double average = calcAvg(list);
			Double mean = 0.0;
			List<Double> over = new ArrayList<>();
			List<Double> under = new ArrayList<>();
			List<Double> even = new ArrayList<>();
			for(int i = 0; i < list.size(); i++) {
				if (list.get(i) < average) {
					under.add(list.get(i));
				} else if (list.get(i) > average) {
					over.add(list.get(i));
				} else {
					even.add(list.get(i));
				}
			}
			if (over.size() == under.size()) {
				mean = average;
			} else if (over.size() > under.size()) {
				Double minOver = over.get(0);
				for(int it = 1; it < (over.size() - under.size() + 1); it++) {
					for(int i = 1; i < over.size(); i++) {
						if (over.get(i) < minOver) {
							minOver = over.get(i);
						}
					}
					if (it < over.size() - under.size()) {
						for(int i = 0; i < over.size(); i++) {
							if (over.get(i) == minOver) {
								over.remove(i);
							}
						}					
					}
					mean = minOver;
				}		
			} else if (over.size() < under.size()) {
				Double maxUnder = under.get(0);
				for(int it = 1; it < (under.size() - over.size() + 1); it++) {
					for(int i = 1; i < under.size(); i++) {
						if (under.get(i) < maxUnder) {
							maxUnder = under.get(i);
						}
					}
					if (it < under.size() - over.size()) {
						for(int i = 0; i < under.size(); i++) {
							if (under.get(i) == maxUnder) {
								under.remove(i);
							}
						}					
					}
					mean = maxUnder;
				}			
			}
			return mean;
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
	
	public static Map<String,Double> putStats(List<List<Double>> lists) {
		
		Map<String,Double> stats = new HashMap<>();
		
		for (int i = 1, j = 0; i <= 5; i++, j++) {
			Double calc;
			calc = calcCount(lists.get(j));
			if (calc != null) {
				stats.put(i + "Count", calc);
			}
			calc = calcMin(lists.get(j));
			if (calc != null) {
				stats.put(i + "Min", calc);
			}
			calc = calcMax(lists.get(j));
			if (calc != null) {
				stats.put(i + "Max", calc);
			}
			calc = calcMean(lists.get(j));
			if (calc != null) {
				stats.put(i + "Mean", calc);
			}
			calc = calcAvg(lists.get(j));
			if (calc != null) {
				stats.put(i + "Avg", calc);
			}
				
			if (i < 5) {
				calc = calcOverlap(lists.get(j),lists.get(j + 1));
				if (calc != null) {
					stats.put(i + "overlap" + (i + 1), calc);
				}
			}
		}		
		return stats;
	}
	
}
