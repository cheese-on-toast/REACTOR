package simulator;

//import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Plant {
	private final static int MAX_STEAM_FLOW_RATE = 800;
	
	private String operatorName;
	private int timeStepsUsed;
	private int score;
	private List<Repair> beingRepaired;
	private boolean isPaused;
	private List<HighScore> highScores;
	private List<PlantComponent> plantComponents;
	private List<PlantComponent> failedComponents;
	private Reactor reactor;
	private List<Valve> valves;
	private List<ConnectorPipe> connectorPipes;
	private Condenser condenser;
	
	/**
	 * This is the default constructor that is used 
	 * when there is no saved game (i.e. new game)
	 */
	public Plant(String operatorName) {
		this.operatorName = operatorName;
		this.timeStepsUsed = 0;
		this.score = 0;
		this.beingRepaired = new ArrayList<Repair>();
		this.isPaused = false;
		this.highScores = new ArrayList<HighScore>(20);
		this.plantComponents = new ArrayList<PlantComponent>();
		this.failedComponents = new ArrayList<PlantComponent>();
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isPaused() {
		return isPaused;
	}

	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}
	
	public int getMaxSteamFlowRate()
	{
		return MAX_STEAM_FLOW_RATE;
	}

	public Reactor getReactor() {
		if (this.reactor != null) {
			return reactor;
		} else {
			for (PlantComponent pc : this.plantComponents) {
				if (pc instanceof Reactor) {
					this.reactor = (Reactor) pc;
					return this.reactor;
				}
			}
			return null; // No reactor found?!
		}
	}
	
	public List<Valve> getValves() {
		ArrayList<Valve> valvesList = new ArrayList<Valve>();
		if (this.valves != null) {
			return this.valves;
		} else {
			for (PlantComponent pc : this.plantComponents) {
				if (pc instanceof Valve) valvesList.add((Valve) pc);
			}
			this.valves = valvesList;
			return this.valves;
		}
	}

	public List<ConnectorPipe> getConnectorPipes()
	{
		ArrayList<ConnectorPipe> connectorPipes = new ArrayList<ConnectorPipe>();
		if (this.connectorPipes != null) {
			return this.connectorPipes;
		} else {
			for (PlantComponent pc : this.plantComponents) {
				if (pc instanceof ConnectorPipe) connectorPipes.add((ConnectorPipe) pc);
			}
			this.connectorPipes = connectorPipes;
			return this.connectorPipes;
		}
	}

	public Condenser getCondenser()
	{
		if (this.condenser != null) {
			return this.condenser;
		} else {
			for (PlantComponent pc : this.plantComponents) {
				if (pc instanceof Condenser) {
					this.condenser = (Condenser) pc;
					return this.condenser;
				}
			}
			return null; // No condenser found?!
		}
	}

	public List<HighScore> getHighScores() {
		return highScores;
	}
	
	//Possibly remove
	public void setHighScores(List<HighScore> highScores) {
		this.highScores = highScores;
	}

	public int getTimeStepsUsed() {
		return timeStepsUsed;
	}
	
	public void updateTimeStepsUsed(int n) {
		if (n > 0) timeStepsUsed += n;
	}

	public List<Repair> getBeingRepaired() {
		return beingRepaired;
	}

	public List<PlantComponent> getPlantComponents() {
		return plantComponents;
	}
	
	public void setPlantComponents(List<PlantComponent> plantComponents) {
		this.plantComponents = plantComponents;
	}
	
	public List<PlantComponent> getFailedComponents() {
		return failedComponents;
	}
	
	/**
	 * Adds failedComponent to failedComponents List, as long as it is
	 * not already in the list.
	 * 
	 * @param failedComponent
	 */
	public void addFailedComponent(PlantComponent failedComponent) {
		if (!this.failedComponents.contains(failedComponent)) {
			this.failedComponents.add(failedComponent);
		}
	}	
	
}
