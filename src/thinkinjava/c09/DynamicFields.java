package thinkinjava.c09;

class DynamicFieldsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6411976031885790185L;

}

public class DynamicFields {

	private Object[][] fields;

	public DynamicFields(int initialSize) {
		fields = new Object[initialSize][2];
		for (int i = 0; i < initialSize; i++) {
			fields[i] = new Object[] { null, null };
		}
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < fields.length; i++) {
			result.append(fields[i][0]);
			result.append(":");
			result.append(fields[i][1]);
			result.append("\n");
		}
		return result.toString();
	}

	private int hasField(String id) {
		for (int i = 0; i < fields.length; i++)
			if (id.equals(fields[i][0]))
				return i;
		return -1;
	}

	private int getFiledNumber(String id) throws NoSuchFieldException {
		int fieldNum = hasField(id);
		if (fieldNum == -1) {
			throw new NoSuchFieldException();
		}
		return fieldNum;
	}

	private int makeFiled(String id) {
		for (int i = 0; i < fields.length; i++) {
			if (fields[i][0] == null) {
				fields[i][0] = id;
				return i;
			}
		}
		Object[][] tmp = new Object[fields.length + 1][2];
		for (int i = 0; i < fields.length; i++) {
			tmp[i] = fields[i];
		}
		for (int i = fields.length; i < tmp.length; i++) {
			tmp[i] = new Object[] { null, null };
		}
		fields = tmp;
		return makeFiled(id);
	}

	public Object getField(String id) throws NoSuchFieldException {
		return fields[getFiledNumber(id)][1];
	}

	public Object setField(String id, Object value)
			throws DynamicFieldsException {
		if (value == null) {
			DynamicFieldsException dfe = new DynamicFieldsException();
			dfe.initCause(new NullPointerException());
			throw dfe;
		}
		int fieldNumber = hasField(id);
		if (fieldNumber == -1) {
			fieldNumber = makeFiled(id);
		}
		Object result = null;
		try {
			result = getField(id);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		}
		fields[fieldNumber][1] = value;
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DynamicFields df = new DynamicFields(3);
		System.out.println(df);
		try {
			df.setField("d", "A value for d");
			df.setField("number", new Integer(47));
			df.setField("number2", new Integer(48));
			System.out.println(df);
			df.setField("d", "A new value for d");
			df.setField("number3", new Integer(11));
			System.out.println(df);
			System.out.println(df.getField("d"));
			Object field = df.getField("a3");
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (DynamicFieldsException e) {
			throw new RuntimeException(e);
		}
	}

}
