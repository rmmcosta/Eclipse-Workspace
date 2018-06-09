
public class Room implements IElement{
	@Override
	public void Accept(IVisitor visitor) {
		visitor.Visit(this);
	}
}
