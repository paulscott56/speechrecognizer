package rec;

import org.springframework.stereotype.Component;

/**
 * Discrete autocorrelation at lag j algorithm
 * 
 * @see <a href=
 *      "http://en.wikipedia.org/wiki/Autocorrelation">Autocorrelation</a>
 * @author Amaury Crickx
 */
@Component
public class DiscreteAutocorrelationAtLagJ {

	/**
	 * Computes discrete autocorrelation at lag j
	 * 
	 * @param buffer
	 *            the buffered signal
	 * @param lag
	 *            the lag, in the range -1 &lt; lag &lt; voiceSample size
	 * @return the computed autocorrelation result
	 */
	public double autocorrelate(double[] buffer, int lag) {
		if (lag > -1 && lag < buffer.length) {
			double result = 0.0;
			for (int i = lag; i < buffer.length; i++) {
				result += buffer[i] * buffer[i - lag];
			}
			return result;
		} else {
			throw new IndexOutOfBoundsException("Lag parameter range is : -1 < lag < buffer size. Received [" + lag
					+ "] for buffer size of [" + buffer.length + "]");
		}
	}

}