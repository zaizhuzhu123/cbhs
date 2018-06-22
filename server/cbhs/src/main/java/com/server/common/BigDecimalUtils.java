package com.server.common;

import java.math.BigDecimal;

public class BigDecimalUtils {

	public static BigDecimal getSub(BigDecimal ys, BigDecimal used, BigDecimal this_) {
		ys = ys != null ? ys : new BigDecimal(0);
		used = used != null ? used : new BigDecimal(0);
		this_ = this_ != null ? this_ : new BigDecimal(0);
		if (this_.compareTo(BigDecimal.ZERO) == 0) {
			return new BigDecimal(0);
		}
		return ys.subtract(used).subtract(this_);
	}

	public static boolean goe(BigDecimal ys, Integer i) {
		ys = ys != null ? ys : new BigDecimal(0);
		return (ys.compareTo(new BigDecimal(i))) >= 0;
	}

	public static boolean gt(BigDecimal ys, Integer i) {
		ys = ys != null ? ys : new BigDecimal(0);
		return (ys.compareTo(new BigDecimal(i))) > 0;
	}

	public static boolean lt(BigDecimal ys, Integer i) {
		ys = ys != null ? ys : new BigDecimal(0);
		return (ys.compareTo(new BigDecimal(i))) < 0;
	}
}
