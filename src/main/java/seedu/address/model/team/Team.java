package seedu.address.model.team;

import seedu.address.model.lineup.Lineup;
import seedu.address.model.person.Person;

/**
 * Represents a basketball Team in MyGM
 */

public class Team {
    private final TeamName teamName;
    private final TeamMemberList teamMemberList;
    private final TeamLineupList teamLineupList;

    /**
     * Constructs a {@code Team}
     *
     * @param teamName A valid team name
     * @param teamMemberList A teamList contains the team members
     */
    public Team(TeamName teamName, TeamMemberList teamMemberList) {
        this.teamName = teamName;
        this.teamMemberList = teamMemberList;
        this.teamLineupList = new TeamLineupList();
    }

    public Team(TeamName teamName, TeamMemberList teamMemberList, TeamLineupList teamLineupList) {
        this.teamName = teamName;
        this.teamMemberList = teamMemberList;
        this.teamLineupList = teamLineupList;
    }

    /**
     * Gets the team name.
     */
    public TeamName getTeamName() {
        return this.teamName;
    }

    /** Adds a lineup into this team
     *
     * @param lineup The lineup to be added
     */
    public void addLineupToTeam(Lineup lineup) {
        this.teamLineupList.addLineupToList(lineup);
    }

    /**
     * Puts a player into this team
     *
     * @param person The player to be added
     */
    public void putPersonToTeam(Person person) {
        this.teamMemberList.putToTeamList(person);
    }

    /**
     * Puts a player in this team into a lineup in this team
     *
     * @param lineup The lineup to add player
     * @param person The player to be added
     */
    public void putPersonToLineup(Lineup lineup, Person person) {
        if (this.teamLineupList.containsLineup(lineup) && this.teamMemberList.containsPerson(person)) {
            lineup.addPlayer(person);
        }
    }

    public TeamName getTeamName() {
        return this.teamName;

    public void deletePersonFromTeam(Person person) {
        this.teamMemberList.deletePersonFromTeam(person);
    }

    public TeamName getTeamName() {
        return teamName;
    }

    public TeamMemberList getTeamMemberList() {
        return teamMemberList;
    }

    public TeamLineupList getTeamLineupList() {
        return teamLineupList;

    /**
     * Removes a player.
     */
    public void removePlayer(Person person) {
        // meanwhile, should also remove from lineup
        this.teamMemberList.removePerson(person);
    }

    /**
     * Removes a lineup.
     */
    public void removeLineup(String lineup) {
        return;
    }
}
