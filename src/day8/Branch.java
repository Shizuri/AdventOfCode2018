package day8;

import java.util.ArrayList;
import java.util.List;

public class Branch {

	private int numberOfChildren;
	private int numberOfMetadata;
	private List<Integer> metadatas = new ArrayList<>();
	private int index;
	private int length;
	private int parentIndex;

	public Branch(int numberOfChildren, int numberOfMetadata, int index) {
		super();
		this.numberOfChildren = numberOfChildren;
		this.numberOfMetadata = numberOfMetadata;
		this.index = index;
		length = numberOfMetadata + 2;
	}

	@Override
	public String toString() {
		return "Branch [numberOfChildren=" + numberOfChildren + ", numberOfMetadata=" + numberOfMetadata
				+ ", metadatas=" + metadatas + ", index=" + index + ", length=" + length + "]";
	}

	public int getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public int getNumberOfMetadata() {
		return numberOfMetadata;
	}

	public void setNumberOfMetadata(int numberOfMetadata) {
		this.numberOfMetadata = numberOfMetadata;
	}

	public List<Integer> getMetadatas() {
		return metadatas;
	}

	public void setMetadatas(List<Integer> metadatas) {
		this.metadatas = metadatas;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getParentIndex() {
		return parentIndex;
	}

	public void setParentIndex(int parentIndex) {
		this.parentIndex = parentIndex;
	}

}
