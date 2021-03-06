package Engine.Core.Noise;

public class MersenneTwister {
	private static int N = 624;
	private static int M = 397;

	private static long MatrixA = 0x9908b0df;
	private static long UpperMask = 0x80000000;
	private static long LowerMask = 0x7fffffff;

	private static long TemperingMaskB = 0x9d2c5680;
	private static long TemperingMaskC = 0xefc60000;

	private long[] mt = new long[ N ];
	private int mti = N + 1;

	private long Seed;

	public MersenneTwister ( ) {
		Seed = 1234;
		SetSeed ( Seed );
	}

	public MersenneTwister ( long p_seed ) {
		Seed = p_seed;
		SetSeed ( Seed );
	}

	public void SetSeed ( long p_seed ) {
		mt [ 0 ] = p_seed & 0xffffffff;
		for ( mti = 1; mti < N; mti++ ) {
			mt [ mti ] = ( 69069 * mt [ mti - 1 ] ) & 0xffffffff;
		}

		Seed = p_seed;
	}

	public long Random ( ) {
		long y;
		long[] mag01 = { 0x0, MatrixA };

		if ( mti >= N ) {
			int kk;

			if ( mti == N + 1 ) {
				SetSeed ( 4357 );
			}

			for ( kk = 0; kk < N - M; kk++ ) {
				y = ( mt [ kk ] & UpperMask ) | ( mt [ kk + 1 ] & LowerMask );
				mt [ kk ] = mt [ kk + M ] ^ ( y >> 1 ) ^ mag01 [ (int) (y & 0x1) ];
			}

			for (; kk < N - 1; kk++ ) {
				y = ( mt [ kk ] & UpperMask ) | ( mt [ kk + 1 ] & LowerMask );
				mt [ kk ] = mt [ kk + ( M - N ) ] ^ ( y >> 1 ) ^ mag01 [ (int) (y & 0x1) ];
			}

			y = ( mt [ N - 1 ] & UpperMask ) | ( mt [ 0 ] & LowerMask );
			mt [ N - 1 ] = mt [ M - 1 ] ^ ( y >> 1 ) ^ mag01 [ (int) (y & 0x1) ];
		
			mti = 0;
		}

		y = mt [ mti++ ];
		y ^= TemperingShiftU ( y );
		y ^= TemperingShiftS ( y ) & TemperingMaskB;
		y ^= TemperingShiftT ( y ) & TemperingMaskC;
		y ^= TemperingShiftL ( y );

		return y;
	}

	private long TemperingShiftU ( long p_value ) {
		return p_value >> 11;
	}

	private long TemperingShiftS ( long p_value ) {
		return p_value << 7;
	}

	private long TemperingShiftT ( long p_value ) {
		return p_value << 15;
	}

	private long TemperingShiftL ( long p_value ) {
		return p_value >> 18;
	}
}
