package simulator;

class Condenser extends PlantComponent {
	private final static int MAX_TEMPERATURE = 2000;
	private final static int MAX_PRESSURE = 500;
	private final static int MAX_HEALTH = 100;
	private final static int DEFAULT_TEMPERATURE = 0;
	private final static int DEFAULT_PRESSURE = 0;
	private final static int DEFAULT_WATER_LEVEL = 1000;
	private final static int DEFAULT_STEAM_INPUT = 0;
	private final static int DAMAGE_PER_TURN = 10;
	private int temperature;
	private int pressure;
	private int waterLevel;
	private int health;
	private int steamInput;

	Condenser() {
		this.health = MAX_HEALTH;
		this.temperature = DEFAULT_TEMPERATURE;
		this.pressure = DEFAULT_PRESSURE;
		this.waterLevel = DEFAULT_WATER_LEVEL;
		this.steamInput = DEFAULT_STEAM_INPUT;
	}

	@Override
	public void updateState() {
	}


	@Override
	public boolean checkFailure() {
		if(pressure >= MAX_PRESSURE) {
			damageCondenser();			// Method to damage Condenser
		}
		return super.checkFailure();

	}
	
	public void damageCondenser() {
		health = health - DAMAGE_PER_TURN;
		if (health <= 0) {
			//code to end game
		}
	}
}
