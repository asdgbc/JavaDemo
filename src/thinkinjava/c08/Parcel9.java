package thinkinjava.c08;

class Parcel9 {

	public Destination dest(String dest ,float price){
		return new Destination() {
			private int cost;
			{
				cost = Math.round(price);
				if (cost > 100) {
					System.out.println("Over budget!");
				}
			}
			private String label = dest;
			@Override
			public String readLabel() {
				return label;
			}
		};
	}
	
	public static void main(String[] args) {
		Parcel9 p = new Parcel9();
		Destination d = p.dest("Tanzania", 101.395f);
		
	}

}
