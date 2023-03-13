// class
public class HugeInteger {
	int[] arr = new int[40];
	public HugeInteger() {
	}
	
	public void parse(String str) {
		for (int i = 39, j = str.length() - 1; j >= 0; --i, --j)
			arr[i] = str.charAt(j) - '0';
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("                                        ");
		for (int i = 0; i < 40; ++i)
			sb.setCharAt(i, (char)(arr[i] + '0'));
		return sb.toString();
	}
	
	public void add(HugeInteger H) {
		int carry = 0;
		int[] sum = new int[40];
		for (int i = 39; i >= 0; --i) {
			sum[i] = this.arr[i] + H.arr[i] + carry;
			if (sum[i] >= 10) {
				sum[i] -= 10;
				carry = 1;
			} else
				carry = 0;
		}
		int i;
		for (i = 0; i < 40 && sum[i] == 0; ++i);
		if (i == 40)
			System.out.print(0);
		for (; i < 40; ++i)
			System.out.printf("%d", sum[i]);
		System.out.println("");
	}
	
	public void subtract(HugeInteger H) {
		int borrow = 0;
		int[] sub = new int[40];
		for (int i = 39; i >= 0; --i) {
			if (this.arr[i] - borrow >= H.arr[i]) {
				sub[i] = this.arr[i] - H.arr[i];
				borrow = 0;
			} else {
				sub[i] = 10 + this.arr[i] - H.arr[i];
				borrow = 1;
			}
		}
		if (borrow == 1) {
			System.out.println("error: negative");
			return;
		} else {
			int i;
			for (i = 0; i < 40 && sub[i] == 0; ++i);
			if (i == 40)
				System.out.print(0);
			for (; i < 40; ++i)
				System.out.printf("%d", sub[i]);
			System.out.println("");
		}
	}
	
	public boolean isEqualTo(HugeInteger H) {
		for (int i = 0; i < 40; ++i)
			if (this.arr[i] != H.arr[i])
				return false;
		return true;
	}
	
	public boolean isNotEqualTo(HugeInteger H) {
		return !this.isEqualTo(H);
	}
	
	public boolean isGreaterThan(HugeInteger H) {
		for (int i = 0; i < 40; ++i)
			if (this.arr[i] > H.arr[i])
				return true;
			else if (this.arr[i] == H.arr[i])
				continue;
			else
				return false;
		return false;
	}
	
	public boolean isLessThan(HugeInteger H) {
		return !(this.isEqualTo(H) || this.isGreaterThan(H));
	}
	
	public boolean isGreaterThanOrEqualTo(HugeInteger H) {
		return (this.isGreaterThan(H) || this.isEqualTo(H));
	}
	
	public boolean isLessThanOrEqualTo(HugeInteger H) {
		return (this.isLessThan(H) || this.isEqualTo(H));
	}
	
	public boolean isZero() {
		for (int i = 0; i < 40; i++)
			if (this.arr[i] != 0)
				return false;
		return true;
	}
}
