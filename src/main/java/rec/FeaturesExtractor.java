package rec;

import org.springframework.stereotype.Component;

/**
 * Definition of the FeaturesExtractor interface
 * 
 * @author Amaury Crickx
 * @param <T>
 *            the kind of features to extract
 */
@Component
public interface FeaturesExtractor<T> {

	/**
	 * Extracts features from given voice sample
	 * 
	 * @param voiceSample
	 *            the voice sample to analyze
	 * @return An objet of type T representing the features
	 */
	public T extractFeatures(double[] voiceSample);

}