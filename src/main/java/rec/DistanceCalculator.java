package rec;

import org.springframework.stereotype.Component;

/**
 * Abstract base class for distance calculators
 * 
 * @author Amaury Crickx
 */
@Component
public abstract class DistanceCalculator {

	public abstract double getDistance(double[] features1, double[] features2);

	/**
	 * Nullity check of parameters
	 * 
	 * @param features1
	 *            the first features vector
	 * @param features2
	 *            the secund features vector
	 * @return Double.POSITIVE_INFINITY in case either or both of the vectors
	 *         are null, a negative number otherwise
	 */
	protected double positiveInfinityIfEitherOrBothAreNull(double[] features1, double[] features2) {
		if (features1 == null || features2 == null) {
			return Double.POSITIVE_INFINITY;
		} else {
			return -1.0d;
		}
	}
}