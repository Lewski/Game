package Engine.Core.Noise;

import java.math.BigDecimal;

public class CraigRandom {

	private MersenneTwister Twister;

	public CraigRandom ( ) {
		Twister = new MersenneTwister ( 1234 );
	}

	public CraigRandom ( long p_seed ) {
		Twister = new MersenneTwister ( p_seed );
	}

	public void SetSeed ( long p_seed ) {
		Twister.SetSeed ( p_seed );
	}

	public static double round(double d, int decimalPlace) {
	    BigDecimal bd = new BigDecimal(d);
	    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
	    return bd.doubleValue();
	}
	
	public double RandomDouble ( ) {
		double value = ( ( double ) Twister.Random ( ) / ( double ) Long.MAX_VALUE ) * 10000000000.0;
		return value - round (value, 0);
	}

	public float RandomFloat ( ) {
		float value = ( ( float ) Twister.Random ( ) / ( float ) Long.MAX_VALUE ) * 10000000000.0f;
		return value - ( float ) round (value, 0);
	}

	public int RandomInRange ( int p_min, int p_max ) {
		if ( p_max < p_min ) {
			int temp = p_max;
			p_max = p_min;
			p_min = temp;
		}

		return p_min + ( int ) ( RandomDouble ( ) * ( ( p_max - p_min ) + 1 ) );
	}

	public float RandomInRange ( float p_min, float p_max ) {
		return p_min + ( p_max - p_min ) * RandomFloat ( );
	}
	
}
