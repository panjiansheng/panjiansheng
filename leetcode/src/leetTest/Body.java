package leetTest;

import java.nio.channels.NonWritableChannelException;

public class Body {
	static int nextID = 1;
	String name;
	String sex;

	public Body(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}

	public Body(String name) {
		this(name, "女");
	}

	public static String getName(Body t) {
		return t.name;
	}

	public static String getSex(Body t) {
		return t.sex;
	}

	public static Info getInfo(Body t) {
		Info info = new Info();
		info.name = getName(t);
		info.sex = getSex(t);
		return info;
	}

	public static void main(String[] args) {
		Body A = new Body("史琼");
		Body B = new Body("潘建胜", "男");
		Body C = new Body("aaa");
		C = A;
		Info s = Body.getInfo(A);
		System.out.println(s);
	}

}

class Info {
	public String name, sex;

	@Override
	public String toString() {
		return "Info [name=" + name + ", sex=" + sex + "]";
	}

}
