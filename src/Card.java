public class Card {
	private Value value;
	private Color color;
	
	public Card(Value value, Color color){
		this.color =  color;
		this.value = value;
	}
	
	public String toString()
	{
		return value.getSymbole() + color.getSymbole();
	}
	
	public String getColorSymbole()
	{
		return color.getSymbole();
	}
	public String getValueSymbole()
	{
		return value.getSymbole();
	}
	public String getColorName()
	{
		return color.name();
	}
	public int getPoints() {
		return value.getPoints();
	}
}
