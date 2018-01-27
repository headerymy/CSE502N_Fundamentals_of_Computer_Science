package dh.utils;

import dh.DH;

/**
 * Generate Diffie--Hellman results with the same base and modulus
 * @author roncytron
 *
 */
public class DHFactory {
	
	//
	// Some convenient constants
	//
	public static final long 
		LARGEPRIME = 1567675554L,
		SMALLPRIME = 23,
		BASE = 5;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (base ^ (base >>> 32));
		result = prime * result + (int) (modulus ^ (modulus >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DHFactory other = (DHFactory) obj;
		if (base != other.base)
			return false;
		if (modulus != other.modulus)
			return false;
		return true;
	}

	public final long base, modulus;
	
	/**
	 * 
	 * @param base
	 * @param modulus
	 */
	public DHFactory(long base, long modulus) {
		this.base    = base;
		this.modulus = modulus;
	}
	
	public DH nextDH(long privKey) {
		return new DH(base, privKey, modulus);
	}

}
