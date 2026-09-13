public class Race {
    private String leader = ("");
    private int leaderDistance = 0;

    public void newLeader(String carName, int speed) { // С методом помог ИИ, сам не смог додуматься
        int distance = 24 * speed;
        if (distance > leaderDistance) {
            leader = carName;
            leaderDistance = distance;

        }
    }
    public String getLeader() {
        return leader;
    }
}