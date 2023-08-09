class IITNagpur
{
	public static void main(String[] args) 
	{
		System.out.println("IITNagpur");
	}
}
class singleinheritance extends IITNagpur
{
	public static void main(String[] args) 
	{
		System.out.println("Single inheritance");
	}
}
interface multipleinheritance extends IITNagpur
{
	public static void main(String[] args) 
	{
		System.out.println("Multiple inheritance using interface");
	}
}
class InterarchicaInheritance extends multipleinheritance
{
	public static void main(String[] args) 
	{
		System.out.println("Interarchica Inheritance");
	}
}
class Multilevelinheritance extends InterarchicaInheritance
{
	public static void main(String[] args) 
	{
		System.out.println("Multilevel inheritance");
	}
}