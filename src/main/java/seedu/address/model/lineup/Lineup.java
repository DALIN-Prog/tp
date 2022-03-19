package seedu.address.model.lineup;

/**
 * Represents a lineup in a team.
 * Guarantees: lineupName is present and not null, up to 5 players per lineup.
 */
public class Lineup {

    private final LineupName lineupName;

    public Lineup(LineupName lineupName) {
        this.lineupName = lineupName;
    }

    public LineupName getLineupName() {
        return lineupName;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getLineupName());
        return builder.toString();
    }

}
