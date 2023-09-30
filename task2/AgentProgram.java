package task2;

public class AgentProgram {
    public Action execute(Percept p) {
        if (p.getLocationState().equals(Environment.LocationState.DIRTY)) {
            return Environment.SUCK_DIRT;
        } else if (p.getAgentLocation().equals(Environment.LOCATION_A)) {
            return Environment.MOVE_RIGHT;
        } else if (p.getAgentLocation().equals(Environment.LOCATION_B)) {
            return Environment.MOVE_DOWN; // Đi xuống từ ô B
        } else if (p.getAgentLocation().equals(Environment.LOCATION_C)) {
            return Environment.MOVE_LEFT; // Đi trái từ ô C
        } else if (p.getAgentLocation().equals(Environment.LOCATION_D)) {
            return Environment.MOVE_UP; // Đi lên từ ô D
        }
        return NoOpAction.NO_OP;
    }
}
