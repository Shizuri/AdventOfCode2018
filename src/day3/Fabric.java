package day3;

public class Fabric {

	private int id;
	private int fromTheLeft;
	private int fromTheTop;
	private int width;
	private int height;
	
	public Fabric(int id, int fromTheLeft, int fromTheTop, int width, int height) {
		super();
		this.id = id;
		this.fromTheLeft = fromTheLeft;
		this.fromTheTop = fromTheTop;
		this.width = width;
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFromTheLeft() {
		return fromTheLeft;
	}

	public void setFromTheLeft(int fromTheLeft) {
		this.fromTheLeft = fromTheLeft;
	}

	public int getFromTheTop() {
		return fromTheTop;
	}

	public void setFromTheTop(int fromTheTop) {
		this.fromTheTop = fromTheTop;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Fabric [id=" + id + ", fromTheLeft=" + fromTheLeft + ", fromTheTop=" + fromTheTop + ", width=" + width
				+ ", height=" + height + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fromTheLeft;
		result = prime * result + fromTheTop;
		result = prime * result + height;
		result = prime * result + id;
		result = prime * result + width;
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
		Fabric other = (Fabric) obj;
		if (fromTheLeft != other.fromTheLeft)
			return false;
		if (fromTheTop != other.fromTheTop)
			return false;
		if (height != other.height)
			return false;
		if (id != other.id)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	
	
}
