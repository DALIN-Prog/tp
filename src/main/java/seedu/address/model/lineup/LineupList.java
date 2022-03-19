package seedu.address.model.lineup;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineupList {
    private final List<Lineup> lineups;

    public LineupList() {
        this.lineups = new ArrayList<>();
    }

    /**
     * Overloaded constructor
     */
    public LineupList(Lineup lineup) {
        requireNonNull(lineup);
        this.lineups = copyLineups();
        lineups.add(lineup);
    }

    public List<Lineup> getLineups() {
        return lineups;
    }

    private List<Lineup> copyLineups() {
        return new ArrayList<>(lineups);
    }

    @Override
    public String toString() {
        return Stream.of(lineups).map(Object::toString).collect(Collectors.joining("; "));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof LineupList // instanceof handles nulls
                && lineups.equals(((LineupList) other).lineups));
    }
}
