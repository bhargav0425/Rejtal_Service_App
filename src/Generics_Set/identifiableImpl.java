package Generics_Set;

public class identifiableImpl implements Identifiable {

	private String id;

	public identifiableImpl() {

	}

	public identifiableImpl(String id) {
		this.id = id;
	}

	@Override
	public String getId() {

		return id;
	}

	@Override
	public String toString() {

		return id;
	}

}
