public class Base {
	public String name = "Base";
	public String getName() {
		return name;
	}
}

public class Sub extends Base {
	public String name = "sub";
	public String getName() {
		return name;
	}
}

public void main() {
	Sub s = new Sub();
	System.out.println(s.name);
	Base b = s;
	System.out.println(b.name);

	System.out.println(s.getName());
	System.out.println(b.getName());
}
