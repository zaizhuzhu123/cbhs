package cbhs;

import java.math.BigDecimal;

import javax.jdo.annotations.Join;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class Test {
	private BigDecimal num1;

	public BigDecimal getNum1() {
		return num1;
	}

	public void setNum1(BigDecimal num1) {
		this.num1 = num1;
	}

	@Override
	public String toString() {
		return "Test [num1=" + num1 + "]";
	}

	public static void main(String[] args) {
		// Test test = new Test();
		// test.setNum1(new BigDecimal("1.0000000001"));
		// System.out.println(JSON.toJSONString(test));

		// Test test =
		// JSON.parseObject("{\"num1\":1.00000000000000000000000000000001}",
		// Test.class);
		// System.out.println(test.toString());

		System.out.println("|" + Joiner.on("|").skipNulls().join(Lists.newArrayList(1, 2)).replace("|", "||") + "|");

		BigDecimal bd = new BigDecimal("1.1000000");
		System.out.println(bd);
		System.out.println(bd.stripTrailingZeros());
	}
}
